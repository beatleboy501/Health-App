package com.andrew.healthapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
		
		// Get the text entered by the user
		EditText editWeight = (EditText) findViewById(R.id.edit_message);
		EditText editHeight = (EditText) findViewById(R.id.edit_height);
		EditText editWaist = (EditText) findViewById(R.id.edit_waist);
		EditText editHips = (EditText) findViewById(R.id.edit_hips);
		EditText editNeck = (EditText) findViewById(R.id.edit_neck);

		RadioGroup radioSexGroup = (RadioGroup) findViewById(R.id.radio_sex);
		RadioButton radioSexButton = (RadioButton) findViewById(radioSexGroup.getCheckedRadioButtonId());
		final boolean isMale = radioSexButton.getText().toString().equals("Male");

		// Convert the text to String
		String printWeight = editWeight.getText().toString();
		String printHeight = editHeight.getText().toString();
		String printWaist = editWaist.getText().toString();
		String printHips = editHips.getText().toString();
		String printNeck = editNeck.getText().toString();
		
		// Convert the String to Integers
		final double calcWeight = Double.parseDouble(printWeight);
		final double calcHeight = Double.parseDouble(printHeight);
		final double calcWaist = Double.parseDouble(printWaist);
		final double calcHips = Double.parseDouble(printHips);
		final double calcNeck = Double.parseDouble(printNeck);
		
		// Do the calculations for BMI
		String bmi = CalculationHelper.calculateBmi(calcWeight, calcHeight);

		// Do the calculations for Body Fat
		String bodyFat = CalculationHelper.calculateBodyFat(calcWaist, calcHips, calcHeight, calcNeck, isMale);

		intent.putExtra(EXTRA_MESSAGE, bmi);
		intent.putExtra(EXTRA_MESSAGE2, bodyFat);
		
		startActivity(intent);
	}
}
