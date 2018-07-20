package pojos;

import java.util.Objects;

public  abstract class ImpactTweet {
    public long id;
    public String name;
    public String text;

    public ImpactTweet () {}

    public ImpactTweet (long id, String screenName, String text) {
        this.id = id;
        this.name = screenName;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getScreenName() {
        return name;
    }

    public void setScreenName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ImpactTweet) {
            ImpactTweet other = (ImpactTweet) obj;
            return other.canEquals(this) && this.id == other.id;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        return "tweet ID: " + this.id + ", user: " + this.name + ", text: " + this.text;
    }

    public boolean canEquals(Object obj) {
        return obj instanceof ImpactTweet;
    }
}
