package com.ltca.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="question")
public class Question extends BaseModal {

	private static final long serialVersionUID = -3341258912163366447L;
	
	private User asker;
	
	private List<Answer> answers;

	@ManyToOne
	public User getAsker() {
		return asker;
	}

	public void setAsker(User asker) {
		this.asker = asker;
	}

	@OneToMany(mappedBy="question")
	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
		
}
