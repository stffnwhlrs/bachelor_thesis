package pojos;

import java.util.Objects;

public class RateFluctuation {
    private String symbol;
    private double minPrice;
    private double maxPrice;
    private double percent;

    public RateFluctuation() {}

    public RateFluctuation(String symbol, double minPrice, double maxPrice, double percent) {

        this.symbol = symbol;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.percent = percent;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }


    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof RateFluctuation) {
            RateFluctuation other = (RateFluctuation) obj;
            return other.canEquals(this) &&
                    Objects.equals(this.symbol, other.symbol) &&
                    Objects.equals(String.valueOf(this.minPrice), String.valueOf(other.minPrice)) &&
                    Objects.equals(String.valueOf(this.maxPrice), String.valueOf(other.maxPrice)) &&
                    Objects.equals(String.valueOf(this.percent), String.valueOf(other.percent));
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.symbol,
                String.valueOf(this.minPrice),
                String.valueOf(this.maxPrice),
                String.valueOf(this.percent));
    }

    @Override
    public String toString() {
        return "symbol: " + this.symbol +
                ", percent: " + this.percent +
                ", min price: " + this.minPrice +
                ", max price: " + this.maxPrice;
    }

    public boolean canEquals(Object obj) {
        return obj instanceof RateFluctuation;
    }
}
