package core.pojo.feed.content;

import core.pojo.feed.FeedSource;
import core.pojo.feed.content.decorator.ContentDecorator;

import java.util.ArrayList;
import java.util.List;

public abstract class LinkedContent implements PrintableContent, DecoratableContent {
    protected ContentStatus status;
    private LinkedContent next;
    private List<ContentDecorator> decorators;

    public LinkedContent() {
        decorators = new ArrayList<>();
    }

    public LinkedContent getNext() {
        return next;
    }

    public void setNext(LinkedContent next) {
        this.next = next;
    }

    public void linkWithLast(LinkedContent content){
        if(this.next == null){
            this.next = content;
            return;
        }

        LinkedContent tempContent = this.next;
        while (tempContent.next != null){
            tempContent = tempContent.next;
        }

        tempContent.next = content;
    }

    public ContentStatus getStatus() {
        return status;
    }

    @Override
    public void addDecorator(ContentDecorator decorator) {
        decorators.add(decorator);
    }

    @Override
    public String decorateBefore() {
        StringBuilder builder = new StringBuilder();

        for (ContentDecorator decorator:
             decorators) {
            builder.append(decorator.decorateBefore());
        }

        return builder.toString();
    }

    @Override
    public String decorateAfter() {
        StringBuilder builder = new StringBuilder();

        for (ContentDecorator decorator:
                decorators) {
            builder.append(decorator.decorateAfter());
        }

        return builder.toString();
    }
}


