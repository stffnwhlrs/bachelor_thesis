package pojos;

import java.util.List;
import java.util.Objects;

public class StockPriceUp {
    private String symbol;
    private double startPrice;
    private double endPrice;
    private List<StockPrice> stockPrices;

    public StockPriceUp() {}

    public StockPriceUp(String symbol, double startPrice, double endPrice, List<StockPrice> stockPrices) {
        this.symbol = symbol;
        this.startPrice = startPrice;
        this.endPrice = endPrice;
        this.stockPrices = stockPrices;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(double startPrice) {
        this.startPrice = startPrice;
    }

    public double getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(double endPrice) {
        this.endPrice = endPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  StockPriceUp) {
            StockPriceUp other = (StockPriceUp) obj;
            return other.canEquals(this) &&
                    Objects.equals(this.symbol, other.symbol) &&
                    this.startPrice == other.startPrice &&
                    this.endPrice == other.endPrice &&
                    Objects.equals(this.stockPrices, other.stockPrices);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.symbol, this.startPrice, this.endPrice, this.stockPrices);
    }

    @Override
    public String toString() {
        return "symbol: " + this.symbol +
                ", start price: " + this.startPrice +
                ", end price: " + this.endPrice +
                ", number stock prices: " + this.stockPrices.size();
    }

    public boolean canEquals(Object obj) {
        return obj instanceof StockPriceUp;
    }
}
