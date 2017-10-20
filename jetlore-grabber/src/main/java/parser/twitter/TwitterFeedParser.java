package parser.twitter;

import core.pojo.feed.Feed;
import core.pojo.feed.FeedSource;
import parser.FeedParser;
import parser.SimpleFeedParser;

import java.util.ArrayList;
import java.util.List;

public class TwitterFeedParser extends SimpleFeedParser {
    public TwitterFeedParser() {
        this.source = FeedSource.TWITTER;
    }
}
