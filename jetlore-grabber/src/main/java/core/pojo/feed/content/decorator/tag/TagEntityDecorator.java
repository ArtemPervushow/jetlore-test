package core.pojo.feed.content.decorator.tag;

import core.pojo.feed.content.decorator.EntityDecorator;

/**
 * Created by a.pervushov on 21.10.2017.
 */
public class TagEntityDecorator extends EntityDecorator {
    @Override
    public String decorateBefore() {
        return "<strong>";
    }

    @Override
    public String decorateAfter() {
        return "</strong>";
    }
}
