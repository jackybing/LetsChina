package com.ltca.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="user")
public class User implements Serializable {
	
	private static final long serialVersionUID = -3502009890893881218L;
	
	private Integer id;
	private String userName;
	private String password;
	private String email;
	private String avatarUrl;//头像网络地址
	private String avatarDisk;//头像本地地址
	
	private int score;//用户积分
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",unique= true,nullable= false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="username",unique= false, nullable= true,length=100)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name="password",unique= false, nullable= true,length=100)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="email",unique= false, nullable= true,length=100)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="avatarUrl",unique= false, nullable= true,length=100)
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	
	@Column(name="avatarDisk",unique= false, nullable= true,length=100)
	public String getAvatarDisk() {
		return avatarDisk;
	}
	public void setAvatarDisk(String avatarDisk) {
		this.avatarDisk = avatarDisk;
	}
	
	@Column(name="score",unique= false, nullable= true)
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
		
}
