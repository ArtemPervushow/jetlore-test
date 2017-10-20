package formater.tag;

import core.pojo.feed.Feed;
import core.pojo.feed.FeedSource;
import core.pojo.feed.content.LinkedContent;
import core.pojo.feed.content.factory.Entity;
import core.pojo.feed.content.factory.Link;
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
            builder.append(formatContent(tempContent, feed.getSource()));

            tempContent = tempContent.getNext();
        }

        System.out.println(builder.toString());
    }

    @Override
    public String formatContent(LinkedContent content, FeedSource source){
        return decorateBefore(content, source) + content.print() + decorateAfter(content, source);
    }

    @Override
    public String decorateBefore(LinkedContent content, FeedSource source){
        if(content instanceof Entity){
            return "<strong>";
        }

        if(content instanceof Link){
            return "<a href=";
        }

        if(content instanceof UserName){
            return "<a href="
                    + (source == FeedSource.TWITTER ? "http://twitter.com/" : "http://facebook.com/")
                    + ((UserName)content).getNick();
        }

        return " ";
    }

    @Override
    public String decorateAfter(LinkedContent content, FeedSource source){
        if(content instanceof Entity){
            return "</strong>";
        }

        if(content instanceof Link){
            return "></a>";
        }

        if(content instanceof UserName){
            return "</a>";
        }

        return " ";
    }


}
