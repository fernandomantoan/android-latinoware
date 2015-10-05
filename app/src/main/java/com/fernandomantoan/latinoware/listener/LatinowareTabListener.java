package com.fernandomantoan.latinoware.listener;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.fernandomantoan.latinoware.R;
import com.fernandomantoan.latinoware.fragment.CoursesFragment;
import com.fernandomantoan.latinoware.fragment.MyGridFragment;
import com.fernandomantoan.latinoware.fragment.SpeechsFragment;

public class LatinowareTabListener implements ActionBar.TabListener {
	
	private final SherlockFragmentActivity activity;
	
	private SherlockFragment fragment;
	
	public static enum Tag {
		SPEECHS, MY_GRID, COURSES;
	}
	
	public LatinowareTabListener(SherlockFragmentActivity activity) {
		this.activity = activity;
	}
	
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		Tag tag = (Tag) tab.getTag();
		
		FragmentManager manager = activity.getSupportFragmentManager();
		fragment = (SherlockFragment) manager.findFragmentByTag(tag.toString());
		
		if(fragment == null) {
			switch(tag) {
			case SPEECHS:
				fragment = new SpeechsFragment();
				break;
			case MY_GRID:
				fragment = new MyGridFragment();
				break;
			case COURSES:
				fragment = new CoursesFragment();
				break;
			}
			ft.add(R.id.main_content, fragment, tag.toString());
		} else {
			ft.attach(fragment);
		}
	}
	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		Log.d("APPLICATION", "Nothing to do here!");
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		if(fragment != null) {
			ft.detach(fragment);
		}
	}
	
}