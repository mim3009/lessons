package com.example.project40navigation;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;


@SuppressLint("NewApi") @SuppressWarnings("deprecation")
public class MainActivity extends  Activity implements ActionBar.TabListener {

	final String LOG_TAG = "myLogs";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ActionBar bar = getActionBar();

        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        Tab tab = bar.newTab();
        tab.setText("tab1");
        tab.setTabListener(this);
        bar.addTab(tab);

        tab = bar.newTab();
        tab.setText("tab2");
        tab.setTabListener(this);
        bar.addTab(tab);

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
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
      Log.d(LOG_TAG, "reselected tab: " + tab.getText());
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
      Log.d(LOG_TAG, "selected tab: " + tab.getText());
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
      Log.d(LOG_TAG, "unselected tab: " + tab.getText());
    }
}
