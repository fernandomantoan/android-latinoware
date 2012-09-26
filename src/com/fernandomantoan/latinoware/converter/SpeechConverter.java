package com.fernandomantoan.latinoware.converter;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fernandomantoan.latinoware.model.Speech;

public class SpeechConverter {
	
	public List<Speech> listFromJSON(String json) throws JSONException {
		ArrayList<Speech> speechs = new ArrayList<Speech>();
		
		JSONObject objectJson = new JSONObject(json);
		JSONArray array = objectJson.getJSONArray("speechs");
		for (int i = 0; i < array.length(); i++) {
			JSONObject object = array.getJSONObject(i);
			Speech speech = new Speech(object.getString("title"), 
					object.getString("speaker"), 
					object.getString("date"),
					object.getString("time"), 
					object.getString("space"));
			speechs.add(speech);
		}
		
		return speechs;
	}
}