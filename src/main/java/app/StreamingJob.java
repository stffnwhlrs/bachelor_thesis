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


import org.apache.flink.api.common.functions.MapFunction;
import pojos.StockPrice;
import sources.SingleStockSource;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.apache.flink.streaming.connectors.twitter.TwitterSource;
import translations.StockPriceTranslation;

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

		// set up single stock streams
        DataStream<String> TSLA_source = env.addSource(new SingleStockSource("TSLA", 318, 1));
        DataStream<String> BMW_source= env.addSource(new SingleStockSource("BMW", 80, 1));
        DataStream<String> DAI_source= env.addSource(new SingleStockSource("DAI", 57, 1));
        DataStream<String> VOW_source= env.addSource(new SingleStockSource("VOW", 142, 1));

        // merge all stock streams
        DataStream<String> stockSource = TSLA_source.union(BMW_source,DAI_source,VOW_source);

        // translation stock streams
        DataStream<StockPrice> stockPriceDataStream = stockSource
                .map(new StockPriceTranslation());

        stockPriceDataStream.print();


		// Twitter
//		DataStream<String> inputTwitterStream = env.addSource(new TwitterSource(props));
//		inputTwitterStream.print();

//        DataStream<String> dataStream = env.addSource(new TestSource());
        // stockSource.print();

		env.execute("StreamingJob");
	}
}
