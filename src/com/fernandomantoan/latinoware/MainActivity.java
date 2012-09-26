package com.fernandomantoan.latinoware;

import java.util.ArrayList;

import android.os.Bundle;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockListActivity;
import com.fernandomantoan.latinoware.adapter.SpeechAdapter;
import com.fernandomantoan.latinoware.model.Speech;

public class MainActivity extends SherlockListActivity {
	
	private TabListener tabListener = new SpeechsTabListener(this);
	public static Speech[] speechData;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        Tab tab1 = getSupportActionBar().newTab();
        tab1.setText("17/10");
        tab1.setTag("17/10");
        tab1.setTabListener(tabListener);
        getSupportActionBar().addTab(tab1);
        
        Tab tab2 = getSupportActionBar().newTab();
        tab2.setText("18/10");
        tab2.setTag("18/10");
        tab2.setTabListener(tabListener);
        getSupportActionBar().addTab(tab2);
        
        Tab tab3 = getSupportActionBar().newTab();
        tab3.setText("19/10");
        tab3.setTag("19/10");
        tab3.setTabListener(tabListener);
        getSupportActionBar().addTab(tab3);
        
        getSupportActionBar().selectTab(tab1);
    }
    
    public void filterSpeechsList(String date) {
    	String[] dateParts = date.split("/");
    	
    	if (dateParts != null) {
    		date = "2012-".concat(dateParts[1]).concat("-").concat(dateParts[0]);
    	}
    	
    	ArrayList<Speech> filteredSpeechs = new ArrayList<Speech>();
    	
    	if (speechData != null) {
	    	for (int i = 0; i < speechData.length; i++) {
	    		if (speechData[i].getDate().equals(date)) {
	    			filteredSpeechs.add(speechData[i]);
	    		}
	    	}
	    	
	    	Speech[] filteredData = new Speech[filteredSpeechs.size()];
	    	filteredSpeechs.toArray(filteredData);
	    	
	    	setListAdapter(new SpeechAdapter(this, R.layout.speech_list_item, filteredData));
    	} else {
    		Toast.makeText(this, "Ocorreu um erro ao obter as palestras.", Toast.LENGTH_LONG).show();
    	}
    }
}