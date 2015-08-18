package com.example.project21activityresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AlignActivity extends Activity implements OnClickListener {

	Button btnLeft;
	Button btnRight;
	Button btnCenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.align);

		btnLeft = (Button) findViewById(R.id.btnLeft);
		btnRight = (Button) findViewById(R.id.btnRight);
		btnCenter = (Button) findViewById(R.id.btnCenter);

		btnLeft.setOnClickListener(this);
		btnRight.setOnClickListener(this);
		btnCenter.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		switch(v.getId()){
		case R.id.btnLeft:
			intent.putExtra("aligment", Gravity.LEFT);
			break;
		case R.id.btnRight:
			intent.putExtra("aligment", Gravity.RIGHT);
			break;
		case R.id.btnCenter:
			intent.putExtra("aligment", Gravity.CENTER);
			break;
		}
		setResult(RESULT_OK, intent);
		finish();
	}
}
