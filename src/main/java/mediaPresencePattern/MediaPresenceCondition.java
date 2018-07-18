package mediaPresencePattern;

import org.apache.flink.cep.pattern.conditions.SimpleCondition;
import pojos.Tweet;

public class MediaPresenceCondition extends SimpleCondition<Tweet> {
    @Override
    public boolean filter(Tweet tweet) throws Exception {
        return tweet.getText().contains("Tesla") ||
                tweet.getText().contains("tesla") ||
                tweet.getText().contains("TSLA") ||
                tweet.getText().contains("tsla") ||
                tweet.getText().contains("musk") ||
                tweet.getText().contains("Musk");
    }
}
