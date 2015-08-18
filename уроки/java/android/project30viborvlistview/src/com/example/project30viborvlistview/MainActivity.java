package com.example.project30viborvlistview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener {

  final String LOG_TAG = "myLogs";

  ListView lvMain;
  String[] names;

  /** Called when the activity is first created. */
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    lvMain = (ListView) findViewById(R.id.lvMain);
    // ������������� ����� ������ ������� ������ 
    lvMain.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    // ������� �������, ��������� ������ �� ����� ��������
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
        this, R.array.names,
        android.R.layout.simple_list_item_multiple_choice);

    Button btnChecked = (Button) findViewById(R.id.btnChecked);
    btnChecked.setOnClickListener(this);
    
    lvMain.setAdapter(adapter);
    // �������� ������ �� ����� ��������
    names = getResources().getStringArray(R.array.names);
  }

  public void onClick(View arg0) {
	    // ����� � ��� ���������� ��������
	    Log.d(LOG_TAG, "checked: ");
	    SparseBooleanArray sbArray = lvMain.getCheckedItemPositions();
	    for (int i = 0; i < sbArray.size(); i++) {
	      int key = sbArray.keyAt(i);
	      if (sbArray.get(key))
	        Log.d(LOG_TAG, names[key]);
	    }
	  }
}