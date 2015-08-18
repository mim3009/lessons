package com.example.project28layinflaterspiski;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	String[] name = { "����", "�����", "����", "�����", "����", "�����",
			"�����", "�����" };
	String[] position = { "����������", "���������", "����������",
			"����������", "���������", "��������", "����������", "��������" };
	int salary[] = { 13000, 10000, 13000, 13000, 10000, 15000, 13000, 8000 };

	int[] colors = new int[2];

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		colors[0] = Color.parseColor("#559966CC");
		colors[1] = Color.parseColor("#55336699");

		LinearLayout linLayout = (LinearLayout) findViewById(R.id.linLayout);

		LayoutInflater ltInflater = getLayoutInflater();

		for (int i = 0; i < name.length; i++) {
			Log.d("myLogs", "i = " + i);
			View item = ltInflater.inflate(R.layout.item, linLayout, false);
			TextView tvName = (TextView) item.findViewById(R.id.tvName);
			tvName.setText(name[i]);
			TextView tvPosition = (TextView) item.findViewById(R.id.tvPosition);
			tvPosition.setText("���������: " + position[i]);
			TextView tvSalary = (TextView) item.findViewById(R.id.tvSalary);
			tvSalary.setText("�����: " + String.valueOf(salary[i]));
			item.getLayoutParams().width = LayoutParams.MATCH_PARENT;
			item.setBackgroundColor(colors[i % 2]);
			linLayout.addView(item);
		}
	}
}