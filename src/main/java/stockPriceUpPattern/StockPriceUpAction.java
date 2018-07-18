package stockPriceUpPattern;

import org.apache.flink.cep.PatternSelectFunction;
import pojos.StockPrice;
import pojos.StockPriceUp;

import java.util.List;
import java.util.Map;

public class StockPriceUpAction implements PatternSelectFunction<StockPrice, StockPriceUp> {
    @Override
    public StockPriceUp select(Map<String, List<StockPrice>> pattern) throws Exception {
        List<StockPrice> list = pattern.get("start");
        String symbol = list.get(0).getSymbol();
        double startPrice = list.get(0).getPrice();
        double endPrice = list.get(list.size()-1).getPrice();

        return new StockPriceUp(symbol, startPrice, endPrice, list);
    }
}
