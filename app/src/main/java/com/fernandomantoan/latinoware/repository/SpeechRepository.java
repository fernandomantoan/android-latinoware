package com.fernandomantoan.latinoware.repository;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;

import com.fernandomantoan.latinoware.model.Speech;
import com.fernandomantoan.latinoware.repository.support.QueryRepository;
import com.fernandomantoan.latinoware.repository.support.Repository;
import com.fernandomantoan.latinoware.support.DatabaseHelper;

public class SpeechRepository extends Repository implements QueryRepository<Speech> {
	
	private static final String[] SPEECH_COLS = {
		"id", "title", "space", "speaker", "timestamp", "watch"};
	
	public SpeechRepository(DatabaseHelper database) {
		super(database);
	}
	
	@Override
	public Speech findById(Long id) {
		Cursor cursor = database.getReadableDatabase().query(Speech.class.getSimpleName(),
				SPEECH_COLS, DatabaseHelper.ID_CONDITION, 
				new String[]{id.toString()}, null, null, null);

		Speech speech = null;
		
		if(cursor.moveToFirst()) {
			speech = new Speech(
				cursor.getLong(0),
				cursor.getString(1),
				cursor.getString(2),
				cursor.getString(3),
				cursor.getLong(4),
				cursor.getInt(5)
			);
		}
		
		cursor.close();
		return speech;
	}
	
	@Override
	public List<Speech> getAll() {
		Cursor cursor = database.getReadableDatabase().query(Speech.class.getSimpleName(),
				SPEECH_COLS, null, null, null, null, null);

		List<Speech> speechs = new ArrayList<Speech>();
		while(cursor.moveToNext()) {
			Speech speech = new Speech(
				cursor.getLong(0),
				cursor.getString(1),
				cursor.getString(2),
				cursor.getString(3),
				cursor.getLong(4),
				cursor.getInt(5)
			);
			speechs.add(speech);
		}
		
		cursor.close();
		return speechs;
	}
	
}
