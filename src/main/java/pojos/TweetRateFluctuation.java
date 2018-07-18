package pojos;

import java.util.Objects;

public class TweetRateFluctuation extends Tweet{
    private String _originalType;
    private String _symbol;
    private double _minPrice;
    private double _maxPrice;
    private double _percent;

    public TweetRateFluctuation() {}

    public TweetRateFluctuation(RateFluctuation rateFluctuation) {
        this._originalType = "RateFluctuation";
        this._symbol = rateFluctuation.getSymbol();
        this._minPrice = rateFluctuation.getMinPrice();
        this._maxPrice = rateFluctuation.getMaxPrice();
        this._percent = rateFluctuation.getPercent();

        this._id = -1;
        this._text = null;
        this._userId = -1;
        this._screenName = null;
        this._name = null;
        this._fullText = null;
    }

    public TweetRateFluctuation(Tweet tweet) {
        super(tweet.getId(),
                tweet.getText(),
                tweet.getUserId(),
                tweet.getScreenName(),
                tweet.getName(),
                tweet.getFullText());

        this._originalType = "Tweet";
        this._symbol = null;
        this._minPrice = -1;
        this._maxPrice = -1;
        this._percent = -1;
    }

    public String getOriginalType() {
        return _originalType;
    }

    public void setOriginalType(String originalType) {
        this._originalType = originalType;
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
        if (obj instanceof Tweet) {
            TweetRateFluctuation other = (TweetRateFluctuation) obj;
            return other.canEquals(this) &&
                    super.equals(obj) &&
                    Objects.equals(this._originalType, other._originalType) &&
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
        return Objects.hash(super.hashCode(),
                this._originalType,
                this._symbol,
                this._minPrice,
                this._maxPrice,
                this._percent);
    }

    @Override
    public String toString() {
        return "orginal type: " + this._originalType
                + ", "+ super.toString()
                + ", symbol: " + this._symbol
                +  ", percent: " + this._percent;
    }

    @Override
    public boolean canEquals(Object obj) {
        return obj instanceof TweetRateFluctuation;
    }
}
