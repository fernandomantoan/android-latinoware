package com.fernandomantoan.latinoware.repository.support;

import java.util.List;

import com.fernandomantoan.latinoware.model.support.Entity;

public interface CrudRepository<T extends Entity> {
	
	public void insert(T entity);
	
	public void update(T entity);
	
	public void delete(T entity);
	
	public void insertAll(List<? extends Entity> entities);
	
	public void updateAll(List<? extends Entity> entities);
	
	public void deleteAll(List<? extends Entity> entities);
}
