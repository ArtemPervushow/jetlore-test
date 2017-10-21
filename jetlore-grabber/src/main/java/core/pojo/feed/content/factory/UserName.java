package core.pojo.feed.content.factory;

import core.pojo.feed.FeedSource;
import core.pojo.feed.content.ContentStatus;
import core.pojo.feed.content.LinkedContent;
import core.pojo.feed.content.decorator.RawTextDecorator;
import core.pojo.feed.content.decorator.UserNameDecorator;

import java.util.regex.Pattern;

public class UserName extends LinkedContent {
    private String nick;

    protected static Pattern nickPattern = Pattern.compile("@[a-zA-Z]+");

    protected UserName(String value) {
        status = ContentStatus.NEW;

        if(nickPattern.matcher(value).matches()) {
            this.nick = value;
            status = ContentStatus.CONSTRUCTED;
        } else {
            this.nick = "RAW";
            status = ContentStatus.ERROR;
        }
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        if(nickPattern.matcher(nick).matches())
            this.status = ContentStatus.CONSTRUCTED;
        else
            this.status = ContentStatus.WARNING;

        this.nick = nick;
    }

    @Override
    public String print() {
        return super.decorateBefore() + nick + super.decorateAfter();
    }
}
