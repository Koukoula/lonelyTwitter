package ca.ualberta.cs.lonelytwitter;

import java.util.Comparator;

/**
 * Created by koukoula on 1/26/16.
 */
//How to implement comparators from http://stackoverflow.com/questions/16425127/how-to-use-collections-sort-in-java-specific-situation
public class TweetCompare implements Comparator<Tweet>  {

    public int compare(Tweet tweet1, Tweet tweet2 ){
        return tweet1.getDate().compareTo(tweet2.getDate());

    }
}
