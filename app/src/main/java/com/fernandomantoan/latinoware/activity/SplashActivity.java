package com.fernandomantoan.latinoware.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.fernandomantoan.latinoware.R;
import com.fernandomantoan.latinoware.activity.LatinowareScheduleActivity;

public class SplashActivity extends Activity implements Runnable {
	
	private static final int DURATION_MILLIS = 1000;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		new Handler().postDelayed(this, DURATION_MILLIS);
	}
	
	@Override
	public void run() {
		Intent intent = new Intent(this, LatinowareScheduleActivity.class);
		startActivity(intent);
		finish();
	}
	
}