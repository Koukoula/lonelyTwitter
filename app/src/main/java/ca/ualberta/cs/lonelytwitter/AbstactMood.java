package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by koukoula on 1/12/16.
 */

/**
 * An abstract class for moods.
 * @author: Some TA.
 * @see: Frustrated, StillFrustrated
 */
public abstract class AbstactMood {
    protected Date date;

    public abstract String mood();


    public AbstactMood(Date date) {
        this.date = date;
    }
    public void AbstractMood() {
        this.date = new Date(System.currentTimeMillis());
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
