package filters;

import org.apache.flink.api.common.functions.FilterFunction;
import pojos.Tweet;

public class OnlyNPTweets implements FilterFunction<Tweet> {
    private static final long CNN = 759251L;
    private static final long BLOOMBERG = 34713362L;
    private static final long THE_ECONOMIST = 5988062L;
    private static final long THE_TELEGRAPH = 16343974L;
    private static final long HANDELSBLATT = 2979574468L;
    private static final long TEST_ID = 1006501086100942848L;

    @Override
    public boolean filter(Tweet tweet) {
        return tweet.getUserId() == CNN ||
                tweet.getUserId() == BLOOMBERG ||
                tweet.getUserId() == THE_ECONOMIST ||
                tweet.getUserId() == THE_TELEGRAPH ||
                tweet.getUserId() == HANDELSBLATT ||
                tweet.getUserId() == TEST_ID;
    }
}
