package translations;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;
import pojos.Tweet;

public class TweetTranslation implements FlatMapFunction<String, Tweet> {
    @Override
    public void flatMap(String value, Collector<Tweet> out) throws Exception {


    }
}
