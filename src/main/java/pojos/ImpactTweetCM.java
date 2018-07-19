package pojos;

public class ImpactTweetCM extends ImpactTweet {
    private double _percent;

    public ImpactTweetCM() {}
    public ImpactTweetCM (long id, String name, String text, double percent) {
        super(id, name, text);

        this._percent = percent;
    }

    public double getPercent() {
        return _percent;
    }

    public void setPercent(double percent) {
        this._percent = percent;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ImpactTweetCM) {
            ImpactTweetCM other = (ImpactTweetCM) obj;
            return other.canEquals(this) && super.equals(other);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "ImpactTweetCM: " + super.toString() + ", percent: " + this._percent;
    }

    @Override
    public boolean canEquals(Object obj) {
        return obj instanceof ImpactTweetCM;
    }
}
