package com.example.project24translator;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener{
	
	EditText etText;
	Button btnSave,btnLoad;
	
	final String SAVED_TEXT="saved_text";
	
	SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        etText = (EditText) findViewById(R.id.etText);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnSave.setOnClickListener(this);
        btnLoad.setOnClickListener(this);
        
        loadText();
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
		case R.id.btnSave:
			saveText();
			break;
		case R.id.btnLoad:
			loadText();
			break;
		default:
			break;
		}
		
	}


	private void loadText() {
		sPref = getPreferences(MODE_PRIVATE);
		String savedText = sPref.getString(SAVED_TEXT, "");
		etText.setText(savedText);
		Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
	}


	private void saveText() {
		sPref = getPreferences(MODE_PRIVATE);
		Editor ed = sPref.edit();
		ed.putString(SAVED_TEXT, etText.getText().toString());
		ed.commit();
		Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
	}
	
	protected void onDestroy(){
		saveText();
		super.onDestroy();
	}
}
