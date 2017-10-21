package core.pojo.feed.content.decorator.tag;

import core.pojo.feed.content.decorator.LinkDecorator;

/**
 * Created by a.pervushov on 21.10.2017.
 */
public class TagLinkDecorator extends LinkDecorator {
    @Override
    public String decorateBefore() {
        return "<a href=";
    }

    @Override
    public String decorateAfter() {
        return "></a>";
    }
}
