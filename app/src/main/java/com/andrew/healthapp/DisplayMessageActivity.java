package com.andrew.healthapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

@SuppressWarnings("unused")
public class DisplayMessageActivity extends Activity
{
	@Override
    protected void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        
        // Get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String message2 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);

        // Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText("You have a BMI of: " + message + "\n\nYour estimated Body Fat percentage is: " + message2);

        // Set the text view as the activity layout
        setContentView(textView);
        
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

//    /**
//     * A placeholder fragment containing a simple view.
//     */
//    public static class PlaceholderFragment extends Fragment {
//
//        public PlaceholderFragment() { }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                  Bundle savedInstanceState) {
//              View rootView = inflater.inflate(textView,
//                      container, false);
//              return rootView;
//        }
    //}
}
