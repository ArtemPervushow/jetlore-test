package core.pojo.feed.content.factory;

import core.pojo.feed.content.LinkedContent;
import core.pojo.feed.content.decorator.LinkDecorator;
import core.pojo.feed.content.decorator.RawTextDecorator;
import core.pojo.feed.content.decorator.tag.TagRawTextDecorator;

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
        return super.decorateBefore() + value + super.decorateAfter();
    }
}
