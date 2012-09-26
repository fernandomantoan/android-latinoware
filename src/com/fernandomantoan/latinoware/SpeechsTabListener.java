package com.fernandomantoan.latinoware;

import android.support.v4.app.FragmentTransaction;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;

public class SpeechsTabListener implements ActionBar.TabListener {
	
	private MainActivity mActivity;
	
	public SpeechsTabListener(MainActivity activity) {
		this.mActivity = activity;
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		mActivity.filterSpeechsList((String) tab.getTag());
	}
	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}
}