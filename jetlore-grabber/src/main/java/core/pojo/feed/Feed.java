package core.pojo.feed;

import core.pojo.feed.content.ContentStatus;
import core.pojo.feed.content.LinkedContent;

public class Feed implements PrintableFeed{
    private LinkedContent headContent;
    private FeedSource source;

    public Feed(LinkedContent headContent, FeedSource source) {
        this.headContent = headContent;
        this.source = source;
    }

    public LinkedContent getHeadContent() {
        return headContent;
    }

    public void setHeadContent(LinkedContent headContent) {
        this.headContent = headContent;
    }

    public FeedSource getSource() {
        return source;
    }

    public void setSource(FeedSource source) {
        this.source = source;
    }

    @Override
    public String printAll() {
        StringBuilder builder = new StringBuilder();

        LinkedContent tempContent = headContent;
        while (tempContent != null){
            builder.append(tempContent.print());

            tempContent = tempContent.getNext();
        }

        return builder.toString();
    }

    @Override
    public String printByStatus(ContentStatus status) {
        StringBuilder builder = new StringBuilder();

        LinkedContent tempContent = headContent;
        while (tempContent != null){
            if(tempContent.getStatus() == status)
                builder.append(tempContent.print());

            tempContent = tempContent.getNext();
        }

        return builder.toString();
    }
}
