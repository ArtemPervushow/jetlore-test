package core.pojo.feed.content.factory;

import core.pojo.feed.FeedSource;
import core.pojo.feed.content.ContentStatus;
import core.pojo.feed.content.LinkedContent;
import core.pojo.feed.content.decorator.ContentDecorator;
import core.pojo.feed.content.decorator.EntityDecorator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Entity extends LinkedContent {

    protected static Pattern entityPattern = Pattern.compile("\\b[A-Z][a-zA-Z]*\\b");
    private String name;

    protected Entity(String name) {
        status = ContentStatus.NEW;

        if(entityPattern.matcher(name).matches()) {
            this.name = name;
            status = ContentStatus.CONSTRUCTED;
        } else {
            this.name = "RAW";
            status = ContentStatus.ERROR;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(entityPattern.matcher(name).matches())
            this.status = ContentStatus.CONSTRUCTED;
        else
            this.status = ContentStatus.WARNING;

        this.name = name;
    }

    @Override
    public String print() {
        return super.decorateBefore() + name + super.decorateAfter();
    }
}
