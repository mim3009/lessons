package com.example.project7menurash;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;


public class MainActivity extends Activity {
	  
	  // �������� ������
	  TextView tv;
	  CheckBox chb;
	  
	  
	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        // ������� ��������
	        tv = (TextView) findViewById(R.id.textView);
	        chb = (CheckBox) findViewById(R.id.chbExtMenu);
	        
	    }
	    
	    // �������� ����
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	      // TODO Auto-generated method stub
	      // ��������� ������ ����
	      //menu.add(0, 1, 0, "add");
//	      menu.add(0, 2, 0, "edit");
//	      menu.add(0, 3, 3, "delete");
//	      menu.add(1, 4, 1, "copy");
//	      menu.add(1, 5, 2, "paste");
//	      menu.add(1, 6, 4, "exit");
	    	getMenuInflater().inflate(R.menu.mymenu, menu);
	      
	      return super.onCreateOptionsMenu(menu);
	    }
	    
	    // ���������� ����
	    @Override
	    public boolean onPrepareOptionsMenu(Menu menu) {
	      // TODO Auto-generated method stub
	      // ������ ���� � ID ������ = 1 �����, ���� � CheckBox ����� �����
	      menu.setGroupVisible(R.id.group1, chb.isChecked());
	      return super.onPrepareOptionsMenu(menu);
	    }

	    // ��������� �������
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	      // TODO Auto-generated method stub
	      StringBuilder sb = new StringBuilder();

	      // ������� � TextView ���������� � ������� ������ ���� 
	      sb.append("Item Menu");
	      sb.append("\r\n groupId: " + String.valueOf(item.getGroupId()));
	      sb.append("\r\n itemId: " + String.valueOf(item.getItemId()));
	      sb.append("\r\n order: " + String.valueOf(item.getOrder()));
	      sb.append("\r\n title: " + item.getTitle());
	      tv.setText(sb.toString());
	      
	      return super.onOptionsItemSelected(item);
	    }
	}
