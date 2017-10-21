import core.pojo.feed.FeedKey;
import formater.FeedFormater;
import formater.tag.TagFormater;
import parser.FeedParser;
import parser.facebook.FacebookFeedParser;
import parser.twitter.TwitterFeedParser;
import requester.SocialWebRequester;
import requester.facebook.FacebookRequester;
import requester.twitter.TwitterRequester;

import java.util.Scanner;

/**
 * Created by a.pervushov on 18.10.2017.
 */
public class EntryPoint {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose network (1- FB, 2- Twitter, other- exit): ");

        SocialWebRequester requester = null;
        FeedParser parser = null;

        switch (scanner.next()) {
            case "1":
                requester = FacebookRequester.getInstance();
                parser = new FacebookFeedParser();
                break;
            case "2":
                requester = TwitterRequester.getInstance();
                parser = new TwitterFeedParser();
                break;
        }

        if(requester != null && parser != null) {
            requester.authByDefault();

            System.out.println("Enter feed request ('Obama' for example):");
            FeedKey key = new FeedKey(scanner.next());

            FeedFormater formater = new TagFormater();

            formater.printReportFromFeeds(//module 3
                    parser.parseFeedsFromRaw(//module 2
                            requester.getRawFeeds(key)));//module 1
        }
    }
}
