package com.fernandomantoan.latinoware.converter;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fernandomantoan.latinoware.model.Course;

public class CourseConverter {
	
	public static List<Course> listFromJSON(String json) throws JSONException {
		ArrayList<Course> courses = new ArrayList<Course>();
		
		JSONObject objectJson = new JSONObject(json);
		JSONArray array = objectJson.getJSONArray("courses");
		
		for (int i = 0; i < array.length(); i++) {
			JSONObject object = array.getJSONObject(i);
			
			JSONArray dateTimesJson = object.optJSONArray("dateTimes");
			JSONArray teachersJson = object.optJSONArray("teachers");
			
			String teachers = "";
			// TODO: Refatorar
			for (int j = 0; j < teachersJson.length(); j++) {
				JSONObject teacher = teachersJson.getJSONObject(j);
				teachers = teachers.concat(teacher.getString("name"))
						.concat(",");
			}
			
			if (teachers.length() > 0) {
				teachers = teachers.substring(0, teachers.length() - 1);
			}
			
			String startDate = dateTimesJson.getString(0);
			String endDate = dateTimesJson.getString(dateTimesJson.length() - 1);
			
			Course course = new Course(
					object.getString("title"),
					teachers, startDate, endDate,
					object.getString("lab"));
			
			courses.add(course);
		}
		return courses;
	}
}