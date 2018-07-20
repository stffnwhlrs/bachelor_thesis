package impactTweetSMPattern;

import org.apache.flink.cep.pattern.conditions.SimpleCondition;
import pojos.TweetSentimentAGG;

public class ImpactTweetSMCondition2 extends SimpleCondition<TweetSentimentAGG> {
    @Override
    public boolean filter(TweetSentimentAGG tweetSentimentAGG) throws Exception {
//        TODO Nur ausgebene wenn sehr positiv oder negative responses
        return tweetSentimentAGG.getOriginalType().equals("SentimentAGG");
    }
}
