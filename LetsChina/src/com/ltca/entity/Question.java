package com.ltca.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.text.AbstractDocument.Content;

import org.hibernate.annotations.Type;

public class Question implements Serializable {

	private static final long serialVersionUID = -3341258912163366447L;
	
	private Integer id;
	private String title;
	private String content;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",unique= true,nullable= false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="title",unique= false, nullable= true,length=200)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Type(type="text")
	@Column(name="content",unique= false, nullable= true,length=50)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	

}
