package ca.ualberta.cs.lonelytwitter;

/**
 * Created by salim_000 on 2015-09-14.
 */
import java.util.Date;

/**
 * Created by salim_000 on 2015-09-14.
 */
public class Happy extends Mood {


    public Happy(Date date) {
        super(date);
    }

    public Happy() {
    }

    @Override
    public String howDoYouFeel() {
        return "I'm happy";
    }
}
