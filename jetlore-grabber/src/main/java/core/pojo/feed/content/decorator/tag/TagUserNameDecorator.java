package core.pojo.feed.content.decorator.tag;

import core.pojo.feed.FeedSource;
import core.pojo.feed.content.decorator.UserNameDecorator;
import core.pojo.feed.content.factory.UserName;

/**
 * Created by a.pervushov on 21.10.2017.
 */
public class TagUserNameDecorator extends UserNameDecorator {
    private FeedSource source;
    private String userName;

    public TagUserNameDecorator(FeedSource source, String userName) {
        this.source = source;
        this.userName = userName;
    }

    @Override
    public String decorateBefore() {
        return "<a href="
                + (source == FeedSource.TWITTER ? "http://twitter.com/" : "http://facebook.com/")
                + userName
                + ">";
    }

    @Override
    public String decorateAfter() {
        return "</a>";
    }
}
