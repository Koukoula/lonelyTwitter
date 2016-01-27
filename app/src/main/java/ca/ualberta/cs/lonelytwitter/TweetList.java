package ca.ualberta.cs.lonelytwitter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by koukoula on 1/26/16.
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet){
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }
    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public void delete(Tweet tweet){
        tweets.remove(tweet);
    }

    public void addTweet(Tweet tweet) {
        //Check to make sure that it is not duplicate
        if (tweets.contains(tweet)){
            throw new IllegalArgumentException();
        }
        else {
            tweets.add(tweet);
        }
    }

    public ArrayList getTweets() {
        Comparator comparator = new TweetCompare();
        Collections.sort(tweets, comparator);
        return tweets;
    }

    //public boolean hasTweet(Tweet tweet) {

    //}

    public void removeTweet(Tweet tweet) {
        tweets.remove(tweet);
    }
    public int getCount(){
        return tweets.size();
    }
}
