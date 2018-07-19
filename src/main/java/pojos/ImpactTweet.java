package pojos;

import java.util.Objects;

public  abstract class ImpactTweet {
    protected long _id;
    protected String _name;
    protected String _text;

    public ImpactTweet () {}

    public ImpactTweet (long id, String screenName, String text) {
        this._id = id;
        this._name = screenName;
        this._text = text;
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        this._id = id;
    }

    public String getScreenName() {
        return _name;
    }

    public void setScreenName(String name) {
        this._name = name;
    }

    public String getText() {
        return _text;
    }

    public void setText(String text) {
        this._text = text;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ImpactTweet) {
            ImpactTweet other = (ImpactTweet) obj;
            return other.canEquals(this) && this._id == other._id;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this._id);
    }

    @Override
    public String toString() {
        return "tweet ID: " + this._id + ", user: " + this._name + ", text: " + this._text;
    }

    public boolean canEquals(Object obj) {
        return obj instanceof ImpactTweet;
    }
}
