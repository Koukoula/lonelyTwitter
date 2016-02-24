package ca.ualberta.cs.lonelytwitter;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

/**
 * Created by esports on 2/17/16.
 */
public class ElasticsearchTweetController {
    private static JestDroidClient client;
    //TODO: A function that gets tweets
    public static class GetTweetsTask extends AsyncTask<String, Void, ArrayList<Tweet>> {
        @Override
        protected ArrayList<Tweet> doInBackground(String... searchStrings) {
            verifyClient();
            //Start our initial array list (empty)
            ArrayList<Tweet> tweets = new ArrayList<Tweet>();

            //NOTE: ASSUMING ONLY FIRST SEARCH TERM WILL BE USED
            String query = "{\n" +
                    "    \"query\": {\n" +
                    "        \"filtered\" : {\n" +
                    "            \"query\" : {\n" +
                    "                \"query_string\" : {\n" +
                    "                    \"query\" : \"test\"\n" +
                    "                }\n" +
                    "            },\n" +
                    "            \"filter\" : {\n" +
                    "                \"term\" : { \"user\" : \"ki\" }\n" +
                    "            }\n" +
                    "        }\n" +
                    "    }\n" +
                    "}";

            //query = "{\"from\" : 0, \"size\""
            //I HAVE NO IDEA HOW THIS WORKS
            Search search = new Search.Builder(query)
                    // multiple index or types can be added.
                    .addIndex("testing")
                    .addIndex("tweet")
                    .build();
           // Search search = new Search.Builder(searchStrings[0]).addIndex("testing").addType("tweet").build();

            try {
                SearchResult execute= client.execute(search);
                if (execute.isSucceeded()) {
                    // Return list o tweets.
                    List<NormalTweet> returnedTweets = execute.getSourceAsObjectList(NormalTweet.class);
                    tweets.addAll(returnedTweets);
                } else {
                    //TODO: Error message right here, because this was puzzling.
                    //TODO: Right here it will trigger if the insert fails.
                    Log.i("Todo", "We actually failed here, adding a tweet.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return tweets;
        }
    }
  //  public static ArrayList<Tweet> getTweets(){

 //   }
    //TODO: A function that adds a tweet


    public static class AddTweetTask extends AsyncTask<NormalTweet, Void, Void> {
        protected Void doInBackground(NormalTweet... tweets) {
            verifyClient();

            //Since AsyncTasks work on arrays, we need to work with arrays as well (>= 1 tweet)
            for(int i = 0; i < tweets.length; i++) {
                NormalTweet tweet = tweets[i];

                Index index = new Index.Builder(tweet).index("testing").type("tweet").build();
                try {
                    DocumentResult result = client.execute(index);
                    if (result.isSucceeded()) {
                        // "Set the ID to tweet that elasticsearch told me it was." - Kent 2016
                        tweet.setId(result.getId());
                    } else {
                        //TODO: Error message right here, because this was puzzling.
                        //TODO: Right here it will trigger if the insert fails.
                        Log.i("Todo", "We actually failed here, adding a tweet.");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
    public static void verifyClient() {
        //1. Verify that 'client' exists.
        //TODO: PUT URL SOMEWHERE BETTER SO IT MAKE SENSE.
        if(client == null){
            DroidClientConfig.Builder builder = new DroidClientConfig.Builder("http://cmput301.softwareprocess.es:8080");
            DroidClientConfig config = builder.build();

            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(config);
            client = (JestDroidClient) factory.getObject();
        }
        //2. If it doesn't, make it.
    }
}
