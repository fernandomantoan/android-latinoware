package com.fernandomantoan.latinoware.repository.support;

import java.util.List;

public interface QueryRepository<T> {

	public T findById(Long id);
	
	public List<T> getAll();
	
}
