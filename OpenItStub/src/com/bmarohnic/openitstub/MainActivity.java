/*
 * project		MDF3Week1
 * 
 * package		com.example.openitstub
 * 
 * @author		Brent Marohnic
 * 
 * date			Oct 04, 2013
 */
package com.bmarohnic.openitstub;

import com.bmarohnic.openitstub.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MainActivity extends Activity {
	
	Spinner adjectiveSpinner;
	Spinner nounSpinner;
	ArrayAdapter adapter;
	ArrayAdapter adapter2;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Populate the spinners with array values located in the resource/values/strings.xml
		adjectiveSpinner = (Spinner) findViewById(R.id.adjectiveSpinner);
		adapter = ArrayAdapter.createFromResource(this, R.array.madlib_adjective, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		nounSpinner = (Spinner) findViewById(R.id.nounSpinner);
		adapter2 = ArrayAdapter.createFromResource(this, R.array.madlib_noun, android.R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		adjectiveSpinner.setAdapter(adapter);
		nounSpinner.setAdapter(adapter2);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void implicitClick(View view) {
		
		// Create two variable to hold the values from the spinner controls
		String adjectiveString = adjectiveSpinner.getSelectedItem().toString();
		String nounString = nounSpinner.getSelectedItem().toString();
		
		// Declare the intent and the type of action requested
		Intent intent = new Intent(Intent.ACTION_EDIT);
		
		// Place the selected text values retrieved from the spinner controls
		intent.putExtra("adjectiveString", adjectiveString);
		intent.putExtra("nounString", nounString);
		
		// Make an implicit call to the OS to satisfy the intent
		startActivity(intent);
	}

}
