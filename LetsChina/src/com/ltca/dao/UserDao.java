package com.ltca.dao;

import com.ltca.bean.Avatar;
import com.ltca.entity.Graphic;
import com.ltca.entity.User;

public interface UserDao extends BaseDao<User, Integer> {
	public void updateAvatar(Integer userID,Avatar avatar);
	
	public User checkUser(User user);
}
