package core.pojo.feed.content.decorator;

import core.pojo.feed.FeedSource;
import core.pojo.feed.content.LinkedContent;

/**
 * Created by a.pervushov on 21.10.2017.
 */
public abstract class DecoratorBuilder {
    protected LinkedContent linkedContent;
    protected FeedSource source;

    public DecoratorBuilder(LinkedContent linkedContent, FeedSource source) {
        this.linkedContent = linkedContent;
        this.source = source;
    }

    public abstract ContentDecorator buildDecorator();
}
