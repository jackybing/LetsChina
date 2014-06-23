package com.ltca.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="path")
public class Path extends BaseModal {

	private static final long serialVersionUID = -1477624076153707616L;
	
	private int price;//线路单价

	@Column(name="price")
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
