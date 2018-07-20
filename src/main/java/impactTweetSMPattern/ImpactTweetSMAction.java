package impactTweetSMPattern;

import org.apache.flink.cep.PatternSelectFunction;
import pojos.ImpactTweet;
import pojos.ImpactTweetSM;
import pojos.TweetSentimentAGG;

import java.util.List;
import java.util.Map;

public class ImpactTweetSMAction implements PatternSelectFunction<TweetSentimentAGG, ImpactTweet> {
    @Override
    public ImpactTweet select(Map<String, List<TweetSentimentAGG>> pattern) throws Exception {
        TweetSentimentAGG tweet = pattern.get("Tweet").get(0);
        TweetSentimentAGG sentimentAGG = pattern.get("SentimentAGG").get(0);
        return new ImpactTweetSM(
                tweet.getId(),
                tweet.getName(),
                tweet.getText(),
                sentimentAGG.getCount(),
                sentimentAGG.getRatioPositives(),
                sentimentAGG.getRatioNegatives());
    }
}
