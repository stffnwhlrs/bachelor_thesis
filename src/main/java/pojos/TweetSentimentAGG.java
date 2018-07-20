package pojos;

import java.util.Objects;

public class TweetSentimentAGG extends Tweet {
    private String _originalType;
    private int _count;
    private double _ratioPositives;
    private double _ratioNegatives;
    
    public TweetSentimentAGG() {}
    
    public TweetSentimentAGG(SentimentAGG sentimentAGG) {
        super(-1, null, -1, null, null,null);

        this._originalType = "SentimentAGG";
        this._count = sentimentAGG.getCount();
        this._ratioPositives = sentimentAGG.getRatioPositive();
        this._ratioNegatives = sentimentAGG.getRatioNegative();

    }
    
    public TweetSentimentAGG(Tweet tweet) {
        super(tweet.getId(), tweet.getText(), tweet.getUserId(), tweet.getScreenName(),tweet.getName(),tweet.getFullText());

        this._originalType = "Tweet";
        this._count = -1;
        this._ratioPositives = -1;
        this._ratioNegatives = -1;
    }

    public String getOriginalType() {
        return _originalType;
    }

    public void setOriginalType(String originalType) {
        this._originalType = originalType;
    }

    public int getCount() {
        return _count;
    }

    public void setCount(int _count) {
        this._count = _count;
    }

    public double getRatioPositives() {
        return _ratioPositives;
    }

    public void setRatioPositives(double ratioPositives) {
        this._ratioPositives = ratioPositives;
    }

    public double getRatioNegatives() {
        return _ratioNegatives;
    }

    public void setRatioNegatives(double ratioNegatives) {
        this._ratioNegatives = ratioNegatives;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof TweetSentimentAGG) {
            TweetSentimentAGG other = (TweetSentimentAGG) obj;
            return other.canEquals(this) &&
                    super.equals(other) &&
                    Objects.equals(this._originalType, other._originalType);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this._originalType);
    }

    @Override
    public boolean canEquals(Object obj) {
        return obj instanceof TweetSentimentAGG;
    }

    @Override
    public String toString() {
        return "original type: " + this._originalType
                + " , screen name: " + this._screenName
                + ", text: " + this._text
                + ", count: " + this._count
                + ", ratio positives:" + this._ratioPositives
                + ", ratio negatives:" + this._ratioNegatives;
    }
}
