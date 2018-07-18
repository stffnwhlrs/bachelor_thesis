package filters;

import org.apache.flink.api.common.functions.FilterFunction;
import pojos.TweetRateFluctuation;

public class OriginalTypeTweet implements FilterFunction<TweetRateFluctuation> {
    @Override
    public boolean filter(TweetRateFluctuation tweetRateFluctuation) throws Exception {
        System.out.println(tweetRateFluctuation.getOriginalType().equals("Tweet"));
        return tweetRateFluctuation.getOriginalType().equals("Tweet");
    }
}
