package formater.tag;

import core.pojo.feed.Feed;
import core.pojo.feed.FeedSource;
import core.pojo.feed.content.LinkedContent;
import core.pojo.feed.content.decorator.tag.*;
import core.pojo.feed.content.factory.Entity;
import core.pojo.feed.content.factory.Link;
import core.pojo.feed.content.factory.RawText;
import core.pojo.feed.content.factory.UserName;
import formater.FeedFormater;

import java.util.Collection;

public class TagFormater implements FeedFormater {
    @Override
    public void printReportFromFeeds(Collection<Feed> feeds) {
        for (Feed feed:
             feeds) {
            printFeed(feed);
        }
    }

    @Override
    public void printFeed(Feed feed){
        StringBuilder builder = new StringBuilder();

        LinkedContent tempContent = feed.getHeadContent();
        while (tempContent != null){
            prepareContent(tempContent, feed.getSource());
            builder.append(tempContent.print());

            tempContent = tempContent.getNext();
        }

        System.out.println(builder.toString());
    }

    @Override
    public void prepareContent(LinkedContent linkedContent, FeedSource source) {
        TagDecoratorBuilder builder = new TagDecoratorBuilder(linkedContent, source);

        linkedContent.addDecorator(builder.buildDecorator());
    }

}
