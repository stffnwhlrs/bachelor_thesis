package impactTweetSMPattern;

import org.apache.flink.cep.pattern.conditions.SimpleCondition;
import pojos.TweetSentimentAGG;

public class ImpactTweetSMCondition1 extends SimpleCondition<TweetSentimentAGG> {
    @Override
    public boolean filter(TweetSentimentAGG tweetSentimentAGG) throws Exception {
        return tweetSentimentAGG.getOriginalType().equals("Tweet");
    }
}
