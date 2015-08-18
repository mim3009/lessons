package com.example.project5;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener {

	  TextView tvOut;
	  Button btnOk;
	  Button btnCancel;
	  
	  private static final String TAG = "myLogs";

	  /** Called when the activity is first created. */
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);

	    // ������ View-��������
	    Log.d(TAG,"������ View-��������");
	    tvOut = (TextView) findViewById(R.id.tvOut);
	    btnOk = (Button) findViewById(R.id.btnOk);
	    btnCancel = (Button) findViewById(R.id.btnCancel);

	    // ����������� ���������� �������
	    Log.d(TAG,"����������� ���������� �������");
	    btnOk.setOnClickListener(this);
	    btnCancel.setOnClickListener(this);
	  }

	  @Override
	  public void onClick(View v) {
	    // �� id ���������� ������, ��������� ���� ����������
		  Log.d(TAG,"�� id ���������� ������, ��������� ���� ����������");
	    switch (v.getId()) {
	    case R.id.btnOk:
	      // ������ ��
	    	Log.d(TAG,"������ ��");
	      tvOut.setText("������ ������ ��");
	      Toast.makeText(this, "������ ������ OK", Toast.LENGTH_SHORT).show();
	      break;
	    case R.id.btnCancel:
	      // ������ Cancel
	    	Log.d(TAG,"������ Cancel");
	      tvOut.setText("������ ������ Cancel");
	      Toast.makeText(this, "������ ������ Cancel", Toast.LENGTH_SHORT).show();
	      break;
	    }
	  }

	}
