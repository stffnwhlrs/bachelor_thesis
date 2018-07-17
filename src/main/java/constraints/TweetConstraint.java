package constraints;

import org.apache.flink.api.common.functions.FilterFunction;
import pojos.Tweet;

public class TweetConstraint implements FilterFunction<Tweet> {

    @Override
    public boolean filter(Tweet tweet) throws Exception {
        return tweet.getText().length() > 1;
    }
}
