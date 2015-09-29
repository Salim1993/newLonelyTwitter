package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.Date;

/**
 * Created by salim_000 on 2015-09-14.
 */
public class ImportantTweet extends Tweet implements Tweetable {
    public ImportantTweet(String text, Date date) {
        super(text, date);
    }

    public ImportantTweet(String text, Date date, Mood mood) {
        super(text, date, mood);
    }

    public ImportantTweet(String text, Mood mood) {
        super(text, mood);
    }

    public ImportantTweet(String text) throws IOException {
        super(text);
        this.setText(text);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    public Boolean isGood() {
        return Boolean.FALSE;
    }
}
