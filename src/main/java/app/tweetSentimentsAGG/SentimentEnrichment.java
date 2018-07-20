package app.tweetSentimentsAGG;

import com.aylien.textapi.TextAPIClient;
import com.aylien.textapi.parameters.SentimentParams;
import com.aylien.textapi.responses.Sentiment;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.configuration.Configuration;
import pojos.Tweet;
import pojos.TweetSentiment;

public class SentimentEnrichment extends RichMapFunction<Tweet, TweetSentiment> {
    TextAPIClient _textAPIClient;

    @Override
    public void open(Configuration parameters) throws Exception {
        // super.open(parameters);
        _textAPIClient = new TextAPIClient("efe1eeb5", "6af506e26a54fb3fd2e6cbcd5e0a8895");
    }

    @Override
    public TweetSentiment map(Tweet tweet) throws Exception {
        SentimentParams sentimentParams = new SentimentParams(tweet.getText(), null, null);
        Sentiment sentiment = _textAPIClient.sentiment(sentimentParams);

        return new TweetSentiment(tweet, sentiment.getPolarity(), sentiment.getPolarityConfidence());
    }
}
