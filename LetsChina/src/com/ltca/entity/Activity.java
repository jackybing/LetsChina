package com.ltca.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity(name="activity")
public class Activity extends BaseModal {

	private static final long serialVersionUID = -7353153713633033276L;
	
	private Date startDate;
	private Date endDate;
	
	private String address;//

}
