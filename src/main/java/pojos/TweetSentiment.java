package pojos;

public class TweetSentiment extends Tweet {
    private String polarity;
    private double confidence;

    public TweetSentiment() {}

    public TweetSentiment (Tweet tweet, String polarity, double confidence) {
        super(tweet.getId(),
                tweet.getText(),
                tweet.getUserId(),
                tweet.getScreenName(),
                tweet.getName(),
                tweet.getFullText());

        this.polarity = polarity;
        this.confidence = confidence;
    }

    public String getPolarity() {
        return polarity;
    }

    public void setPolarity(String polarity) {
        this.polarity = polarity;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    @Override
    public String toString() {
        return "tweet sentiment: text: " + this.text
                + ", polarity: " + this.polarity
                + ", confidence: " + this.confidence;
    }
}
