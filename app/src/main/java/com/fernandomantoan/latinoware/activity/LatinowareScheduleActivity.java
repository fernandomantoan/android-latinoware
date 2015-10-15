package com.fernandomantoan.latinoware.activity;

import java.util.List;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import com.fernandomantoan.latinoware.LatinowareApp;
import com.fernandomantoan.latinoware.R;
import com.fernandomantoan.latinoware.adapter.FixedTabsPagerAdapter;
import com.fernandomantoan.latinoware.model.Course;
import com.fernandomantoan.latinoware.model.Speech;
import com.fernandomantoan.latinoware.repository.CourseRepository;
import com.fernandomantoan.latinoware.repository.SpeechRepository;
import com.fernandomantoan.latinoware.support.DatabaseHelper;
import com.fernandomantoan.latinoware.task.FetchSpeechs;

public class LatinowareScheduleActivity extends AppCompatActivity implements Runnable {
	
	private static final String PREFERENCES = "LatinowarePrefs";
	
	private SharedPreferences sharedPreferences;

	private LatinowareApp app;

	private int selectedTab = 0;
	
	boolean dataLoadedFromServer = false;

	private Handler handler;

    private ViewPager mViewPager;

    private FixedTabsPagerAdapter mPagerAdapter;

    private TabLayout mTabLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initParams(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
		
		if (dataLoadedFromServer) {
			if (app.speechsIsEmpty()) {
				loadingDataFromDatabase();
			}
			createTabs(selectedTab);
		} else {
			new FetchSpeechs(this).execute();
		}
	}

	private void initParams(Bundle savedState) {
		handler = new Handler();
		app = (LatinowareApp) getApplication();
		sharedPreferences = getSharedPreferences(PREFERENCES, MODE_PRIVATE);
		dataLoadedFromServer = sharedPreferences.getBoolean("success", false);
		if(savedState != null) {
			selectedTab = savedState.getInt("selectedTab");
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		int index = mViewPager.getCurrentItem();
		outState.putInt("selectedTab", index);
	}

	private void createTabs(int selectedTab) {
        mPagerAdapter = new FixedTabsPagerAdapter(getSupportFragmentManager(), LatinowareScheduleActivity.this);
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
	}

	public Handler getHandler() {
		return handler;
	}
	
	public boolean isDataLoaded() {
		return dataLoadedFromServer;
	}
	
	public void setDataLoadedFromServer(boolean dataLoadedFromServer) {
		this.dataLoadedFromServer = dataLoadedFromServer;
		Editor edit = getSharedPreferences().edit();
		edit.putBoolean("success", dataLoadedFromServer);
		edit.commit();
	}
	
	public SharedPreferences getSharedPreferences() {
		return sharedPreferences;
	}
	
	private void loadingDataFromDatabase() {
		DatabaseHelper databaseHelper = new DatabaseHelper(this);
		
		SpeechRepository speechRepository = new SpeechRepository(databaseHelper);
		List<Speech> speechs = speechRepository.getAll();
		speechRepository.close();
		app.setSpeechs(speechs);
		
		CourseRepository courseRepository = new CourseRepository(databaseHelper);
		List<Course> courses = courseRepository.getAll();
		courseRepository.close();
		app.setCourses(courses);
	}

	@Override
	public void run() {
		if(dataLoadedFromServer) {
			Toast.makeText(this, "Os dados foram carregados com sucesso.", 
					Toast.LENGTH_LONG).show();
		}
		loadingDataFromDatabase();
		createTabs(selectedTab);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.latinoware, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.menu_about) {
			Intent intent = new Intent(this, AboutActivity.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}

	public void invalidateViewPager() {
        mPagerAdapter.setSelected(mViewPager.getCurrentItem());
        mViewPager.getAdapter().notifyDataSetChanged();
	}
}