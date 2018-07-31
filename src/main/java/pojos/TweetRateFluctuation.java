package pojos;

import java.util.Objects;

public class TweetRateFluctuation extends Tweet{
    private String originalType;
    private String symbol;
    private double minPrice;
    private double maxPrice;
    private double percent;

    public TweetRateFluctuation() {}

    public TweetRateFluctuation(RateFluctuation rateFluctuation) {
        this.originalType = "RateFluctuation";
        this.symbol = rateFluctuation.getSymbol();
        this.minPrice = rateFluctuation.getMinPrice();
        this.maxPrice = rateFluctuation.getMaxPrice();
        this.percent = rateFluctuation.getPercent();

        this.id = -1;
        this.text = null;
        this.userId = -1;
        this.screenName = null;
        this.name = null;
        this.fullText = null;
    }

    public TweetRateFluctuation(Tweet tweet) {
        super(tweet.getId(),
                tweet.getText(),
                tweet.getUserId(),
                tweet.getScreenName(),
                tweet.getName(),
                tweet.getFullText());

        this.originalType = "Tweet";
        this.symbol = null;
        this.minPrice = -1;
        this.maxPrice = -1;
        this.percent = -1;
    }

    public String getOriginalType() {
        return originalType;
    }

    public void setOriginalType(String originalType) {
        this.originalType = originalType;
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
        if (obj instanceof Tweet) {
            TweetRateFluctuation other = (TweetRateFluctuation) obj;
            return other.canEquals(this) &&
                    super.equals(obj) &&
                    Objects.equals(this.originalType, other.originalType) &&
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
        return Objects.hash(super.hashCode(),
                this.originalType,
                this.symbol,
                this.minPrice,
                this.maxPrice,
                this.percent);
    }

    @Override
    public String toString() {
        return "orginal type: " + this.originalType
                + ", "+ super.toString()
                + ", symbol: " + this.symbol
                +  ", percent: " + this.percent;
    }

    @Override
    public boolean canEquals(Object obj) {
        return obj instanceof TweetRateFluctuation;
    }
}
