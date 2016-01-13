package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by koukoula on 1/12/16.
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
