package com.fernandomantoan.latinoware.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.fernandomantoan.latinoware.activity.LatinowareScheduleActivity;
import com.fernandomantoan.latinoware.LatinowareApp;
import com.fernandomantoan.latinoware.R;
import com.fernandomantoan.latinoware.adapter.SpeechExpandableAdapter;

public class MyGridFragment extends Fragment {

	private LatinowareApp app;
	private ExpandableListView list;
	private LatinowareScheduleActivity mActivity;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.mActivity = (LatinowareScheduleActivity) getActivity();
		this.app = (LatinowareApp) mActivity.getApplication();
	}

	@Override
	public void onPause() {
		super.onPause();
		Log.d("TEST", "onPause");
	}

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TEST", "onResume");
    }

    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.tab_fragment, container, false);

		list = (ExpandableListView) view.findViewById(android.R.id.list);
		list.setAdapter(new SpeechExpandableAdapter(
                mActivity, app.getDaysOfEvent(), app.getSpeechsChecked()));

        // http://stackoverflow.com/questions/30612453/scrollingviewbehavior-for-listview
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            list.setNestedScrollingEnabled(true);
        }

		return view;
	}

}
