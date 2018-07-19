package pojos;

public class TweetSentiment extends Tweet {
    private String _polarity;
    private double _confidence;

    public TweetSentiment() {}

    public TweetSentiment (Tweet tweet, String polarity, double confidence) {
        super(tweet.getId(),
                tweet.getText(),
                tweet.getUserId(),
                tweet.getScreenName(),
                tweet.getName(),
                tweet.getFullText());

        this._polarity = polarity;
        this._confidence = confidence;
    }

    public String getPolarity() {
        return _polarity;
    }

    public void setPolarity(String polarity) {
        this._polarity = polarity;
    }

    public double getConfidence() {
        return _confidence;
    }

    public void setConfidence(double confidence) {
        this._confidence = confidence;
    }

    @Override
    public String toString() {
        return "tweet sentiment: text: " + this._text
                + ", polarity: " + this._polarity
                + ", confidence: " + this._confidence;
    }
}
