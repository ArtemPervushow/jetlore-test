package core.pojo.feed.content.decorator.tag;

import core.pojo.feed.content.decorator.RawTextDecorator;
import core.pojo.feed.content.decorator.UserNameDecorator;

/**
 * Created by a.pervushov on 21.10.2017.
 */
public class TagRawTextDecorator extends RawTextDecorator {
    @Override
    public String decorateBefore() {
        return " ";
    }

    @Override
    public String decorateAfter() {
        return " ";
    }
}
