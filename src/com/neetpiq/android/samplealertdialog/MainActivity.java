package com.neetpiq.android.samplealertdialog;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import com.neetpiq.android.samplealertdialog.util.AlertUtil;
import com.neetpiq.android.samplealertdialog.util.ToastUtils;

public class MainActivity extends Activity implements OnClickListener {

	protected static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Set button listeners.
		findViewById(R.id.alertTwoBtn).setOnClickListener(this);
		findViewById(R.id.alertEditBox).setOnClickListener(this);
		findViewById(R.id.alertThreeBtn).setOnClickListener(this);
		findViewById(R.id.alertTimePickerBtn).setOnClickListener(this);
		findViewById(R.id.alertDatePickerBtn).setOnClickListener(this);
		findViewById(R.id.alertSimpleListViewBtn).setOnClickListener(this);
		findViewById(R.id.alertScrollViewBtn).setOnClickListener(this);
		findViewById(R.id.alertFormElementsBtn).setOnClickListener(this);
		findViewById(R.id.alertWebViewBtn).setOnClickListener(this);
		findViewById(R.id.openActivityBtn).setOnClickListener(this);

		Log.i(TAG, "onCreate");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.alertTwoBtn:
			alertTwoButtons();
			break;
			
		case R.id.alertEditBox:
			alertEditBox();
			break;

		case R.id.alertThreeBtn:
			alertThreeButtons();
			break;

		case R.id.alertTimePickerBtn:
			alertTimePicker();
			break;

		case R.id.alertDatePickerBtn:
			alertDatePicker();
			break;

		case R.id.alertSimpleListViewBtn:
			alertSimpleListView();
			break;

		case R.id.alertScrollViewBtn:
			alertScrollView();
			break;

		case R.id.alertFormElementsBtn:
			alertFormElements();
			break;

		case R.id.alertWebViewBtn:
			alertWebView();
			break;

		case R.id.openActivityBtn:
			openActivity();
			break;

		}
	}

	private void alertEditBox() {
		
		Log.i(TAG, getString(R.string.alert_with_edit_box));
		
		/*
		 * Inflate the XML view. activity_main is in
		 * res/layout/form_elements.xml
		 */
		LayoutInflater inflater = this.getLayoutInflater();

		final View editTagsView = inflater.inflate(R.layout.edit_pocket_tags, null);
		
		final EditText newTagsText = (EditText) editTagsView
				.findViewById(R.id.newTags);

		DialogInterface.OnClickListener positiveListener = new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				String toastString = "";

				/*
				 * Getting the value of an EditText.
				 */
				toastString += "Name is: " + newTagsText.getText() + "!";

				ToastUtils.showToast(MainActivity.this, toastString);

			}
		};
		
		DialogInterface.OnClickListener negativeListener = new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				ToastUtils.showToast(MainActivity.this, "You choose to Cancel");

			}
		};

		Dialog dlg = new AlertDialog.Builder(this).setView(editTagsView)
				.setTitle("Add New Tags")
				.setMessage("To add multiple tags at once, separate them with commas.")
				.setPositiveButton("OK", positiveListener)
				.setNegativeButton("Cancel", negativeListener).create();

		dlg.show();
		
	}

	private void openActivity() {

		Log.i(TAG, getString(R.string.open_activity));
		
//		File data = Environment.getDataDirectory();
		
//		ToastUtils.showToast(this, "DataDirectory: " + data.getPath());
		
		Intent otherActivity = new Intent(this, OtherActivity.class);
		startActivity(otherActivity);

	}

	private void alertWebView() {

		Log.i(TAG, getString(R.string.alert_with_web_view));

		// WebView is created programatically here.
		WebView myWebView = new WebView(MainActivity.this);
		myWebView.loadUrl("http://www.google.com/");

		/*
		 * This part is needed so it won't ask the user to open another browser.
		 */
		myWebView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});

		Dialog dlg = new AlertDialog.Builder(this).setView(myWebView)
				.setTitle("Web View")
				.setPositiveButton("OK", null).create();

		dlg.show();

	}

	private void alertFormElements() {

		Log.i(TAG, getString(R.string.alert_with_form_elements));

		/*
		 * Inflate the XML view. activity_main is in
		 * res/layout/form_elements.xml
		 */
		LayoutInflater inflater = this.getLayoutInflater();

		final View formElementsView = inflater.inflate(R.layout.form_elements,
				null);

		// You have to list down your form elements
		final CheckBox myCheckBox = (CheckBox) formElementsView
				.findViewById(R.id.myCheckBox);

		final RadioGroup genderRadioGroup = (RadioGroup) formElementsView
				.findViewById(R.id.genderRadioGroup);

		final EditText nameEditText = (EditText) formElementsView
				.findViewById(R.id.nameEditText);

		DialogInterface.OnClickListener positiveListener = new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				String toastString = "";

				/*
				 * Detecting whether the checkbox is checked or not.
				 */
				if (myCheckBox.isChecked()) {
					toastString += "Happy is checked!\n";
				} else {
					toastString += "Happy IS NOT checked.\n";
				}

				/*
				 * Getting the value of selected RadioButton.
				 */
				// get selected radio button from radioGroup
				int selectedId = genderRadioGroup.getCheckedRadioButtonId();

				if (selectedId != -1) {
					
					// find the radiobutton by returned id
					RadioButton selectedRadioButton = (RadioButton) formElementsView
							.findViewById(selectedId);

					toastString += "Selected radio button is: "
							+ selectedRadioButton.getText() + "!\n";
				} else {
					
					toastString += "Unselected radio button!\n";
					
				}

				/*
				 * Getting the value of an EditText.
				 */
				toastString += "Name is: " + nameEditText.getText() + "!\n";

				ToastUtils.showToast(MainActivity.this, toastString);

			}
		};

		Dialog dlg = new AlertDialog.Builder(this).setView(formElementsView)
				.setTitle("Form Elements")
				.setPositiveButton("OK", positiveListener).create();

		dlg.show();

	}

	private void alertScrollView() {

		Log.i(TAG, getString(R.string.alert_with_scroll_view));

		// Get the layout inflater
		LayoutInflater inflater = this.getLayoutInflater();

		View scrollView = inflater.inflate(R.layout.view_with_scroll, null);

		// textView is the name of our TextView on scrollView
		TextView textView = (TextView) scrollView.findViewById(R.id.textView);

		// Initializing a blank textview so that we can just append a text later
		textView.setText("");

		/*
		 * Display the text 50 times so that it will exceed the device screen
		 * height and be able to scroll
		 */
		for (int x = 1; x < 50; x++) {
			textView.append("You've been HACKED!\n");
			textView.append("By NINJAZHAI.\n");
			textView.append("Just kidding.\n\n");
		}

		Dialog dlg = new AlertDialog.Builder(this).setView(scrollView)
				.setTitle("Scroll View").setPositiveButton("OK", null).create();

		dlg.show();

	}

	private void alertSimpleListView() {

		Log.i(TAG, getString(R.string.alert_with_simple_list_view));

		final CharSequence[] items = { "Red", "Green", "Blue", "Violet",
				"Brown", "White", "Black", "Yellow", "Magenta", "Pink", "Grey" };

		DialogInterface.OnClickListener onItemClickListener = new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				ToastUtils.showToast(MainActivity.this, "You selected "
						+ items[which] + " color");

			}
		};

		Dialog dlg = new AlertDialog.Builder(this).setTitle("Pick a color")
				.setItems(items, onItemClickListener).setCancelable(false)
				.create();

		dlg.show();

	}

	private void alertDatePicker() {

		Log.i(TAG, getString(R.string.alert_with_date_picker));

		ToastUtils.showToast(this, R.string.alert_with_date_picker);

		// Use the current date as the default date in the picker
		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);

		DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {

			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {

				ToastUtils.showToast(MainActivity.this, String.format(
						"%02d.%02d.%04d", dayOfMonth, monthOfYear + 1, year));

			}
		};

		new DatePickerDialog(this, onDateSetListener, year, month, day).show();

	}

	private void alertTimePicker() {

		Log.i(TAG, getString(R.string.alert_with_time_picker));

		// Use the current time as the default values for the picker
		final Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);

		TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {

			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

				ToastUtils.showToast(MainActivity.this,
						String.format("%02d:%02d", hourOfDay, minute));

			}
		};

		// Create a new instance of TimePickerDialog and return it
		Dialog dlg = new TimePickerDialog(this, onTimeSetListener, hour, minute,
				DateFormat.is24HourFormat(this));
		
		dlg.setTitle("Set Time");
		dlg.show();

	}

	private void alertThreeButtons() {

		Log.i(TAG, getString(R.string.alert_with_time_picker));

		DialogInterface.OnClickListener positiveListener = new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				ToastUtils.showToast(MainActivity.this, "You selected to Retweet");

			}
		};

		DialogInterface.OnClickListener negativeListener = new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				ToastUtils.showToast(MainActivity.this, "You selected to Cancel");

			}
		};

		DialogInterface.OnClickListener neutralListener = new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				ToastUtils.showToast(MainActivity.this, "You selected to Quote");

			}
		};

		AlertUtil.showAlert(this, "Retweet", "Retweet this to your followers?",
				"Retweet", positiveListener, "Cancel", negativeListener, "Quote",
				neutralListener);

	}

	private void alertTwoButtons() {

		Log.i(TAG, getString(R.string.alert_with_two_buttons));

		DialogInterface.OnClickListener positiveListener = new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				ToastUtils.showToast(MainActivity.this, "You choose to Erase");

			}
		};

		DialogInterface.OnClickListener negativeListener = new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				ToastUtils.showToast(MainActivity.this, "You choose to Cancel");

			}
		};

		AlertUtil.showAlert(this, "Erase USB Storage?",
				"You'll lose all photos and media!", "Erase", positiveListener,
				"Cancel", negativeListener);

	}

}
