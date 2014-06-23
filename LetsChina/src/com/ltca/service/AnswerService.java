package com.ltca.service;

import net.sf.json.JSONArray;

import com.ltca.entity.Answer;

public interface AnswerService extends BaseService<Answer, Integer> {
	public JSONArray getListForPaging(int questionID,int pagenum, int pagesize,
			String pagingHql);
}
