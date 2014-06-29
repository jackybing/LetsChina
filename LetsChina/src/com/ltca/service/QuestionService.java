package com.ltca.service;

import java.util.List;

import net.sf.json.JSONArray;

import com.ltca.entity.Question;
import com.ltca.entity.Tag;

public interface QuestionService extends BaseService<Question, Integer> {
	public JSONArray getPagingList(int pagenum,int pagesize,String pagingHql);
	
	public void updateTag(Integer questionID,List<Tag> tags);
}
