package com.fernandomantoan.latinoware;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import android.app.Application;

import com.fernandomantoan.latinoware.model.Course;
import com.fernandomantoan.latinoware.model.Speech;

/**
 * Classe responsável por manter o cache da aplicação
 * 
 * @author anderson
 *
 */
public class LatinowareApp extends Application {

	private List<Speech> speechs;
	
	private List<Course> courses;
	
	private Calendar[] daysOfEvent = {
    		new GregorianCalendar(2012, 10-1, 17),
    		new GregorianCalendar(2012, 10-1, 18),
    		new GregorianCalendar(2012, 10-1, 19)
    };
	
	@Override
	public void onCreate() {
		super.onCreate();
	}
	
	public Calendar[] getDaysOfEvent() {
		return daysOfEvent;
	}
	
	public List<Speech> getSpeechs() {
		return speechs;
	}
	
	public void setSpeechs(List<Speech> speechs) {
		this.speechs = speechs;
	}
	
	public List<Course> getCourses() {
		return courses;
	}
	
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public List<Speech> getSpeechsChecked() {
		ArrayList<Speech> list = new ArrayList<Speech>();
		for(Speech speech : speechs) {
			if(speech.isWatch()) {
				list.add(speech);
			}
		}
		return list;
	}
	
	public boolean speechsIsEmpty() {
		return speechs == null || speechs.isEmpty();
	}
	
}
