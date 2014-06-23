package com.ltca.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ltca.dao.AnswerDao;
import com.ltca.entity.Answer;

@Repository("answerDaoImpl")
public class AnswerDaoImpl extends BaseDaoImpl<Answer, Integer> implements AnswerDao {

	
	public List<Answer> getListForPaging(int questionID,int pagenum, int pagesize,
			String pagingHql) {
		// TODO Auto-generated method stub
		return (List<Answer>)this.getSession().createQuery(pagingHql).setInteger(0, questionID).setFirstResult(pagenum*pagesize).setMaxResults(pagesize).list();
	}

}
