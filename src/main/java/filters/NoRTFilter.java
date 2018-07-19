package filters;

import org.apache.flink.api.common.functions.FilterFunction;
import pojos.Tweet;

public class NoRTFilter implements FilterFunction<Tweet> {
    @Override
    public boolean filter(Tweet tweet) throws Exception {
        return !(tweet.getText().contains("RT @"));
    }
}
