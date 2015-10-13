package com.fernandomantoan.latinoware.fragment;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.fernandomantoan.latinoware.LatinowareApp;
import com.fernandomantoan.latinoware.R;
import com.fernandomantoan.latinoware.adapter.CourseExpandableAdapter;

public class CoursesFragment extends Fragment {

	private LatinowareApp app;
	private ExpandableListView list;
	private Activity activity;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.activity = getActivity();
		this.app = (LatinowareApp) activity.getApplication();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.tab_fragment, container, false);
		
		list = (ExpandableListView) view.findViewById(android.R.id.list);
		
		list.setAdapter(new CourseExpandableAdapter(
				activity, app.getDaysOfEvent(), app.getCourses()));

        // http://stackoverflow.com/questions/30612453/scrollingviewbehavior-for-listview
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            list.setNestedScrollingEnabled(true);
        }

		return view;
	}
}