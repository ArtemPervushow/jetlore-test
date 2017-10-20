package core.pojo.feed;

public class FeedKey {
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public FeedKey(String value) {
        this.value = value;
    }

    private String value;
}
