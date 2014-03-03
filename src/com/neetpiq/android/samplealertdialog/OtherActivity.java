package com.neetpiq.android.samplealertdialog;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.neetpiq.android.samplealertdialog.data.DatabaseManager;
import com.neetpiq.android.samplealertdialog.model.Speaker;
import com.neetpiq.android.samplealertdialog.model.Topic;
import com.neetpiq.android.samplealertdialog.util.ToastUtils;

public class OtherActivity extends Activity implements OnItemSelectedListener {
	
	private Spinner spinnerFood;
	private Spinner spinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		spinnerFood = (Spinner) findViewById(R.id.spinFood);

		// spinner item select listener
        spinnerFood.setOnItemSelectedListener(this);
        
        spinner = (Spinner) findViewById(R.id.spinHintFood);
        
        populateSpinner();
        
        populateTopicSpinner();
	}
	
	/**
     * Adding spinner data
     * */
    private void populateSpinner() {
              
        List<Speaker> speakers = DatabaseManager.getInstance().getAllSpeakers();
 
        // Creating adapter for spinner
        ArrayAdapter<Speaker> spinnerAdapter = new ArrayAdapter<Speaker>(this,
                android.R.layout.simple_spinner_item, speakers);
 
        // Drop down layout style - list view with radio button
        spinnerAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 
        // attaching data adapter to spinner
        spinnerFood.setAdapter(spinnerAdapter);
        
        
        
    }
    
    private void populateTopicSpinner() {
    	
    	List<Topic> topics = DatabaseManager.getInstance().getAllTopics();
    	 
        // Creating adapter for spinner
        ArrayAdapter<Topic> spinnerAdapter = new ArrayAdapter<Topic>(this,
                android.R.layout.simple_spinner_item, topics);
 
        // Drop down layout style - list view with radio button
        spinnerAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        spinner.setPrompt("Seleziona il tribunale");
 
        // attaching data adapter to spinner
        spinner.setAdapter(
        	      new NothingSelectedSpinnerAdapter(
        	    		  spinnerAdapter,
        	            R.layout.spinner_row_nothing_selected,
        	            // R.layout.contact_spinner_nothing_selected_dropdown, // Optional
        	            this));
        
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.other, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		
		case R.id.action_settings:
			ToastUtils.showToast(this, R.string.action_settings);
			return true;
	    // Respond to the action bar's Up/Home button
	    case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        return true;
	    }

		
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {

		ToastUtils.showToast(this, parent.getItemAtPosition(position).toString());
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

		ToastUtils.showToast(this, "Nothing selected");
	}

}
