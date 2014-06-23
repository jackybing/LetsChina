package com.ltca.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity(name="answer")
public class Answer extends BaseModal {
	
	private static final long serialVersionUID = 7589031552777732449L;	
	
	private Question question;
	private User answerer;//答题人

	@ManyToOne
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@ManyToOne
	public User getAnswerer() {
		return answerer;
	}

	public void setAnswerer(User answerer) {
		this.answerer = answerer;
	}	
	 
}
