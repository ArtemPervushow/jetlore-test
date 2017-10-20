package parser;

import core.pojo.feed.Feed;
import core.pojo.feed.FeedSource;
import core.pojo.feed.content.LinkedContent;
import core.pojo.feed.content.factory.ContentFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a.pervushov on 18.10.2017.
 */
public class SimpleFeedParser implements FeedParser {

    protected FeedSource source;

    @Override
    public List<Feed> parseFeedsFromRaw(List<String> feeds) {
        List<Feed> feedList = new ArrayList<>();

        for (String strFeed:
                feeds) {
            Feed feed = extractFeed(strFeed);
            if(feed != null)
                feedList.add(feed);
        }

        return feedList;
    }

    private Feed extractFeed(String strFeed){
        if(strFeed != null) {
            String[] words = strFeed.split(" ");

            LinkedContent content = null;
            for (String word :
                    words) {
                if (content == null)
                    content = ContentFactory.createContentFromWord(word);
                else
                    content.linkWithLast(ContentFactory.createContentFromWord(word));
            }

            return new Feed(content, source);
        }
        return null;
    }
}
