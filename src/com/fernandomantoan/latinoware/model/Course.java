package com.fernandomantoan.latinoware.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.content.ContentValues;
import android.text.format.DateFormat;
import android.util.Log;

import com.fernandomantoan.latinoware.model.support.Entity;

public class Course implements Entity {
	
	private long id;
	private String title;
	private Calendar start;
	private Calendar end;
	private String teachers;
	private String lab;

	public Course(String title, String teachers, String startDate,
			String endDate, String lab) {
		this.title = title;
		this.teachers = teachers;
		this.start = this.getFromString(startDate);
		this.end = this.getFromString(endDate);
		this.lab =  lab;
	}
	
	public Course(long id, String title, String lab, String teachers,
			long startTimestamp, long endTimestamp) {
		this.id = id;
		this.title = title;
		this.teachers = teachers;
		this.lab = lab;
		this.start = this.getDateTime(startTimestamp);
		this.end = this.getDateTime(endTimestamp);
	}

	@Override
	public long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getTeachers() {
		return teachers;
	}
	
	public String getLab() {
		return lab;
	}
	
	public String getStartTime() {
		return (String) DateFormat.format("kk'h'", start);
	}
	
	public String getEndTime() {
		return (String) DateFormat.format("kk'h'", end);
	}
	
	@Override
	public String getTableName() {
		return getClass().getSimpleName();
	}
	
	protected Calendar getFromString(String dateTime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			format.parse(dateTime);
		} catch (ParseException e) {
			Log.e("APPLICATION", "Erro ao parsear data e hora: " + dateTime, e);
		}
		return format.getCalendar();
	}
	
	public boolean occursInDate(Calendar date) {
		String pattern = "yyyy-MM-dd";
		return DateFormat.format(pattern, start).equals(
				DateFormat.format(pattern, date));
	}
	
	private Calendar getDateTime(long timeInMillis) {
		Calendar datetime = Calendar.getInstance();
		datetime.setTimeInMillis(timeInMillis);
		return datetime;
	}

	@Override
	public ContentValues toContentValues() {
		ContentValues contentValues = new ContentValues();
		contentValues.put("title", title);
		contentValues.put("lab", this.lab);
		contentValues.put("teachers", this.teachers);
		contentValues.put("start", start.getTimeInMillis());
		contentValues.put("end", this.end.getTimeInMillis());
		return contentValues;
	}
	
	@Override
	public int hashCode() {
		int hash = title.hashCode();
		if(hash < 0) hash *= -1;
		return hash;
	}
}