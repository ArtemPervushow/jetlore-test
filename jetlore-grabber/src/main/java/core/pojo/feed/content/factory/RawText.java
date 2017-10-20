package core.pojo.feed.content.factory;

import core.pojo.feed.content.LinkedContent;

public class RawText extends LinkedContent {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    protected RawText(String value) {
        this.value = value;
    }

    @Override
    public String print() {
        return value;
    }
}
