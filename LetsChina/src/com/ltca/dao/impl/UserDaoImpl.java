package com.ltca.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ltca.bean.Avatar;
import com.ltca.dao.UserDao;
import com.ltca.entity.Graphic;
import com.ltca.entity.User;

@Repository("userDaoImpl")
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {

	@Override
	public void updateAvatar(Integer userID,Avatar avatar) {
		User user=get(userID);
		user.setAvatarDisk(avatar.getDisk());
		user.setAvatarUrl(avatar.getUrl());
		update(user);
	}
	
	public User checkUser(User user){
		return (User) getSession().createQuery("from user as u where u.email= :email and u.password= :password").setParameter("email", user.getEmail()).setParameter("password", user.getPassword()).list().get(0);
	}

}
