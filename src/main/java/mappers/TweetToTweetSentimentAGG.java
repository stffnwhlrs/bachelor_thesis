package mappers;

import org.apache.flink.api.common.functions.MapFunction;
import pojos.Tweet;
import pojos.TweetSentimentAGG;

public class TweetToTweetSentimentAGG implements MapFunction<Tweet, TweetSentimentAGG> {
    @Override
    public TweetSentimentAGG map(Tweet tweet) throws Exception {
        return new TweetSentimentAGG(tweet);
    }
}
