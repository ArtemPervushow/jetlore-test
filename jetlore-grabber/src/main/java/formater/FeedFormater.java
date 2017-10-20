package formater;

import core.pojo.feed.Feed;
import core.pojo.feed.FeedSource;
import core.pojo.feed.content.LinkedContent;

import java.util.Collection;

public interface FeedFormater {
    void printReportFromFeeds(Collection<Feed> feeds);
    void printFeed(Feed feed);
    String formatContent(LinkedContent content, FeedSource source);
    String decorateBefore(LinkedContent content, FeedSource source);
    String decorateAfter(LinkedContent content, FeedSource source);
}
