package com.ltca.service.impl;

import java.util.List;

import net.sf.json.JSONArray;

import com.ltca.entity.Question;
import com.ltca.service.QuestionService;

public class QuestionServiceImpl extends BaseServiceImpl<Question, Integer> implements
		QuestionService {
	@Override
	public JSONArray getListForPaging(int pagenum, int pagesize,
			String pagingHql) {
		// TODO Auto-generated method stub
		return null;
	}

}
