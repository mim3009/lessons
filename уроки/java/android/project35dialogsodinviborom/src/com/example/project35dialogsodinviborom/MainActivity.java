package com.example.project35dialogsodinviborom;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	final String LOG_TAG = "myLogs";

	final int DIALOG_ITEMS = 1;
	final int DIALOG_ADAPTER = 2;
	final int DIALOG_CURSOR = 3;
	DB db;
	Cursor cursor;

	String data[] = { "one", "two", "three", "four" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		db = new DB(this);
		db.open();
		cursor = db.getAllData();
		startManagingCursor(cursor);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnItems:
			showDialog(DIALOG_ITEMS);
			break;
		case R.id.btnAdapter:
			showDialog(DIALOG_ADAPTER);
			break;
		case R.id.btnCursor:
			showDialog(DIALOG_CURSOR);
			break;
		default:
			break;
		}
	}
	
	protected Dialog onCreateDialog(int id){
		AlertDialog.Builder adb = new AlertDialog.Builder(this);
		switch(id){
		case DIALOG_ITEMS:
			adb.setTitle(R.string.items);
			adb.setSingleChoiceItems(data, -1, myClickListener);
			break;
		case DIALOG_ADAPTER:
			adb.setTitle(R.string.adapter);
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice, data);
			adb.setSingleChoiceItems(adapter, -1, myClickListener);
			break;
		 case DIALOG_CURSOR:
		      adb.setTitle(R.string.cursor);
		      adb.setSingleChoiceItems(cursor, -1, DB.COLUMN_TXT, myClickListener);
		      break;
		}
		adb.setPositiveButton(R.string.ok, myClickListener);
		return adb.create();
	}
	
	OnClickListener myClickListener = new OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			ListView lv = ((AlertDialog)dialog).getListView();
			if(which == Dialog.BUTTON_POSITIVE)
				Log.d(LOG_TAG,"pos = " + lv.getCheckedItemPosition());
			else
				Log.d(LOG_TAG, "which = " + which);
		}
	};
	
	protected void onDestroy(){
		super.onDestroy();
		db.close();
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
