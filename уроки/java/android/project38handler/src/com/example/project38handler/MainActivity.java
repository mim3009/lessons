package com.example.project38handler;

import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {

	final String LOG_TAG = "myLogs";

	final int STATUS_NONE = 0; // ��� �����������
	final int STATUS_CONNECTING = 1; // ������������
	final int STATUS_CONNECTED = 2; // ����������

	Handler h;
	TextView tvStatus;
	ProgressBar pbConnect;
	Button btnConnect;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tvStatus = (TextView) findViewById(R.id.tvStatus);
		pbConnect = (ProgressBar) findViewById(R.id.pbConnect);
		btnConnect = (Button) findViewById(R.id.btnConnect);

		h = new Handler() {
			public void handleMessage(android.os.Message msg) {
				switch (msg.what) {
				case STATUS_NONE:
					btnConnect.setEnabled(true);
					tvStatus.setText("Not connected");
					break;
				case STATUS_CONNECTING:
					btnConnect.setEnabled(false);
					pbConnect.setVisibility(View.VISIBLE);
					tvStatus.setText("Connecting");
					break;
				case STATUS_CONNECTED:
					pbConnect.setVisibility(View.GONE);
					tvStatus.setText("Connected");
					break;
				}
			}
		};
	}

	public void onClick(View v) {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					h.sendEmptyMessage(STATUS_CONNECTING);
					TimeUnit.SECONDS.sleep(2);
					h.sendEmptyMessage(STATUS_CONNECTED);
					TimeUnit.SECONDS.sleep(3);
					h.sendEmptyMessage(STATUS_NONE);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t.start();
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
