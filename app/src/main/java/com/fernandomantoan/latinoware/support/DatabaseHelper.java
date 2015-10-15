package com.fernandomantoan.latinoware.support;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final int DB_VERSION = 1;
	private static final String DATABASE_NAME = "Latinoware";
	
	public static final String ID_CONDITION = "id = ?";
	
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DB_VERSION);
	}
	
	/**
	 * CREATE TABLE Speech (
		  id INTEGER PRIMARY KEY,
		  title TEXT,
		  space TEXT,
		  speaker TEXT,
		  timestamp INTEGER,
		  watch INTEGER);
		  
		CREATE TABLE Course (
		  id INTEGER PRIMARY KEY,
		  title TEXT,
		  lab TEXT,
		  teachers TEXT,
		  start INTEGER,
		  end INTEGER);
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		String ddl = new StringBuffer()
			.append("CREATE TABLE Speech ( ")
			.append("id INTEGER PRIMARY KEY, ")
			.append("title TEXT, ")
			.append("space TEXT, ")
			.append("speaker TEXT, ")
			.append("timestamp INTEGER, ")
			.append("watch INTEGER ")
			.append(");")
			.toString();
		db.execSQL(ddl);
		
		String ddl2 = new StringBuffer()
		.append("CREATE TABLE Course ( ")
		.append("id INTEGER PRIMARY KEY, ")
		.append("title TEXT, ")
		.append("lab TEXT, ")
		.append("teachers TEXT, ")
		.append("start INTEGER, ")
		.append("end INTEGER ")
		.append(");")
		.toString();
		db.execSQL(ddl2);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Nothing to do here
	}
}