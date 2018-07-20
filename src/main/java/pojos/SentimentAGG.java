package pojos;

public class SentimentAGG {
    private int _positives;
    private int _neutral;
    private int _negative;
    private int _count;
    private double _ratioPositives;
    private double _ratioNegatives;

    public SentimentAGG() {}

    public SentimentAGG(int positives, int neutrals, int negatives, int count, double ratioPositives, double ratioNegatives) {
    this._positives = positives;
    this._neutral = neutrals;
    this._negative = negatives;
    this._count = count;
    this._ratioPositives = ratioPositives;
    this._ratioNegatives = ratioNegatives;
    }

    public int getPositive() {
        return _positives;
    }

    public void setPpositive(int positive) {
        this._positives = positive;
    }

    public int getNeutral() {
        return _neutral;
    }

    public void setNeutral(int neutral) {
        this._neutral = neutral;
    }

    public int getNegative() {
        return _negative;
    }

    public void setNegative(int negative) {
        this._negative = negative;
    }

    public int getCount() {
        return _count;
    }

    public void setCount(int count) {
        this._count = count;
    }

    public double getRatioPositive() {
        return _ratioPositives;
    }

    public void setRatioPositive(double ratioPositive) {
        this._ratioPositives = ratioPositive;
    }

    public double getRatioNegative() {
        return _ratioNegatives;
    }

    public void setRatioNegative(double ratioNegative) {
        this._ratioNegatives = ratioNegative;
    }


    @Override
    public String toString() {
        return "sentiment agg: positive ratio: " + this._ratioPositives
                + ", positives: " + this._positives
                + ", count: " + this._count;
    }
}
