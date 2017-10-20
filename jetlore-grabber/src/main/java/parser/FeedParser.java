package parser;

import core.pojo.feed.Feed;

import java.util.Collection;
import java.util.List;

public interface FeedParser {
    List<Feed> parseFeedsFromRaw(List<String> feeds);
}
