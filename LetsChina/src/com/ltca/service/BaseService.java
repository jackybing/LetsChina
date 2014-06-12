package com.ltca.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, PK extends Serializable> {
	
	public T get(PK id);

	
	public T load(PK id);

	
	public List<T> getAllList();
	
	
	public Long getTotalCount();

	
	public PK save(T entity);

	
	public void update(T entity);
	
	
	public void delete(T entity);

	
	public void delete(PK id);

	public void delete(PK[] ids);
}
	