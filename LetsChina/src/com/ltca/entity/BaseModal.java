package com.ltca.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.Type;

@Entity(name="baseModal")
@Inheritance(strategy=InheritanceType.JOINED)
public class BaseModal implements Serializable {
	
	private static final long serialVersionUID = 5346822151487194693L;

	private Integer id;
	private String title;
	private String content;//正文
	
	private Date date;
	
	private List<Graphic> graphics;
	
	private List<Tag> tags;//标签项
	
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
	
	@OneToMany(mappedBy="baseModal")
	@OrderBy("isMain")
	public List<Graphic> getGraphics() {
		return graphics;
	}
	public void setGraphics(List<Graphic> graphics) {
		this.graphics = graphics;
	}
	
	@Column(name="date")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}	
	
	@OneToMany(mappedBy="baseModal")
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
}
