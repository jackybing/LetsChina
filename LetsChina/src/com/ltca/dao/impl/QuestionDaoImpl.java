package com.ltca.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ltca.dao.QuestionDao;
import com.ltca.dao.TagDao;
import com.ltca.entity.Question;
import com.ltca.entity.Tag;

@Repository("questionDaoImpl")
public class QuestionDaoImpl extends BaseDaoImpl<Question, Integer> implements QuestionDao {
	
	@Resource(name="tagDaoImpl")
	private TagDao tagDao;
	public void updateTag(Integer questionID,List<Tag> tags){
		Question question=get(questionID);
		question.getTags();
		for (Tag tag : tags) {
			tag.setBaseModal(question);
			question.getTags().add(tag);
			tagDao.save(tag);
		}
		update(question);		
	}
}
