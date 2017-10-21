package formater;

import core.pojo.feed.Feed;
import core.pojo.feed.FeedSource;
import core.pojo.feed.content.LinkedContent;

import java.util.Collection;

public interface FeedFormater {
    void printReportFromFeeds(Collection<Feed> feeds);
    void printFeed(Feed feed);
    void prepareContent(LinkedContent linkedContent, FeedSource source);
}
