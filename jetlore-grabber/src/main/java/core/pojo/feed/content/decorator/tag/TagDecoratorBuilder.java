package core.pojo.feed.content.decorator.tag;

import core.pojo.feed.FeedSource;
import core.pojo.feed.content.LinkedContent;
import core.pojo.feed.content.decorator.ContentDecorator;
import core.pojo.feed.content.decorator.DecoratorBuilder;
import core.pojo.feed.content.factory.Entity;
import core.pojo.feed.content.factory.Link;
import core.pojo.feed.content.factory.RawText;
import core.pojo.feed.content.factory.UserName;

/**
 * Created by a.pervushov on 21.10.2017.
 */
public class TagDecoratorBuilder extends DecoratorBuilder{

    public TagDecoratorBuilder(LinkedContent linkedContent, FeedSource source) {
        super(linkedContent, source);
    }

    //Maybe it must be Abstract Factory... i based on assumption than we DON'T need decorate most of Content types
    @Override
    public ContentDecorator buildDecorator() {
        if(linkedContent instanceof Entity){
            return new TagEntityDecorator();
        }

        if(linkedContent instanceof Link){
            return new TagLinkDecorator();
        }

        if(linkedContent instanceof UserName){
            return new TagUserNameDecorator(source,((UserName) linkedContent).getNick());
        }

        return new TagRawTextDecorator();
    }
}
