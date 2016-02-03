package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


/**
 * Created by romansky on 1/12/16.
 * THe end all, the be all, this is a motherfing tweet.
 * @author kou- Various
 * @see Tweetable
 * @see TweetCompare
 * @see TweetList
 */
public abstract class Tweet {
    protected Date date;
    protected String message;

    public abstract Boolean isImportant();

    public Tweet(Date date, String message) {
        this.date = date;
        this.message = message;
    }

    /**
     * The tweet that tweets. Use this to tweet
     * @param message This is a message.
     *
     */
    public Tweet(String message) {
        this.message = message;
        this.date = new Date();
    }


    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
    public String getMessage() {
        return message;
    }

    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }
}