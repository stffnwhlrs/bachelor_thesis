package pojos;

public class Tweet {
    protected long _id;
    protected String _text;
    protected long _userId;
    protected String _screenName;
    protected String _name;
    protected String _fullText;

    public Tweet(){}

    public Tweet(long id, String text, long userId, String screenName, String name, String fullText) {
        this._id = id;
        this._text = text;
        this._userId = userId;
        this._screenName = screenName;
        this._name = name;
        this._fullText = fullText;
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        this._id = id;
    }

    public String getText() {
        return _text;
    }

    public void setText(String text) {
        this._text = text;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        this._userId = userId;
    }

    public String getScreenName() {
        return _screenName;
    }

    public void setScreenName(String screenName) {
        this._screenName = screenName;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getFullText() {
        return _fullText;
    }

    public void setFullText(String fullText) {
        this._fullText = fullText;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tweet) {
            Tweet other = (Tweet) obj;
            return other.canEquals(this) && this._id == other._id;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this._id);
    }

    @Override
    public String toString() {
        return "tweet ID: " + this._id + ", screen name: " + this._screenName + ", text: " + this._text;
    }

    public boolean canEquals(Object obj){
        return obj instanceof Tweet;
    }
}
