package core.pojo.feed.content;

import core.pojo.feed.FeedSource;

public abstract class LinkedContent implements PrintableContent {
    protected ContentStatus status;
    private LinkedContent next;

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

    @Override
    public String print(){
        return "";
    }

    public ContentStatus getStatus() {
        return status;
    }
}


