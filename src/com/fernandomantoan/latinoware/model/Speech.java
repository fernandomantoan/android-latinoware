package com.fernandomantoan.latinoware.model;

public class Speech {

	private String title;
	private String speaker;
	private String date;
	private String time;
	private String space;
	
	public Speech(String title, String speaker, String date, String time, String space) {
		this.title = title;
		this.speaker = speaker;
		this.date = date;
		this.time = time;
		this.space = space;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getSpeaker() {
		return speaker;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public String getSpace() {
		return space;
	}
}