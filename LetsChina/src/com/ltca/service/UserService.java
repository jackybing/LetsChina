package com.ltca.service;

import com.ltca.bean.Avatar;
import com.ltca.entity.User;

public interface UserService extends BaseService<User, Integer> {
	public void updateAvatar(Integer userID,Avatar avatar);
	public User checkUser(User user);
}
