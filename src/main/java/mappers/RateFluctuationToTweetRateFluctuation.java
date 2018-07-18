package mappers;

import org.apache.flink.api.common.functions.MapFunction;
import pojos.RateFluctuation;
import pojos.TweetRateFluctuation;

public class RateFluctuationToTweetRateFluctuation implements MapFunction<RateFluctuation, TweetRateFluctuation> {
    @Override
    public TweetRateFluctuation map(RateFluctuation rateFluctuation) throws Exception {
        return new TweetRateFluctuation(rateFluctuation);
    }
}
