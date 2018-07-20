package pojos;

public class ImpactTweetSM extends ImpactTweet{
    public int count;
    public double ratioPositives;
    public double ratioNegatives;

    public ImpactTweetSM() {}

    public ImpactTweetSM (long id, String name, String text, int count, double ratioPositives, double ratioNegatives) {
            super(id, name, text);
            this.count = count;
            this.ratioPositives = ratioPositives;
            this.ratioNegatives = ratioNegatives;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public void setRatioNegatives(double _ratioNegatives) {
        this.ratioNegatives = _ratioNegatives;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ImpactTweetSM) {
            ImpactTweetSM other = (ImpactTweetSM) obj;
            return other.canEquals(this) && super.equals(other);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "ImpactTweetSM: " + super.toString()
                + ", count: " + this.count
                + ", ratio positives: " + this.ratioPositives
                + ", ratio negatives: " + this.ratioNegatives;
    }

    @Override
    public boolean canEquals(Object obj) {
        return obj instanceof ImpactTweetSM;
    }
}

