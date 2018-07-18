package rateFluctuationPattern;

import org.apache.flink.streaming.api.functions.windowing.AllWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;
import pojos.RateFluctuation;
import pojos.StockPrice;

public class RateFluctuationCondition implements AllWindowFunction<StockPrice, RateFluctuation, TimeWindow> {
    @Override
    public void apply(TimeWindow window, Iterable<StockPrice> stockPrices, Collector<RateFluctuation> out) throws Exception {
        double minPrice = 500;
        double maxPrice = 0;
        double percent;

        for (StockPrice stockPrice : stockPrices) {
            if (minPrice > stockPrice.getPrice()) {
                minPrice = stockPrice.getPrice();
            }

            if (maxPrice < stockPrice.getPrice()) {
                maxPrice = stockPrice.getPrice();
            }
        }
        percent = (1 - minPrice / maxPrice) * 100;
        percent = percent * 100;
        percent = Math.round(percent);
        percent = percent / 100;
        out.collect(new RateFluctuation("TSLA", minPrice, maxPrice, percent));
    }
}
