package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by benkhale on 9/28/15.
 */
public class TweetList implements MyObservable {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    private volatile ArrayList<MyObserver> observers = new ArrayList<MyObserver>();
    
    public void add(Tweet tweet) {
        if(tweets.contains(tweet)) {
            throw new IllegalArgumentException();
        }else {
            tweets.add(tweet);
        }
    }

    private void notifyAllObservers() {
        for (MyObserver observer : observers){
            observer.myNotify(this);
        }
    }

    public boolean contains(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    public boolean equals(TweetList tweetlist){
        return Boolean.FALSE;
    }

    public int getCount() {
        return tweets.size();
    }



    public TweetList getTweets() {
        Collections.sort(tweets);
        return (TweetList) tweets.clone();
    }

    public void addObserver(MyObserver observer){
        observers.add(observer);
    }

}
