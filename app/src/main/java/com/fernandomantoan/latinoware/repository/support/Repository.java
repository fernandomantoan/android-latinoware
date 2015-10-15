package com.fernandomantoan.latinoware.repository.support;

import java.util.List;

import com.fernandomantoan.latinoware.model.support.Entity;
import com.fernandomantoan.latinoware.support.DatabaseHelper;

public class Repository implements CrudRepository<Entity> {

	protected DatabaseHelper database;
	
	public Repository(DatabaseHelper database) {
		this.database = database;
	}
	
	@Override
	public void insert(Entity entity) {
		database.getWritableDatabase().insert(entity.getTableName(), 
				null, entity.toContentValues());
	}

	@Override
	public void update(Entity entity) {
		database.getWritableDatabase().update(entity.getTableName(),
				entity.toContentValues(), DatabaseHelper.ID_CONDITION, 
				new String[]{String.valueOf(entity.getId())});
	}

	@Override
	public void delete(Entity entity) {
		database.getWritableDatabase().delete(entity.getTableName(), 
				DatabaseHelper.ID_CONDITION,
				new String[]{String.valueOf(entity.getId())});
	}
	
	@Override
	public void insertAll(List<? extends Entity> entities) {
		for(Entity entity : entities) {
			insert(entity);
		}
	}
	
	@Override
	public void updateAll(List<? extends Entity> entities) {
		for(Entity entity : entities) {
			update(entity);
		}
	}
	
	@Override
	public void deleteAll(List<? extends Entity> entities) {
		for(Entity entity : entities) {
			delete(entity);
		}
	}
	
	public synchronized void close() {
		database.close();
	}

}
