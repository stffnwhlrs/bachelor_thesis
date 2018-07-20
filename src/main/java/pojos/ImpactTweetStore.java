package pojos;

import java.util.Objects;

public class ImpactTweetStore extends ImpactTweetSM {
    public double percent;

    public ImpactTweetStore() {}

    public ImpactTweetStore(long id,
                            String name,
                            String text,
                            int count,
                            double ratioPositives,
                            double ratioNegatives,
                            double percent) {
        super(id,name,text,count,ratioPositives,ratioNegatives);
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ImpactTweetStore) {
            ImpactTweetStore other = (ImpactTweetStore) obj;
            return other.canEquals(this) &&
                    super.equals(other) &&
                    this.percent == other.percent;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),Double.hashCode(this.percent));
    }

    @Override
    public String toString() {
        return "ImpactTweetSource: "
                + "Tweet ID: " + this.id
                + ", screen name: " + this.name
                + ", text: " + this.text
                + ", count: " + this.count
                + ", ratio positives: " + this.ratioPositives
                + ", ratio negatives: " + this.ratioNegatives
                + ", percent: " + this.percent;

    }

    @Override
    public boolean canEquals(Object obj) {
        return obj instanceof ImpactTweetStore;
    }
}
