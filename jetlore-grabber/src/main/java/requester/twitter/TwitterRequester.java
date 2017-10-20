package requester.twitter;

import core.pojo.feed.FeedKey;
import requester.SocialWebRequester;
import twitter4j.*;
import twitter4j.auth.AccessToken;

import java.util.ArrayList;
import java.util.List;

public class TwitterRequester implements SocialWebRequester {

    private static final String CONSUMER_KEY = "MC6d5U7yJvzetDfsseboXzPh2";

    private static final String CONSUMER_SECRET = "Js0K6M7UtYpV8SvwvxquZ1dX6Ty8WfLX0V8QCyvwuzKVllSAyg";

    private static final String ACCESS_TOKEN = "1908368161-tzguSX5HgqkpnAJYPES7bh7mbRiscmE8VRzu7if";

    private static final String ACCESS_TOKEN_SECRET = "LQejM7m8OyZIcSDI5BqWL1NlSMdvsARkqNpkgrLi1FbPt";

    private static final TwitterRequester INSTANCE = new TwitterRequester();

    private TwitterFactory twitterFactory;
    private Twitter twitter;

    private TwitterRequester(){
        twitterFactory = new TwitterFactory();
    }

    public static TwitterRequester getInstance(){
        return INSTANCE;
    }

    @Override
    public boolean authByDefault() {
        twitter = twitterFactory.getInstance();

        twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        twitter.setOAuthAccessToken(new AccessToken(ACCESS_TOKEN, ACCESS_TOKEN_SECRET));

        return true;
    }

    @Override
    public List<String> getRawFeeds(FeedKey key) {
        List<String> results = new ArrayList<>();

        Query query = new Query(key.getValue());
        QueryResult result = null;
        try {
            result = twitter.search(query);
        } catch (TwitterException e) {
            e.printStackTrace();
        }

        result.getTweets().stream().forEach( (status) -> {
            results.add(status.getText());
        });

        return results;
    }
}
