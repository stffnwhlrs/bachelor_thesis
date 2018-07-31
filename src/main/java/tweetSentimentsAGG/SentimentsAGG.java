package tweetSentimentsAGG;

import org.apache.flink.streaming.api.functions.windowing.AllWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;
import pojos.SentimentAGG;
import pojos.TweetSentiment;

public class SentimentsAGG implements AllWindowFunction<TweetSentiment, SentimentAGG, TimeWindow> {
    @Override
    public void apply(TimeWindow window, Iterable<TweetSentiment> tweetSentiments, Collector<SentimentAGG> out) throws Exception {
        int positives = 0;
        int neutrals = 0;
        int negatives = 0;
        int count;
        double ratioPositives;
        double ratioNegatives;
        for (TweetSentiment tweetSentiment : tweetSentiments) {
            if (tweetSentiment.getConfidence() > 0.6) {
                if (tweetSentiment.getPolarity().equals("positive")) {
                    positives += 1;
                } else if (tweetSentiment.getPolarity().equals("neutral")) {
                    neutrals += 1;
                } else if (tweetSentiment.getPolarity().equals("negative")) {
                    negatives += 1;
                }
            }
        }
        count = positives + neutrals + negatives;
        ratioPositives = (double) positives / count;
        ratioNegatives = (double) negatives / count;

        out.collect(new SentimentAGG(positives, neutrals, negatives, count, ratioPositives, ratioNegatives));
    }
}
