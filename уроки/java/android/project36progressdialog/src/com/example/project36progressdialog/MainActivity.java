package com.example.project36progressdialog;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	ProgressDialog pd;
	Handler h;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnDefault:
			pd = new ProgressDialog(this);
			pd.setTitle("Title");
			pd.setMessage("Message");
			pd.setButton(Dialog.BUTTON_POSITIVE, "ok", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub

				}
			});
			pd.show();
			break;
		case R.id.btnHoriz:
			pd = new ProgressDialog(this);
			pd.setTitle("Title");
			pd.setMessage("Message");
			pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			pd.setMax(2000);
			pd.setIndeterminate(true);
			pd.show();
			h = new Handler() {
				public void handleMessage(Message msg) {
					pd.setIndeterminate(false);
					if (pd.getProgress() < pd.getMax()) {
						pd.incrementProgressBy(50);
						pd.incrementSecondaryProgressBy(75);
						h.sendEmptyMessageDelayed(0, 100);
					} else {
						pd.dismiss();
					}
				}
			};
			h.sendEmptyMessageDelayed(0, 2000);
			break;
		default:
			break;
		}
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
