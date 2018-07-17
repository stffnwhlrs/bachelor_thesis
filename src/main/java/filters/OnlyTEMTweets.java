package filters;

import org.apache.flink.api.common.functions.FilterFunction;
import pojos.Tweet;

public class OnlyTEMTweets implements FilterFunction<Tweet> {
    private static final long TESLA = 13298072L;
    private static final long ELON_MUSK = 44196397L;

    @Override
    public boolean filter(Tweet tweet) {
        return tweet.getUserId() == TESLA ||
                tweet.getUserId() == ELON_MUSK;
    }
}
