package pojos;

import java.util.Objects;

public class StockPrice {

    private String symbol;
    private double price;

    public StockPrice() {}

    public StockPrice(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StockPrice) {
            StockPrice other = (StockPrice) obj;
            return other.canEquals(this) && this.symbol.equals(other.symbol) && this.price == other.price;
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, price);
    }

    @Override
    public String toString() {
        return "symbol: " + symbol + ", price: " + price;
    }

    public boolean canEquals(Object obj) {
        return obj instanceof StockPrice;
    }
}
