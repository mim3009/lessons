package com.example.project9dynamiclayout;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        // создание LinearLayout
	        LinearLayout linLayout = new LinearLayout(this);
	        // установим вертикальную ориентацию
	        linLayout.setOrientation(LinearLayout.VERTICAL);
	        // создаем LayoutParams  
	        LayoutParams linLayoutParam = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT); 
	        // устанавливаем linLayout как корневой элемент экрана 
	        setContentView(linLayout, linLayoutParam);
	        
	        LayoutParams lpView = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	        
	        TextView tv = new TextView(this);
	        tv.setText("TextView");
	        tv.setLayoutParams(lpView);
	        linLayout.addView(tv);
	        
	        Button btn = new Button(this);
	        btn.setText("Button");
	        linLayout.addView(btn, lpView);
	        
	        LinearLayout.LayoutParams leftMarginParams = new LinearLayout.LayoutParams(
	                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	        leftMarginParams.leftMargin = 50;
	        
	        Button btn1 = new Button(this);
	        btn1.setText("Button1");
	        linLayout.addView(btn1, leftMarginParams);
	        
	        LinearLayout.LayoutParams rightGravityParams = new LinearLayout.LayoutParams(
	                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	        rightGravityParams.gravity = Gravity.RIGHT;
	        
	        Button btn2 = new Button(this);
	        btn2.setText("Button2");
	        linLayout.addView(btn2, rightGravityParams);
	        
	        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
	        lp.weight = 1;
	        
	        Button b = new Button(this);
	        b.setText("bbbb");
	        linLayout.addView(b,lp);
	        
	        EditText et = new EditText(this);
	        et.setText("dd");
	        linLayout.addView(et,lp);
	    }


   
}
