package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.Date;

/**
 * Created by salim_000 on 2015-09-14.
 */
public class NormalTweet extends Tweet implements Tweetable{
    public NormalTweet(String text, Date date, Mood mood) {
        super(text, date, mood);
    }

    public NormalTweet(String text, Mood mood) {
        super(text, mood);
    }

    public NormalTweet(String text, Date date) {
        super(text, date);
    }

    public NormalTweet(String text) {
        super(text);
        setText(text);
    }

    @Override
    public Boolean isImportant(){
        return Boolean.FALSE;
    }
}
