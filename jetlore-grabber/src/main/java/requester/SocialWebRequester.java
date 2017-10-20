package requester;

import core.pojo.feed.FeedKey;

import java.util.List;

public interface SocialWebRequester {
    List<String> getRawFeeds(FeedKey key);
    boolean authByDefault();
}
