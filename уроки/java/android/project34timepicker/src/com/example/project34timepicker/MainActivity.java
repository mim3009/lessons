package com.example.project34timepicker;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;


public class MainActivity extends Activity {
	
	int DIALOG_TIME = 1;
	int myHour = 14;
	int myMinute = 35;
	TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTime = (TextView) findViewById(R.id.tvTime);
    }

    public void onClick(View v){
    	showDialog(DIALOG_TIME);
    }
    
    protected Dialog onCreateDialog(int id){
		if(id == DIALOG_TIME){
			TimePickerDialog tpd = new TimePickerDialog(this, myCallback, myHour, myMinute, true);
			return tpd;
		}
    	return super.onCreateDialog(id);
    }
    
    OnTimeSetListener myCallback = new OnTimeSetListener() {
		
		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			myHour = hourOfDay;
			myMinute = minute;
			tvTime.setText("Time is " + myHour + " hours " + myMinute + " minutes");			
		}
	};

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
}
