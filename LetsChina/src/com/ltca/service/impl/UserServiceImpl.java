package com.ltca.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ltca.bean.Avatar;
import com.ltca.dao.UserDao;
import com.ltca.entity.User;
import com.ltca.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements
		UserService {

	@Resource(name="userDaoImpl")
	private UserDao userDao;
	public void updateAvatar(Integer userID,Avatar avatar){
		User user=get(userID);
		if(!user.getAvatarDisk().equals("")){
			fileUploadUtil.deleteFileOnUpload(user.getAvatarDisk());
		}
		userDao.updateAvatar(userID, avatar);
	}
	
	public User checkUser(User user){
		return userDao.checkUser(user);
	}
}
