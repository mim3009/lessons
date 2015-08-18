package com.example.project18readaction;

import java.sql.Date;
import java.text.SimpleDateFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Info extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.info);
    
    // �������� Intent, ������� ������� ��� Activity
    Intent intent = getIntent();
    // ������ �� ���� action
    String action = intent.getAction();
    
    String format = "", textInfo = "";
    
    // � ����������� �� action ��������� ����������
    if (action.equals("com.example.intent.action.showtime")) { 
      format = "HH:mm:ss";
      textInfo = "Time: ";
    }
    else if (action.equals("com.example.intent.action.showdate")) { 
      format = "dd.MM.yyyy";
      textInfo = "Date: ";
    }
    
    // � ����������� �� ����������� ���������� format 
    // �������� ���� ��� ����� � ���������� datetime
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    String datetime = sdf.format(new Date(System.currentTimeMillis()));
    
    TextView tvDate = (TextView) findViewById(R.id.tvInfo);
    tvDate.setText(textInfo + datetime);
  }
}