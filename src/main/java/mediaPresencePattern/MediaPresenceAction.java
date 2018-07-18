package mediaPresencePattern;

import org.apache.flink.cep.PatternSelectFunction;
import pojos.HotTopic;
import pojos.Tweet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MediaPresenceAction implements PatternSelectFunction<Tweet, HotTopic> {
    @Override
    public HotTopic select(Map<String, List<Tweet>> pattern) throws Exception {
        List<String> newspapers = new ArrayList<>();
        List<String> news = new ArrayList<>();

        for(Tweet tweet : pattern.get("start")) {
            newspapers.add(tweet.getName());
            news.add(tweet.getText());
        }
        return new HotTopic(newspapers, news);
    }
}
