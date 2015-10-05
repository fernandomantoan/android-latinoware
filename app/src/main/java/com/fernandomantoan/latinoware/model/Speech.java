package com.fernandomantoan.latinoware.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import android.content.ContentValues;
import android.text.format.DateFormat;
import android.util.Log;

import com.fernandomantoan.latinoware.model.support.Entity;

public class Speech implements Entity {
	
	public static final String LIST_KEY = "speechsList";
	
	private long id;
	private String title;
	private String space;
	private String speaker;
	private Calendar datetime;
	private boolean watch;
	
	/**
	 * Construtor utilizado para montar o objeto após trazer do servidor
	 */
	public Speech(String title, String space, String datetime) {
		this.title = title;
		this.space = space;
		setDateTime(datetime);
	}
	
	/**
	 * Construtor utilizado para montar o objeto após trazer do banco de dados
	 */
	public Speech(Long id, String title, String space, String speaker, long timestamp, int watch) {
		this.id = id;
		this.title = title;
		this.space = space;
		this.speaker = speaker;
		setWatch(watch);
		setDateTime(timestamp);
	}
	
	@Override
	public long getId() {
		return id;
	}
	
	@Override
	public ContentValues toContentValues() {
		ContentValues contentValues = new ContentValues();
		contentValues.put("title", title);
		contentValues.put("space", space);
		contentValues.put("speaker", speaker);
		contentValues.put("timestamp", datetime.getTimeInMillis());
		contentValues.put("watch", watch);
		return contentValues;
	}
	
	@Override
	public String getTableName() {
		return getClass().getSimpleName();
	}

	public boolean occursInDate(Calendar date) {
		String pattern = "yyyy-MM-dd";
		return DateFormat.format(pattern, datetime).equals(
				DateFormat.format(pattern, date));
	}
	
	public boolean occursInDateTime(Calendar datetime) {
		return this.datetime.compareTo(datetime) == 0;
	}
	
	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}
	
	// TODO refatorar
	public void setSpeaker(List<String> speakers) {
		this.speaker = "";
		for (String speaker : speakers) {
			this.speaker = this.speaker.concat(speaker)
						.concat(",");
		}
		if (this.speaker.length() > 0) {
			this.speaker = this.speaker.substring(0, this.speaker.length() - 1);
		}
	}
	
	public String getTime() {
		return (String) DateFormat.format("kk'h'", datetime);
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getSpeaker() {
		return speaker;
	}

	public String getSpace() {
		return space;
	}
	
	public Calendar getDateTime() {
		return datetime;
	}
	
	public String getType() {
		if (this.title.contains("ABERTURA")) {
			return "OPENING";
		} else {
			return "SPEECH";
		}
	}
	
	public boolean isWatch() {
		return watch;
	}
	
	public void setWatch(boolean watch) {
		this.watch = watch;
	}
	
	private void setWatch(int value) {
		this.watch = value == 1 ? true : false;
	}
	
	private void setDateTime(long timeInMillis) {
		this.datetime = Calendar.getInstance();
		this.datetime.setTimeInMillis(timeInMillis);
	}
	
	private void setDateTime(String datetime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			format.parse(datetime);
		} catch (ParseException e) {
			Log.e("APPLICATION", "Erro ao parsear data e hora: " + datetime, e);
		}
		this.datetime = format.getCalendar();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Speech) {
			Speech speech = (Speech) o;
			return (id == speech.id);
		}
		return super.equals(o);
	}
	
	@Override
	public int hashCode() {
		int hash = title.hashCode();
		if(hash < 0) hash *= -1;
		return hash;
	}

}