package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by koukoula on 1/12/16.
 */

/**
 * One of the two moods a person can feel.
 * @author koukoula
 * @see AbstactMood
 */
public class Frustrated extends AbstactMood {
    public Frustrated(Date date) {
        super(date);
    }


    @Override
    public String mood() {
        return "ARG";
    }
}
