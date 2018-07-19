package impactTweetCMPattern;

import org.apache.flink.cep.PatternSelectFunction;
import pojos.ImpactTweet;
import pojos.ImpactTweetCM;
import pojos.TweetRateFluctuation;

import java.util.List;
import java.util.Map;

public class ImpactTweetCMAction implements PatternSelectFunction<TweetRateFluctuation, ImpactTweet> {
    @Override
    public ImpactTweet select(Map<String, List<TweetRateFluctuation>> pattern) {
        TweetRateFluctuation tweet = pattern.get("Tweet").get(0);
        TweetRateFluctuation rateFluctuation = pattern.get("RateFluctuation").get(0);
        return new ImpactTweetCM(tweet.getId(), tweet.getName(), tweet.getText(), rateFluctuation.getPercent());
    }
}
