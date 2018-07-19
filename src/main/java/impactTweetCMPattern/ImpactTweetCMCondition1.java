package impactTweetCMPattern;

import org.apache.flink.cep.pattern.conditions.SimpleCondition;
import pojos.TweetRateFluctuation;

public class ImpactTweetCMCondition1 extends SimpleCondition<TweetRateFluctuation> {
    @Override
    public boolean filter(TweetRateFluctuation tweetRateFluctuation) {
        return tweetRateFluctuation.getOriginalType().equals("Tweet");
    }
}
