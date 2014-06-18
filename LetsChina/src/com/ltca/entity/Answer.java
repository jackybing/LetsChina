package com.ltca.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

public class Answer implements Serializable {
	
	private static final long serialVersionUID = 7589031552777732449L;
	
	private Integer id;
	
	private String advice;//回复

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",unique= true,nullable= false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Type(type="text")
	@Column(name="advice",unique= false, nullable= true,length=50)
	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}
		
}
