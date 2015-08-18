package com.example.project3;



import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	TextView tvOut;
	Button btnOk;
	Button btnCancel;
	private OnClickListener oclBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tvOut = (TextView) findViewById(R.id.tvOut);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        
        oclBtn = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				switch(v.getId()){
				case R.id.btnOk:
					tvOut.setText("Нажата кнопка ОК");
					break;
				case R.id.btnCancel:
					tvOut.setText("Нажата кнопка Cancel");
					break;
				}
			}
		};
		btnOk.setOnClickListener(oclBtn);
		btnCancel.setOnClickListener(oclBtn);
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
