/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app;


import constraints.StockPriceConstraint;
import constraints.TweetConstraint;
import filters.OnlyNPTweets;
import filters.OnlyTEMTweets;
import filters.OnlyTSLAFilter;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.cep.CEP;
import org.apache.flink.cep.PatternSelectFunction;
import org.apache.flink.cep.PatternStream;
import org.apache.flink.cep.pattern.Pattern;
import org.apache.flink.cep.pattern.conditions.IterativeCondition;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer08;
import pojos.StockPrice;
import pojos.StockPriceUp;
import pojos.Tweet;
import sources.SingleStockSource;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.twitter.TwitterSource;
import sources.TwitterTermsSource;
import sources.TwitterUsersSource;
import translations.StockPriceTranslation;
import translations.TweetTranslation;


import java.util.List;
import java.util.Map;
import java.util.Properties;

public class StreamingJob {

	public static void main(String[] args) throws Exception {

		Properties props = new Properties();
		props.setProperty(TwitterSource.CONSUMER_KEY, "qzNlqrFckPFTsp6bQchKlhI3o");
		props.setProperty(TwitterSource.CONSUMER_SECRET, "mQMxCb2mb9NBkxZ28ozV9HV2oyEwfkVdSYDJgOPa6suGKPvBDZ");
		props.setProperty(TwitterSource.TOKEN, "1006501086100942848-uvX2b6VJq0y5rzZLmNlKQSadbqRJGY");
		props.setProperty(TwitterSource.TOKEN_SECRET, "0O4CvsXeKUof13lkPFaLIwdG8pD7MtlOWq6ES9gyULR6A");

		// set up the streaming execution environment
		StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

		// set up twitter terms sources
        TwitterSource termsSource = new TwitterSource(props);
        TwitterTermsSource twitterTermsFilter = new TwitterTermsSource();
        termsSource.setCustomEndpointInitializer(twitterTermsFilter);
        DataStream<String> twitterTermsSource = env.addSource(termsSource);

        // set up twitter users source
        TwitterSource usersSource = new TwitterSource(props);
        TwitterUsersSource twitterUsersFilter = new TwitterUsersSource();
        usersSource.setCustomEndpointInitializer(twitterUsersFilter);
        DataStream<String> twitterUsersSource = env.addSource(usersSource);

        // set up single stock streams
        DataStream<String> TSLA_source = env.addSource(new SingleStockSource("TSLA", 318, 1));
        DataStream<String> BMW_source= env.addSource(new SingleStockSource("BMW", 80, 1));
        DataStream<String> DAI_source= env.addSource(new SingleStockSource("DAI", 57, 1));
        DataStream<String> VOW_source= env.addSource(new SingleStockSource("VOW", 142, 1));

        // merge all stock streams
        DataStream<String> stockSource = TSLA_source.union(BMW_source,DAI_source,VOW_source);

        // translation twitter sources
        DataStream<Tweet> tweetTermsDataStream = twitterTermsSource
                .flatMap(new TweetTranslation());

        DataStream<Tweet> tweetUsersDataStream = twitterUsersSource
                .flatMap(new TweetTranslation());

        // translation stock streams
        DataStream<StockPrice> stockPriceDataStream = stockSource
                .map(new StockPriceTranslation());

        // constraint tweets
        tweetTermsDataStream = tweetTermsDataStream.filter(new TweetConstraint());
        tweetUsersDataStream = tweetUsersDataStream.filter(new TweetConstraint());

        // constraint stock prices
        stockPriceDataStream = stockPriceDataStream.filter(new StockPriceConstraint());

        // -------------------------------------------------------------------------------------------------------------
        // ---------------------------------------------- Level 2 ------------------------------------------------------
        // -------------------------------------------------------------------------------------------------------------

        // filters TSLA stock prices
        DataStream<StockPrice> TSLADataStream = stockPriceDataStream.filter(new OnlyTSLAFilter());

        // filters tweets from newspapers
        DataStream<Tweet> NPDataStream = tweetUsersDataStream.filter(new OnlyNPTweets());

        // filters tweets from Tesla and Elon Musk
        DataStream<Tweet> TEMDataStream = tweetUsersDataStream.filter(new OnlyTEMTweets());

        // -------------------------------------------------------------------------------------------------------------
        // ---------------------------------------------- Level 3 ------------------------------------------------------
        // -------------------------------------------------------------------------------------------------------------

        Pattern<StockPrice, ?> pattern = Pattern.<StockPrice>begin("start")
                .timesOrMore(5)
                .consecutive()
                .where(new IterativeCondition<StockPrice>() {
                    @Override
                    public boolean filter(StockPrice stockPrice, Context<StockPrice> ctx) throws Exception {
                        boolean result = true;
                        for (StockPrice e : ctx.getEventsForPattern("start")) {
                            if (e.getPrice() > stockPrice.getPrice()) {
                                result = false;
                            }
                        }
                        return result;
                    }
                });

        PatternStream<StockPrice> patternStream = CEP.pattern(TSLADataStream, pattern);

        DataStream<StockPriceUp> result = patternStream.select(
                new PatternSelectFunction<StockPrice, StockPriceUp>() {
                    @Override
                    public StockPriceUp select(Map<String, List<StockPrice>> pattern) throws Exception {
                        List<StockPrice> list = pattern.get("start");
                        String symbol = list.get(0).getSymbol();
                        double startPrice = list.get(0).getPrice();
                        double endPrice = list.get(list.size()-1).getPrice();

                        return new StockPriceUp(symbol, startPrice, endPrice, list);
                    }
                }
        );


        // -------------------------------------------------------------------------------------------------------------
        // ------------------------------------------------ Out --------------------------------------------------------
        // -------------------------------------------------------------------------------------------------------------

        TSLADataStream.print();
        result.print();

        DataStream<String> stockPriceOutStream = stockPriceDataStream
                .map(new MapFunction<StockPrice, String>() {
                    @Override
                    public String map(StockPrice value) throws Exception {
                        return value.toString();
                    }
                });

        stockPriceOutStream.addSink(new FlinkKafkaProducer08<>("localhost:9092", "test", new SimpleStringSchema()));

		env.execute("StreamingJob");
	}
}
