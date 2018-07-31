package pojos;

public class Tweet {
    protected long id;
    protected String text;
    protected long userId;
    protected String screenName;
    protected String name;
    protected String fullText;

    public Tweet(){}

    public Tweet(long id, String text, long userId, String screenName, String name, String fullText) {
        this.id = id;
        this.text = text;
        this.userId = userId;
        this.screenName = screenName;
        this.name = name;
        this.fullText = fullText;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tweet) {
            Tweet other = (Tweet) obj;
            return other.canEquals(this) && this.id == other.id;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.id);
    }

    @Override
    public String toString() {
        return "tweet ID: " + this.id + ", screen name: " + this.screenName + ", text: " + this.text;
    }

    public boolean canEquals(Object obj){
        return obj instanceof Tweet;
    }
}
