package stockPriceUpPattern;

import org.apache.flink.cep.pattern.conditions.IterativeCondition;
import pojos.StockPrice;

public class StockPriceUpCondition extends IterativeCondition<StockPrice> {

    private String _patternName;

    public StockPriceUpCondition(String patternName) {
        _patternName = patternName;
    }

    @Override
    public boolean filter(StockPrice stockPrice, Context<StockPrice> ctx) throws Exception {
        boolean result = true;
        for (StockPrice e : ctx.getEventsForPattern(this._patternName)) {
            if (e.getPrice() > stockPrice.getPrice()) {
                result = false;
            }
        }
        return result;
    }
}
