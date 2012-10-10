package com.fernandomantoan.latinoware.repository;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;

import com.fernandomantoan.latinoware.model.Course;
import com.fernandomantoan.latinoware.repository.support.QueryRepository;
import com.fernandomantoan.latinoware.repository.support.Repository;
import com.fernandomantoan.latinoware.support.DatabaseHelper;

public class CourseRepository extends Repository implements QueryRepository<Course> {
	
	private static final String[] COURSE_COLS = {
		"id", "title", "lab", "teachers", "start", "end"};
	
	public CourseRepository(DatabaseHelper database) {
		super(database);
	}
	
	@Override
	public Course findById(Long id) {
		Cursor cursor = database.getReadableDatabase().query(Course.class.getSimpleName(),
				COURSE_COLS, null, null, null, null, null);

		Course course = null;
		
		if(cursor.moveToFirst()) {
			course = new Course(
				cursor.getLong(0),
				cursor.getString(1),
				cursor.getString(2),
				cursor.getString(3),
				cursor.getLong(4),
				cursor.getLong(5)
			);
		}
		
		cursor.close();
		return course;
	}
	
	@Override
	public List<Course> getAll() {
		Cursor cursor = database.getReadableDatabase().query(Course.class.getSimpleName(),
				COURSE_COLS, null, null, null, null, null);

		List<Course> courses = new ArrayList<Course>();
		while(cursor.moveToNext()) {
			Course course = new Course(
				cursor.getLong(0),
				cursor.getString(1),
				cursor.getString(2),
				cursor.getString(3),
				cursor.getLong(4),
				cursor.getLong(5)
			);
			courses.add(course);
		}
		
		cursor.close();
		return courses;
	}
	
}