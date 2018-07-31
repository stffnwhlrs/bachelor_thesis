package pojos;

import java.util.Objects;

public class TweetSentimentAGG extends Tweet {
    private String originalType;
    private int count;
    private double ratioPositives;
    private double ratioNegatives;
    
    public TweetSentimentAGG() {}
    
    public TweetSentimentAGG(SentimentAGG sentimentAGG) {
        super(-1, null, -1, null, null,null);

        this.originalType = "SentimentAGG";
        this.count = sentimentAGG.getCount();
        this.ratioPositives = sentimentAGG.getRatioPositive();
        this.ratioNegatives = sentimentAGG.getRatioNegative();

    }
    
    public TweetSentimentAGG(Tweet tweet) {
        super(tweet.getId(), tweet.getText(), tweet.getUserId(), tweet.getScreenName(),tweet.getName(),tweet.getFullText());

        this.originalType = "Tweet";
        this.count = -1;
        this.ratioPositives = -1;
        this.ratioNegatives = -1;
    }

    public String getOriginalType() {
        return originalType;
    }

    public void setOriginalType(String originalType) {
        this.originalType = originalType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int _count) {
        this.count = _count;
    }

    public double getRatioPositives() {
        return ratioPositives;
    }

    public void setRatioPositives(double ratioPositives) {
        this.ratioPositives = ratioPositives;
    }

    public double getRatioNegatives() {
        return ratioNegatives;
    }

    public void setRatioNegatives(double ratioNegatives) {
        this.ratioNegatives = ratioNegatives;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof TweetSentimentAGG) {
            TweetSentimentAGG other = (TweetSentimentAGG) obj;
            return other.canEquals(this) &&
                    super.equals(other) &&
                    Objects.equals(this.originalType, other.originalType);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.originalType);
    }

    @Override
    public boolean canEquals(Object obj) {
        return obj instanceof TweetSentimentAGG;
    }

    @Override
    public String toString() {
        return "original type: " + this.originalType
                + " , screen name: " + this.screenName
                + ", text: " + this.text
                + ", count: " + this.count
                + ", ratio positives:" + this.ratioPositives
                + ", ratio negatives:" + this.ratioNegatives;
    }
}
