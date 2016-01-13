package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
import java.util.List;

/**
 * Created by koukoula on 1/12/16.
 */
public class normalTweet extends tweet {
    public normalTweet(Date date, String message, List listOfMoods) {
        super(date, message, listOfMoods);
    }

    public normalTweet(List listOfMoods) {
        super(listOfMoods);
    }

    public normalTweet(String message) {
        super(message);
    }

}
