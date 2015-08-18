package com.example.project37povorotekrana;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	final String LOG_TAG = "myLogs";
	int cnt = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(LOG_TAG, "onCreate");
	}

	protected void onDestroy() {
		super.onDestroy();
		Log.d(LOG_TAG, "onDestroy");
	}

	protected void onPause() {
		super.onPause();
		Log.d(LOG_TAG, "onPause");
	}

	protected void onRestart() {
		super.onRestart();
		Log.d(LOG_TAG, "onRestart");
	}

	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		cnt = savedInstanceState.getInt("count");
		Log.d(LOG_TAG, "onRestoreInstanceState");
	}

	protected void onResume() {
		super.onResume();
		Log.d(LOG_TAG, "onResume ");
	}

	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("count", cnt);
		Log.d(LOG_TAG, "onSaveInstanceState");
	}

	protected void onStart() {
		super.onStart();
		Log.d(LOG_TAG, "onStart");
	}

	protected void onStop() {
		super.onStop();
		Log.d(LOG_TAG, "onStop");
	}

	public void onclick(View v) {
		Toast.makeText(this, "Count = " + ++cnt, Toast.LENGTH_SHORT).show();
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
}
