package com.andrew.healthapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

@SuppressWarnings("unused")
public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "com.andrew.healthapp.MESSAGE";
	public final static String EXTRA_MESSAGE2 = "com.andrew.healthapp.MESSAGE2";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/** Called when the user clicks the Send button */
	public void sendMessage(View view) throws Exception
	{
	    // Do something in response to button
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		Intent intent2 = new Intent(this, DisplayMessageActivity.class);
		
		// Get the text entered by the user
		EditText editWeight = (EditText) findViewById(R.id.edit_message);
		EditText editHeight = (EditText) findViewById(R.id.edit_height);
		EditText editWaist = (EditText) findViewById(R.id.edit_waist);
		EditText editHips = (EditText) findViewById(R.id.edit_hips);
		EditText editForearm = (EditText) findViewById(R.id.edit_forearm);
		EditText editWrist = (EditText) findViewById(R.id.edit_wrist);
		EditText editNeck = (EditText) findViewById(R.id.edit_neck);
		
		// Convert the text to String
		String printWeight = editWeight.getText().toString();
		String printHeight = editWeight.getText().toString();
		String printWaist = editWaist.getText().toString();
		String printHips = editHips.getText().toString();
		String printForearm = editForearm.getText().toString();
		String printWrist = editWrist.getText().toString();
		String printNeck = editNeck.getText().toString();
		
		// Convert the String to Integers
		final int calcWeight = Integer.parseInt(printWeight);
		final int calcHeight = Integer.parseInt(printHeight);
		final int calcWaist = Integer.parseInt(printWaist);
		final int calcHips = Integer.parseInt(printHips);
		final int calcForearm = Integer.parseInt(printForearm);
		final int calcWrist = Integer.parseInt(printWrist);
		final int calcNeck = Integer.parseInt(printNeck);
		
		// Do the calculations for BMI
		double BMI = Math.round((calcWeight/(Math.pow(calcHeight,2)))*703);
		String bmi = Double.toString(BMI);
		
		// Do the calculations for Body Fat
		double bodyFat3;
		double result1 = (calcWeight*1.082)+94.42;
		double leanBodyWeight = result1-(calcWaist*4.15);
		double bodyFat1 = ((calcWeight-leanBodyWeight)*100)/calcWeight;
		double bodyFat2 = 86.01*(Math.log10(calcWaist-calcNeck))-70.042*(Math.log10(calcHeight))+36.76;
		bodyFat3 = (bodyFat1+bodyFat2)/2;
		String bodyFat = Double.toString(bodyFat3);
		
		intent.putExtra(EXTRA_MESSAGE, bmi);
		intent2.putExtra(EXTRA_MESSAGE2, bodyFat);
		
		startActivity(intent);
		startActivity(intent2);
	}
}
