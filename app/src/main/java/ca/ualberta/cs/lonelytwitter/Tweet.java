package ca.ualberta.cs.lonelytwitter;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by salim_000 on 2015-09-14.
 */
public abstract class Tweet implements Comparable<Tweet> {
    private String text;
    private Date date;
    private ArrayList<Mood> moodList = new ArrayList<Mood>();

    public Tweet(String text, Date date) {
        this.text = text;
        this.date = date;
    }

    public Tweet(String text, Date date, Mood mood) {
        this.text = text;
        this.date = date;
        moodList.add(mood);
    }

    public Tweet(String text) {
        this.text = text;
        date = new Date();
    }

    public Tweet(String text, Mood mood) {
        this.text = text;
        date = new Date();
        moodList.add(mood);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void addMood(Mood mood){
        moodList.add(mood);
    }

    public void setText(String text) {
        if (text.length() <= 140) {
            this.text = text;
    }}

    public abstract Boolean isImportant();

    public int compareTo(Tweet tweet){
        if (this.getDate().getTime() > tweet.getDate().getTime())
            return 1;
        else if (this.getDate().getTime() == tweet.getDate().getTime())
            return 0;
        else
            return -1;
    }
}
