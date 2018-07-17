package filters;

import org.apache.flink.api.common.functions.FilterFunction;
import pojos.StockPrice;

public class OnlyTSLAFilter implements FilterFunction<StockPrice> {
    @Override
    public boolean filter(StockPrice stockPrice) throws Exception {
        return stockPrice.getSymbol().equals("TSLA");
    }
}
