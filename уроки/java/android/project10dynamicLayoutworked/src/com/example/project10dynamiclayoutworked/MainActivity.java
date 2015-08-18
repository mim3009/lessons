package com.example.project10dynamiclayoutworked;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener{
	
	LinearLayout llMain;
	RadioGroup rgGravity;
	EditText etName;
	Button btnCreate;
	Button btnClear;
	
	int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        llMain = (LinearLayout) findViewById(R.id.llMain);
        rgGravity = (RadioGroup) findViewById(R.id.rgGravity);
        etName = (EditText) findViewById(R.id.etName);
        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(this);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);
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


	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.btnCreate:
			LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(wrapContent,wrapContent);
			int btnGravity = Gravity.LEFT;
			switch(rgGravity.getCheckedRadioButtonId()){
			case R.id.rbLeft:
				btnGravity = Gravity.LEFT;
				break;
			case R.id.rbCenter:
				btnGravity = Gravity.CENTER;
				break;
			case R.id.rbRight:
				btnGravity = Gravity.RIGHT;
				break;
			}
			lParams.gravity = btnGravity;
			
			Button btnNew = new Button(this);
			btnNew.setText(etName.getText().toString());
			llMain.addView(btnNew,lParams);
			break;
		case R.id.btnClear:
			llMain.removeAllViews();
			Toast.makeText(this, "Все елементы удалены", Toast.LENGTH_SHORT).show();
			break;
		}
		
	}
}
