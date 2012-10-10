package com.fernandomantoan.latinoware.task;

import java.util.List;

import org.json.JSONException;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import android.util.Log;

import com.fernandomantoan.latinoware.Latinoware;
import com.fernandomantoan.latinoware.R;
import com.fernandomantoan.latinoware.converter.CourseConverter;
import com.fernandomantoan.latinoware.converter.SpeechConverter;
import com.fernandomantoan.latinoware.model.Course;
import com.fernandomantoan.latinoware.model.Speech;
import com.fernandomantoan.latinoware.repository.support.Repository;
import com.fernandomantoan.latinoware.support.DatabaseHelper;
import com.fernandomantoan.latinoware.support.WebClient;

public class FetchSpeechs extends AsyncTask<String, Object, String> {
	
	private final static String ENDPOINT = "";
	
	private final Latinoware activity;
	
	private List<Speech> speechs;
	private List<Course> courses;
	
	private ProgressDialog progressDialog;

	public FetchSpeechs(Latinoware activity) {
		this.activity = activity;
	}
	
	@Override
	protected String doInBackground(String... params) {
		
		try {
			String result = getDataFromServer();
			convertDataToJson(result);
			saveDataInDatabase();
		} catch(Exception e) {
			return e.getMessage();
		}
		
		activity.setDataLoadedFromServer(true);
			
		return null;
	}
	
	protected void saveDataInDatabase() {
		Repository repository = new Repository(new DatabaseHelper(activity));
		repository.insertAll(speechs);
		repository.insertAll(courses);
		repository.close();
	}
	
	protected String getDataFromServer() {
		String result = null;
		try {
			result = new WebClient(ENDPOINT).get();
		} catch (Exception e) {
			String message = "Não foi possível conectar ao servidor.";
			Log.e("APP004", message, e);
			throw new RuntimeException(message, e);
		}
		return result;
	}
	
	protected void convertDataToJson(String data) {
		try {
			speechs = SpeechConverter.listFromJSON(data);
			courses = CourseConverter.listFromJSON(data);
		} catch (JSONException e) {
			String message = "Falha na conversão dos dados.";
			Log.e("APP003", message, e);
			throw new RuntimeException(message, e);
		}
	}
	
	@Override
	protected void onPreExecute() {
		
		progressDialog = new ProgressDialog(activity);
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progressDialog.setIcon(android.R.drawable.ic_dialog_info);
		progressDialog.setTitle("Carregando...");
		progressDialog.setMessage("Obtendo palestras, aguarde...");
		progressDialog.setCancelable(false);
		progressDialog.setIndeterminate(true);
		progressDialog.show();
		
	}
	
	@Override
	protected void onPostExecute(String message) {
		progressDialog.dismiss();
		if(message != null) {
			new AlertDialog.Builder(activity)
				.setTitle("Falha")
				.setMessage(message)
				.setIcon(android.R.drawable.ic_dialog_alert)
				.setNeutralButton(R.string.close_btn, onClickListener)
				.show();
		}
		
		activity.getHandler().post(activity);
	}
	
	private OnClickListener onClickListener = new OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			dialog.cancel();
		}
	};
}
