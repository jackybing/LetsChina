package com.ltca.bean;

import java.util.HashMap;


public class SessionStore {
	private static HashMap<String, Integer> userData=new HashMap<String, Integer>();
	
	public void setUserIdInSession(String key,Integer userID){
		userData.put(key, userID);
	}
	
	public Integer getUserIdInSession(String key){
		return userData.get(key);
	}
}
