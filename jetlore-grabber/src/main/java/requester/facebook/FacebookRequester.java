package requester.facebook;

import core.pojo.feed.FeedKey;
import facebook4j.*;
import facebook4j.auth.AccessToken;
import requester.SocialWebRequester;

import java.util.ArrayList;
import java.util.List;

public class FacebookRequester implements SocialWebRequester {

    private static final String APP_ID = "822453774583074";
    private static final String APP_SECRET = "c35a13f57999a3269b0ef649e906200c";

    private static final FacebookRequester INSTANCE = new FacebookRequester();

    public static FacebookRequester getInstance(){
        return INSTANCE;
    }

    private FacebookFactory facebookFactory;
    private Facebook facebook;

    private FacebookRequester(){
        facebookFactory = new FacebookFactory();
        facebook = facebookFactory.getInstance();
    }

    @Override
    public List<String> getRawFeeds(FeedKey key) {
        List<String> results = new ArrayList<>();

        ResponseList<Post> posts = null;

        try {
            posts = facebook.getFeed(key.getValue());
        } catch (FacebookException e) {
            e.printStackTrace();
        }

        if(posts != null && posts.size() != 0){
            posts.stream().forEach((post) -> {
                results.add(post.getMessage());
            });
        }

        return results;
    }

    @Override
    public boolean authByDefault() {
        facebook.setOAuthAppId(APP_ID, APP_SECRET);

        AccessToken token = null;
        try {
            token = facebook.getOAuthAppAccessToken();
        } catch (FacebookException e) {
            e.printStackTrace();

            return false;
        }
        facebook.setOAuthAccessToken(new AccessToken(token.getToken(), null));

        return true;
    }
}
