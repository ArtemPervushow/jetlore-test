package core.pojo.feed.content.factory;

import core.pojo.feed.FeedSource;
import core.pojo.feed.content.*;

/**
 * Created by a.pervushov on 18.10.2017.
 */
public class ContentFactory {
    public static LinkedContent createContentFromWord(String word){
        if(Entity.entityPattern.matcher(word).matches()){
            return new Entity(word);
        }

        if(Link.linkPattern.matcher(word).matches()){
            return new Link(word);
        }

        if(UserName.nickPattern.matcher(word).matches()){
            return new UserName(word);
        }

        return new RawText(word);
    }
}
