package com.fernandomantoan.latinoware;

import android.app.Activity;
import android.os.Bundle;

import com.fernandomantoan.latinoware.task.FetchSpeechs;

public class SplashActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		
		try {
    		FetchSpeechs fetchSpeechsTask = new FetchSpeechs(this);
    	    fetchSpeechsTask.execute();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	}
}