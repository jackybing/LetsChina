package com.ltca.dao;

import java.util.List;

import com.ltca.entity.Question;
import com.ltca.entity.Tag;

public interface QuestionDao extends BaseDao<Question, Integer> {
	public void updateTag(Integer questionID,List<Tag> tags);
}
