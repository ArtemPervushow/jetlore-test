package core.pojo.feed;

import core.pojo.feed.content.ContentStatus;

public interface PrintableFeed {
    String printAll();
    String printByStatus(ContentStatus status);
}
