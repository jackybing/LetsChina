package com.ltca.dao.impl;

import org.springframework.stereotype.Repository;

import com.ltca.dao.QuestionDao;
import com.ltca.entity.Question;

@Repository("questionDaoImpl")
public class QuestionDaoImpl extends BaseDaoImpl<Question, Integer> implements QuestionDao {

}
