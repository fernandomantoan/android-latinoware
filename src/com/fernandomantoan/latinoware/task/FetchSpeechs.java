package com.fernandomantoan.latinoware.task;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;

import com.fernandomantoan.latinoware.MainActivity;
import com.fernandomantoan.latinoware.converter.SpeechConverter;
import com.fernandomantoan.latinoware.model.Speech;
import com.fernandomantoan.latinoware.support.WebClient;

public class FetchSpeechs extends AsyncTask<String, Object, List<Speech>> {
	
	private final Activity activity;
	private final String endpoint = "";
	
	public FetchSpeechs(Activity activity) {
		this.activity = activity;
	}
	
	@Override
	protected List<Speech> doInBackground(String... params) {
		try {
			String jsonSpeechs = new WebClient(endpoint).get();
			List<Speech> speechs = new SpeechConverter().listFromJSON(jsonSpeechs);
			return speechs;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void onPostExecute(List<Speech> results) {
		super.onPostExecute(results);
		if (results != null && results.size() > 0) {
			MainActivity.speechData = new Speech[results.size()];
			results.toArray(MainActivity.speechData);
		}
		this.activity.startActivity(new Intent(this.activity, MainActivity.class));
		this.activity.finish();
	}
}
