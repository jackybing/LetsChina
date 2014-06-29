package com.ltca.service.impl;

import java.io.Serializable;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ltca.dao.BaseDao;
import com.ltca.entity.Graphic;
import com.ltca.service.BaseService;
import com.ltca.util.FileUploadUtil;

public class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK>  {

	@Autowired
	private BaseDao<T, PK> baseDao;
	
	@Autowired
	protected FileUploadUtil fileUploadUtil;
	
	protected JSONArray jsonArray;
	protected JSONObject jsonObject;  
	
	protected JSONArray jsonArray2;
	protected JSONObject jsonObject2;
	
	public void delete(T entity) {
		baseDao.delete(entity);
			}

	public void delete(PK id) {
		baseDao.delete(id);
			}

	public void delete(PK[] ids) {
		baseDao.delete(ids);
			}

	public T get(PK id) {
		return baseDao.get(id);
	}

	public List<T> getAllList() {
		return baseDao.getAllList();
	}

	public Long getTotalCount() {
		return baseDao.getTotalCount();
	}

	public T load(PK id) {
		return baseDao.load(id);
	}

	public PK save(T entity) {
		
		return baseDao.save(entity);
	}

	public void update(T entity) {
		baseDao.update(entity);
	}
	
	public List<T> getListForPaging(int pagenum,int pagesize,String pagingHql){
		return baseDao.getListForPaging(pagenum, pagesize, pagingHql);
	}
}
