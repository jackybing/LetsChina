package com.ltca.service;

import net.sf.json.JSONArray;

import com.ltca.entity.Question;

public interface QuestionService extends BaseService<Question, Integer> {
	public JSONArray getPagingList(int pagenum,int pagesize,String pagingHql);
}
