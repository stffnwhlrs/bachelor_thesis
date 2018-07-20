package pojos;

public class ImpactTweetSM extends ImpactTweet{
    protected int _count;
    protected double _ratioPositives;
    protected double _ratioNegatives;

    public ImpactTweetSM() {}

    public ImpactTweetSM (long id, String name, String text, int count, double ratioPositives, double ratioNegatives) {
            super(id, name, text);
            this._count = count;
            this._ratioPositives = ratioPositives;
            this._ratioNegatives = ratioNegatives;
    }

    public int getCount() {
        return _count;
    }

    public void setCount(int count) {
        this._count = count;
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

    public void setRatioNegatives(double _ratioNegatives) {
        this._ratioNegatives = _ratioNegatives;
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
                + ", count: " + this._count
                + ", ratio positives: " + this._ratioPositives
                + ", ratio negatives: " + this._ratioNegatives;
    }

    @Override
    public boolean canEquals(Object obj) {
        return obj instanceof ImpactTweetSM;
    }
}

