package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.TestCase;

/**
 * Created by benkhale on 9/28/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 implements MyObserver{
    private Boolean wasNotified = Boolean.FALSE;

    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testAddObserver(){
        TweetList list = new TweetList();
        list.addObserver(this);
        wasNotified = Boolean.FALSE;
        list.addObserver(new NormalTweet("test"));
        assertTrue(wasNotified);
    }

    public void testAddTweet() {
        TweetList list = new TweetList();
        list.add(new NormalTweet("test"));
        try{
            list.add(new NormalTweet("test"));
        }catch(Exception e){

        }
    }

    public void testGetTweets() {
        TweetList list = new TweetList();
        Tweet tweeter = new NormalTweet("lols");
        list.add(new NormalTweet("test"));
        list.add(new NormalTweet("rest"));
        list.add(new NormalTweet("nest"));
        list.add(new NormalTweet("crest"));
        list.add(tweeter);


        TweetList solution = new TweetList();
        solution.add(tweeter);
        solution.add(new NormalTweet("test"));
        solution.add(new NormalTweet("rest"));
        solution.add(new NormalTweet("nest"));
        solution.add(new NormalTweet("crest"));
        assertEquals(solution,list.getTweets());
    }

    public void testDeleteTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        list.delete(tweet);
        assertFalse(list.contains(tweet));
    }

    public void testContains() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertTrue(list.contains(tweet));
    }

    public void testGetCount() {
        TweetList list = new TweetList();
        list.add(new NormalTweet("test"));
        list.add(new NormalTweet("rest"));
        list.add(new NormalTweet("nest"));
        list.add(new NormalTweet("crest"));

        assertEquals(4,list.getCount());
    }
}