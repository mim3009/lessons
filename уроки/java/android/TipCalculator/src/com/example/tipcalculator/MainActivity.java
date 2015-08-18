package com.example.tipcalculator;

import android.R.string;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;


public class MainActivity extends Activity {

	 private static final String BILL_TOTAL = "BILL_TOTAL";
	 private static final String CUSTOM_PERCENT = "CUSTOM_PERCENT"; 
	 
	 private double currentBillTotal;     
	 private int currentCustomPercent;    
	 private EditText tip10EditText;       
	 private EditText total10EditText;     
	 private EditText tip15EditText;      
	 private EditText total15EditText;     
	 private EditText billEditText;       
	 private EditText tip20EditText;     
	 private EditText total20EditText;    
	 private TextView customTipTextView;  
	 private EditText tipCustomEditText;
	 private EditText totalCustomEditText;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
        	currentBillTotal = 0.0;
        	currentCustomPercent = 18;
        }
        else{
        	currentBillTotal = savedInstanceState.getDouble(BILL_TOTAL);
        	currentCustomPercent = savedInstanceState.getInt(CUSTOM_PERCENT);
        }
        tip10EditText = (EditText) findViewById(R.id.tip10EditText);
        total10EditText = (EditText) findViewById(R.id.total10EditText);
        tip15EditText = (EditText) findViewById(R.id.tip15EditText);
        total15EditText = (EditText) findViewById(R.id.total15EditText);
        tip20EditText = (EditText) findViewById(R.id.tip20EditText);
        total20EditText = (EditText) findViewById(R.id.total20EditText);
        
        customTipTextView = (TextView) findViewById(R.id.customTipTextView);
        tipCustomEditText = (EditText) findViewById(R.id.tipCustomEditText);
        totalCustomEditText = (EditText) findViewById(R.id.totalCustomEditText);
       
        billEditText = (EditText) findViewById(R.id.billEditText);
		billEditText.addTextChangedListener(billEditTextWatcher);
        SeekBar customSeekBar = (SeekBar) findViewById(R.id.customSeekBar);
		customSeekBar.setOnSeekBarChangeListener(customSeekBarListener);
    }

    private void updateStandart(){
    	double tenPercentTip = currentBillTotal*.1;
    	double tenPersentTotal = currentBillTotal + tenPercentTip;
    	tip10EditText.setText(String.format(" %.02f", tenPercentTip));
    	total10EditText.setText(String.format(" %.02f", tenPersentTotal));
    	
    	double fifteenPersentTip = currentBillTotal*.15;
    	double fifteenPersentTotal = currentBillTotal + fifteenPersentTip;
    	tip15EditText.setText(String.format(" %.02f", fifteenPersentTip));
    	total15EditText.setText(String.format(" %.02f", fifteenPersentTotal));
    	
    	double twentyPersentTip = currentBillTotal*.20;
    	double twentyPersentTotal = currentBillTotal + twentyPersentTip;
    	tip20EditText.setText(String.format(" %.02f", twentyPersentTip));
    	total20EditText.setText(String.format(" %.02f", twentyPersentTotal));
    }
    
    private void updateCustom(){
    	customTipTextView.setText(currentCustomPercent + " %");
    	double customTipAmount = currentBillTotal * currentCustomPercent *.01;
    	double customTotalAmount = currentBillTotal + customTipAmount;
    	tipCustomEditText.setText(String.format(" %.02f", customTipAmount));
    	totalCustomEditText.setText(String.format(" %.02f", customTotalAmount));
    }
    
    
    
    @Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putDouble(BILL_TOTAL, currentBillTotal);
		outState.putInt(CUSTOM_PERCENT, currentCustomPercent);
	}

    private OnSeekBarChangeListener customSeekBarListener = new OnSeekBarChangeListener() { 			
		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {}
		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {}	
		@Override
		public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
			currentCustomPercent = seekBar.getProgress();
			updateCustom();
		}
	};
	
	private TextWatcher billEditTextWatcher = new TextWatcher() {	
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			try{
				currentBillTotal = Double.parseDouble(s.toString());
			}catch(NumberFormatException e){
				currentBillTotal = 0.0;
			}
			updateStandart();
			updateCustom();
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,	int after) {}
		@Override
		public void afterTextChanged(Editable s) {}
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
