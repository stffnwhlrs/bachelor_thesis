package pojos;

import java.util.Objects;

public class ImpactTweetStore extends ImpactTweetSM {
    private double _percent;

    public ImpactTweetStore() {}

    public ImpactTweetStore(long id,
                            String name,
                            String text,
                            int count,
                            double ratioPositives,
                            double ratioNegatives,
                            double percent) {
        super(id,name,text,count,ratioPositives,ratioNegatives);
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
        if (obj instanceof ImpactTweetStore) {
            ImpactTweetStore other = (ImpactTweetStore) obj;
            return other.canEquals(this) &&
                    super.equals(other) &&
                    this._percent == other._percent;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),Double.hashCode(this._percent));
    }

    @Override
    public String toString() {
        return "ImpactTweetSource: "
                + "Tweet ID: " + this._id
                + ", screen name: " + this._name
                + ", text: " + this._text
                + ", count: " + this._count
                + ", ratio positives: " + this._ratioPositives
                + ", ratio negatives: " + this._ratioNegatives
                + ", percent: " + this._percent;

    }

    @Override
    public boolean canEquals(Object obj) {
        return obj instanceof ImpactTweetStore;
    }
}
