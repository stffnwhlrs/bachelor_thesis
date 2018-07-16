package translations;

import org.apache.flink.api.common.functions.MapFunction;
import pojos.StockPrice;

public class StockPriceTranslation implements MapFunction<String, StockPrice> {

    @Override
    public StockPrice map(String value) throws Exception {
         String[] values = value.split(",");
         String symbol = values[0].trim();
         double price = Double.parseDouble(values[1].trim());

        return new StockPrice(symbol, price);
    }
}
