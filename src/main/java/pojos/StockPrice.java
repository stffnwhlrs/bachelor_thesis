package pojos;

import java.util.Objects;

public class StockPrice {

    private String _symbol;
    private double _price;

    public StockPrice() {}

    public StockPrice(String symbol, double price) {
        _symbol = symbol;
        _price = price;
    }

    public String getSymbol() {
        return _symbol;
    }

    public void setSymbol(String symbol) {
        this._symbol = symbol;
    }

    public double getPrice() {
        return _price;
    }

    public void setPrice(double price) {
        this._price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StockPrice) {
            StockPrice other = (StockPrice) obj;
            return other.canEquals(this) && _symbol.equals(other._symbol) && _price == other._price;
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(_symbol, _price);
    }

    @Override
    public String toString() {
        return "symbol: " + _symbol + ", price: " + _price;
    }

    public boolean canEquals(Object obj) {
        return obj instanceof StockPrice;
    }
}
