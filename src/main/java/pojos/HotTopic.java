package pojos;

import java.util.List;
import java.util.Objects;

public class HotTopic {
    private List<String> _newspapers;
    private List<String> _news;

    public  HotTopic () {}

    public HotTopic (List<String> newspapers, List<String> news ) {
        this._newspapers = newspapers;
        this._news = news;
    }

    public List<String> getNewspapers() {
        return _newspapers;
    }

    public List<String> getNews() {
        return _news;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof HotTopic) {
            HotTopic other = (HotTopic) obj;
            return  other.canEquals(this) &&
                    Objects.equals(this._newspapers, other._newspapers) &&
                    Objects.equals(this._news, other._news);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this._newspapers, this._news);
    }

    @Override
    public String toString() {
        String result = "";
        for ( int i = 0; i < this._newspapers.size(); i++) {
            result = result + this._newspapers.get(i) +  ": " + this._news.get(i) + ", ";
        }
        return result;
    }

    public boolean canEquals(Object obj) {
        return obj instanceof HotTopic;
    }
}
