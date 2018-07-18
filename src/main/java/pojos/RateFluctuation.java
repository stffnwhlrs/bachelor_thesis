package pojos;

import java.util.Objects;

public class RateFluctuation {
    private String _symbol;
    private double _minPrice;
    private double _maxPrice;
    private double _percent;

    public RateFluctuation() {}

    public RateFluctuation(String symbol, double minPrice, double maxPrice, double percent) {

        this._symbol = symbol;
        this._minPrice = minPrice;
        this._maxPrice = maxPrice;
        this._percent = percent;
    }

    public String getSymbol() {
        return _symbol;
    }

    public void setSymbol(String symbol) {
        this._symbol = symbol;
    }

    public double getMinPrice() {
        return _minPrice;
    }

    public void setMinPrice(double minPrice) {
        this._minPrice = minPrice;
    }

    public double getMaxPrice() {
        return _maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this._maxPrice = maxPrice;
    }


    public double getPercent() {
        return _percent;
    }

    public void setPercent(double percent) {
        this._percent = percent;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof RateFluctuation) {
            RateFluctuation other = (RateFluctuation) obj;
            return other.canEquals(this) &&
                    Objects.equals(this._symbol, other._symbol) &&
                    Objects.equals(String.valueOf(this._minPrice), String.valueOf(other._minPrice)) &&
                    Objects.equals(String.valueOf(this._maxPrice), String.valueOf(other._maxPrice)) &&
                    Objects.equals(String.valueOf(this._percent), String.valueOf(other._percent));
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this._symbol,
                String.valueOf(this._minPrice),
                String.valueOf(this._maxPrice),
                String.valueOf(this._percent));
    }

    @Override
    public String toString() {
        return "symbol: " + this._symbol +
                ", percent: " + this._percent +
                ", min price: " + this._minPrice +
                ", max price: " + this._maxPrice;
    }

    public boolean canEquals(Object obj) {
        return obj instanceof RateFluctuation;
    }
}
