package translations;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.JsonNode;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.util.Collector;
import pojos.Tweet;

public class TweetTranslation implements FlatMapFunction<String, Tweet> {
    @Override
    public void flatMap(String value, Collector<Tweet> out) throws Exception {
        ObjectMapper jsonParser = new ObjectMapper();
        JsonNode jsonNode = jsonParser.readValue(value, JsonNode.class);

        if (jsonNode.has("user") &&
                jsonNode.has("id_str") &&
                jsonNode.has("text")) {
            long id = Long.parseLong(jsonNode.get("id_str").asText());
            String text = jsonNode.get("text").asText();
            long userId = Long.parseLong(jsonNode.get("user").get("id_str").asText());
            String screenName = jsonNode.get("user").get("screen_name").asText();
            String name = jsonNode.get("user").get("name").asText();
            String fullText = "";

            if (jsonNode.has("extended_tweet")) {
                fullText = jsonNode.get("extended_tweet").get("full_text").asText();
            }

            out.collect(new Tweet(id,text, userId, screenName, name, fullText));
        }

    }
}
