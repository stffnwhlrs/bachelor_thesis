package pojos;

public class SentimentAGG {
    private int positives;
    private int neutrals;
    private int negatives;
    private int count;
    private double ratioPositives;
    private double ratioNegatives;

    public SentimentAGG() {}

    public SentimentAGG(int positives, int neutrals, int negatives, int count, double ratioPositives, double ratioNegatives) {
    this.positives = positives;
    this.neutrals = neutrals;
    this.negatives = negatives;
    this.count = count;
    this.ratioPositives = ratioPositives;
    this.ratioNegatives = ratioNegatives;
    }

    public int getPositive() {
        return positives;
    }

    public void setPpositive(int positive) {
        this.positives = positive;
    }

    public int getNeutral() {
        return neutrals;
    }

    public void setNeutral(int neutral) {
        this.neutrals = neutral;
    }

    public int getNegative() {
        return negatives;
    }

    public void setNegative(int negative) {
        this.negatives = negative;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getRatioPositive() {
        return ratioPositives;
    }

    public void setRatioPositive(double ratioPositive) {
        this.ratioPositives = ratioPositive;
    }

    public double getRatioNegative() {
        return ratioNegatives;
    }

    public void setRatioNegative(double ratioNegative) {
        this.ratioNegatives = ratioNegative;
    }


    @Override
    public String toString() {
        return "sentiment agg: positive ratio: " + this.ratioPositives
                + ", positives: " + this.positives
                + ", count: " + this.count;
    }
}
