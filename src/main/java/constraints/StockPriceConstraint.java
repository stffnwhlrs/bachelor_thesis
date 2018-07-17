package constraints;

import org.apache.flink.api.common.functions.FilterFunction;
import pojos.StockPrice;

public class StockPriceConstraint implements FilterFunction<StockPrice> {

    @Override
    public boolean filter(StockPrice stockPrice) throws Exception {
        return stockPrice.getPrice() >= 0;
    }
}
