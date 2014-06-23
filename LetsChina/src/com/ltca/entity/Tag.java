package com.ltca.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="tag")
public class Tag {
	private Integer id;
	private String type;
	
	private BaseModal baseModal;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",unique= true,nullable= false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="type",unique= false, nullable= true,length=20)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@ManyToOne
	public BaseModal getBaseModal() {
		return baseModal;
	}
	public void setBaseModal(BaseModal baseModal) {
		this.baseModal = baseModal;
	}
	
}
