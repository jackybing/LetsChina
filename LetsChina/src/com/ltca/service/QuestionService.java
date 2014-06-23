package com.ltca.service;

import net.sf.json.JSONArray;

import com.ltca.entity.Question;

public interface QuestionService extends BaseService<Question, Integer> {
	public JSONArray getListForPaging(int pagenum,int pagesize,String pagingHql);
}
