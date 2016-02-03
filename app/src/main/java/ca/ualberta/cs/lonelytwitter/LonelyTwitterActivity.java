package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * the main activity for a small personal Twitter app to capture, notes and comments
 * <p><It saves the input tweets in the json files./p>
 *     @since 1.2.1
 *     @see LonelyTwitterActivity for more information.
 *     @author: Various,
 *
 */
public class LonelyTwitterActivity extends Activity {
	public ArrayList<String> listOfitems;
	static final String GENERAL_FILE_NAME = "fileName.json";

	private int calculateTweetSize(){
		return -1;
	}
	private String removeStopWords(String text){
		return "";
	}
	private void startSecondActivity(Intent intent){
		//
	}
	 public String someMethod(String s){
		 return "";
	 }
	public boolean evaluateOtherActivity(Intent intent){
		int count = 0;
		String s ="";
		Intent intent1 = new Intent();
		String expression1="",expression2 = "",expression3 = "",expression4 = "";
		startSecondActivity(intent1);
		String S = someMethod(expression1 + expression2 + expression3 +
								expression4);

		someMethod(expression1 + expression2 + expression3 + expression4);
		//for
		try {
			int a = 1;
			int b = 2;
			if (a < 2) {
				someMethod("First choice");
			} else {
				someMethod("Second choice");
			}

			while (1 < 2) {
				int j = 0;
			}
		}
		catch (Exception e){}
		return true;
	}

	private static final String FILENAME = "file.sav";
	/**
	 * The body text.
	 */
	private EditText bodyText;

	private ListView oldTweetsList;
	
	/** Called when the activity is first created. */
	/**
	 * list of all tweets.
	 */
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweet latestTweet = new NormalTweet(text);
				ImportantTweet latestImportantTweet = new ImportantTweet(text);
				//latestTweet.setMessage(latestTweet.getMessage() + "!");
				tweets.add(latestTweet);
				adapter.notifyDataSetChanged();
				saveInFile();

				//saveInFile(text, new Date(System.currentTimeMillis()));
				//finish();

			}
		});
		clearButton.setOnClickListener(new View.OnClickListener() {
			//TODO
			public void onClick(View v) {
				tweets.clear();
				adapter.notifyDataSetChanged();;
				saveInFile();
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		//String[] tweets = loadFromFile();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
						R.layout.list_item, tweets);
		//ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		//		R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}



	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();

			// Took from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html 01-19 2016
			Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
			tweets = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					0);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			Gson gson = new Gson();
			gson.toJson(tweets, out);
			out.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}