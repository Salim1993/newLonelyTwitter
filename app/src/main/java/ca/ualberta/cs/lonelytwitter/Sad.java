package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by salim_000 on 2015-09-14.
 */
public class Sad extends Mood {


    public Sad(Date date) {
        super(date);
    }

    public Sad() {
    }

    @Override
    public String howDoYouFeel() {
        return "I'm sad";
    }
}
