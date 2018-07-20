package mappers;

import org.apache.flink.api.common.functions.MapFunction;
import pojos.SentimentAGG;
import pojos.TweetSentimentAGG;

public class SentimentAGGToTweetSentimentAGG implements MapFunction<SentimentAGG, TweetSentimentAGG>{
@Override
public TweetSentimentAGG map(SentimentAGG sentimentAGG) throws Exception {
        return new TweetSentimentAGG(sentimentAGG);
        }
}
