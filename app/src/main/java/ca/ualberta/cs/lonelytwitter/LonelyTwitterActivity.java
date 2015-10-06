package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class LonelyTwitterActivity extends Activity implements MyObserver {

	private static final String FILENAME = "file.sav";  //model
	private EditText bodyText;   //model
	private ListView oldTweetsList;  //modle
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		Tweet tweet; //model


		try {
			tweet = new ImportantTweet("longer than 140 characters");  //model
		} catch (IOException e) {
			//e.printStackTrace();
			throw new RuntimeException();   //controller
		}


		super.onCreate(savedInstanceState);  //controller
		setContentView(R.layout.main);     //controller

		bodyText = (EditText) findViewById(R.id.body);    //view
		Button saveButton = (Button) findViewById(R.id.save);    //view
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);    //view

		//this whole block is controller
		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				saveInFile(text, new Date(System.currentTimeMillis()));
				finish();

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		String[] tweets = loadFromFile();  //model
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,  //controller
				R.layout.list_item, tweets);   //controller
		oldTweetsList.setAdapter(adapter);  //controller
	}

	private String[] loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();  //model
		try {
			FileInputStream fis = openFileInput(FILENAME);  //controller
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));  //contoller
			String line = in.readLine();   //model
			while (line != null) {    //controller
				tweets.add(line);   //model
				line = in.readLine();   //model
			}

		} catch (FileNotFoundException e) {   //controller
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {  //controller
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets.toArray(new String[tweets.size()]);    //model
	}


	//This whole block is a controller
	private void saveInFile(String text, Date date) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_APPEND);
			fos.write(new String(date.toString() + " | " + text)
					.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void myNotify(MyObservable observable) {
		adapter.notifyDataSetChanged;  //controller
	}
}