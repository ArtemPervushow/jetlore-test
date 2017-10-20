package core.pojo.feed.content.factory;

import core.pojo.feed.FeedSource;
import core.pojo.feed.content.ContentStatus;
import core.pojo.feed.content.LinkedContent;

import java.util.regex.Pattern;

public class Link extends LinkedContent {
    private String value;

    protected static Pattern linkPattern = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");

    protected Link(String value) {
        status = ContentStatus.NEW;

        if(linkPattern.matcher(value).matches()) {
            this.value = value;
            status = ContentStatus.CONSTRUCTED;
        } else {
            this.value = "RAW";
            status = ContentStatus.ERROR;
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if(linkPattern.matcher(value).matches())
            this.status = ContentStatus.CONSTRUCTED;
        else
            this.status = ContentStatus.WARNING;

        this.value = value;
    }

    @Override
    public String print() {
        return value;
    }
}
