package pojos;

import java.util.List;
import java.util.Objects;

public class HotTopic {
    private List<String> newspapers;
    private List<String> news;

    public  HotTopic () {}

    public HotTopic (List<String> newspapers, List<String> news ) {
        this.newspapers = newspapers;
        this.news = news;
    }

    public List<String> getNewspapers() {
        return newspapers;
    }

    public List<String> getNews() {
        return news;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof HotTopic) {
            HotTopic other = (HotTopic) obj;
            return  other.canEquals(this) &&
                    Objects.equals(this.newspapers, other.newspapers) &&
                    Objects.equals(this.news, other.news);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.newspapers, this.news);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < this.newspapers.size(); i++) {
            result = result + this.newspapers.get(i) +  ": " + this.news.get(i) + ", ";
        }
        return result;
    }

    public boolean canEquals(Object obj) {
        return obj instanceof HotTopic;
    }
}
