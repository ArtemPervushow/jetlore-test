package core.pojo.feed.content;

import core.pojo.feed.content.decorator.ContentDecorator;

/**
 * Created by a.pervushov on 21.10.2017.
 */
public interface DecoratableContent {
    void addDecorator(ContentDecorator decorator);
    String decorateBefore();
    String decorateAfter();
}
