package mappers;

import org.apache.flink.api.common.functions.MapFunction;
import pojos.Tweet;
import pojos.TweetRateFluctuation;

public class TweetToTweetRateFluctuation implements MapFunction<Tweet, TweetRateFluctuation> {
    @Override
    public TweetRateFluctuation map(Tweet tweet) throws Exception {
            return new TweetRateFluctuation(tweet);
    }
}
