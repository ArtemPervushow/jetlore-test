package parser.facebook;

import core.pojo.feed.Feed;
import core.pojo.feed.FeedSource;
import core.pojo.feed.content.LinkedContent;
import core.pojo.feed.content.factory.ContentFactory;
import parser.FeedParser;
import parser.SimpleFeedParser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

public class FacebookFeedParser extends SimpleFeedParser {

    public FacebookFeedParser() {
        this.source = FeedSource.FACEBOOK;
    }
}
