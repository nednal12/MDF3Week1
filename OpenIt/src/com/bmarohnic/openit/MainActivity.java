/*
 * project		MDF3Week1
 * 
 * package		com.example.openit
 * 
 * @author		Brent Marohnic
 * 
 * date			Oct 04, 2013
 */
package com.bmarohnic.openit;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.widget.TextView;
 
public class MainActivity extends Activity {
	
	TextView sentenceTextView;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Remove the title bar
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		// Force screen orientation to be portrait only
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		// Incorporate the layout
		setContentView(R.layout.activity_main);
		
		
		// Declare the variables that will be used to hold the values passed in by the calling app
		String adjectiveString = null;
		String nounString = null;
		
		sentenceTextView = (TextView) findViewById(R.id.madlibSentence);
		
		// Retrieve the values passed in by the calling application
		Bundle data = getIntent().getExtras();
		
		// Ensure that the values exist.
		// If so produce the string by using the selected values.
		if(data != null)
		{
			adjectiveString = data.getString("adjectiveString");
			nounString = data.getString("nounString");
			Log.i("onCreate", "adjectiveString: " + adjectiveString);
			Log.i("onCreate", "nounString: " + nounString);
			
			sentenceTextView.setText("The " + adjectiveString + " brown " + nounString + " jumped over the lazy dog.");
		}
		// If the values are not located in the bundle, the application was opened directly and not via an implicit intent
		// Inform the user to call the app using the stub application
		else
		{
			sentenceTextView.setText("Please launch this application via the OpenItStub app.");
		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
