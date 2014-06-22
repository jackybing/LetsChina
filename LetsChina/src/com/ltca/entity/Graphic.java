package com.ltca.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="graphic")
public class Graphic implements Serializable {

	private static final long serialVersionUID = 6911098205402242102L;
	
	private Integer id;
	private String url;//图片网络地址
	private String disk;//图片本地地址
	
	private Boolean isMain;//首要图片，即作为活动或者路线展示的主要图片
	
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
	
	@Column(name="url",unique= false, nullable= true,length=100)
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Column(name="disk",unique= false, nullable= true,length=100)
	public String getDisk() {
		return disk;
	}
	public void setDisk(String disk) {
		this.disk = disk;
	}
	
	@Column(nullable = true,columnDefinition="boolean default 0")
	public Boolean getIsMain() {
		return isMain;
	}
	public void setIsMain(Boolean isMain) {
		this.isMain = isMain;
	}
	
	@ManyToOne
	public BaseModal getBaseModal() {
		return baseModal;
	}
	public void setBaseModal(BaseModal baseModal) {
		this.baseModal = baseModal;
	}
	
}
