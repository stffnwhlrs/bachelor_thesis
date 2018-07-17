package pojos;

import java.util.List;
import java.util.Objects;

public class StockPriceUp {
    private String _symbol;
    private double _startPrice;
    private double _endPrice;
    private List<StockPrice> _stockPrices;

    public StockPriceUp() {}

    public StockPriceUp(String symbol, double startPrice, double endPrice, List<StockPrice> stockPrices) {
        _symbol = symbol;
        _startPrice = startPrice;
        _endPrice = endPrice;
        _stockPrices = stockPrices;
    }

    public String getSymbol() {
        return _symbol;
    }

    public void setSymbol(String symbol) {
        this._symbol = symbol;
    }

    public double getStartPrice() {
        return _startPrice;
    }

    public void setStartPrice(double startPrice) {
        this._startPrice = startPrice;
    }

    public double getEndPrice() {
        return _endPrice;
    }

    public void setEndPrice(double endPrice) {
        this._endPrice = endPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  StockPriceUp) {
            StockPriceUp other = (StockPriceUp) obj;
            return other.canEquals(this) &&
                    Objects.equals(this._symbol, other._symbol) &&
                    this._startPrice == other._startPrice &&
                    this._endPrice == other. _endPrice;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this._symbol, this._startPrice, this._endPrice);
    }

    @Override
    public String toString() {
        return "symbol: " + this._symbol +
                ", start price: " + this._startPrice +
                ", end price: " + this._endPrice +
                ", number stock prices: " + this._stockPrices.size();
    }

    public boolean canEquals(Object obj) {
        return obj instanceof StockPriceUp;
    }
}
