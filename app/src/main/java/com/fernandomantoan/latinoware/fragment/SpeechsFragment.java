package com.fernandomantoan.latinoware.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.fernandomantoan.latinoware.activity.LatinowareScheduleActivity;
import com.fernandomantoan.latinoware.LatinowareApp;
import com.fernandomantoan.latinoware.R;
import com.fernandomantoan.latinoware.adapter.SpeechExpandableAdapter;

public class SpeechsFragment extends Fragment {

	private LatinowareApp mApp;
	private ExpandableListView mList;
	private LatinowareScheduleActivity mActivity;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mActivity = (LatinowareScheduleActivity) getActivity();
		mApp = (LatinowareApp) mActivity.getApplication();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.tab_fragment, container, false);
		
		mList = (ExpandableListView) view.findViewById(android.R.id.list);
		mList.setAdapter(new SpeechExpandableAdapter(
				mActivity, mApp.getDaysOfEvent(), mApp.getSpeechs()));

        // http://stackoverflow.com/questions/30612453/scrollingviewbehavior-for-listview
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			mList.setNestedScrollingEnabled(true);
		}
		
		return view;
	}
	
}
