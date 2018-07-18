package rateFluctuationPattern;

import org.apache.flink.api.common.functions.FilterFunction;
import pojos.RateFluctuation;

public class RateFluctuationAction implements FilterFunction<RateFluctuation> {
    //treshold
    private static final int PERCENT = 3;

    @Override
    public boolean filter(RateFluctuation rateFluctuation) throws Exception {
        RateFluctuation last = null;

        return rateFluctuation.getPercent() >= PERCENT;
    }
}
