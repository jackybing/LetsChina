package com.ltca.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltca.bean.Avatar;
import com.ltca.bean.Password;
import com.ltca.entity.User;
import com.ltca.service.UserService;
import com.ltca.util.DEncryptionUtils;

@Controller
@RequestMapping("/user")
public class UserAction {
	
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	private JSONObject msg;
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(@RequestBody User user,HttpSession session){
		user.setPassword(DEncryptionUtils.saltMD5Encoder(user.getPassword()));
		
		User loginUser=userService.checkUser(user);
		msg=new JSONObject();
		if(loginUser==null){
			msg.put("status", 404);
		}else {
			session.setAttribute("userID", loginUser.getId());
			msg.put("status", 200);
		}
		
		return msg.toString();
	}
	
	@RequestMapping("/regist")
	@ResponseBody
	public String regist(@RequestBody User user,HttpSession session){
		user.setPassword(DEncryptionUtils.saltMD5Encoder(user.getPassword()));
		
		Integer userID=userService.save(user);
		msg=new JSONObject();
		if(userID>0){
			msg.put("status", 200);
		}else {
			msg.put("status", 404);
		}
		return msg.toString();
	}
	
	@RequestMapping("/updateAvatar")
	@ResponseBody
	public String updateAvatar(@RequestBody Avatar avatar,HttpSession session){
		Integer userID=(Integer) session.getAttribute("userID");
		userService.updateAvatar(userID, avatar);
		msg=new JSONObject();
		msg.put("status", 200);
		return msg.toString();
	}
	
	@RequestMapping("/updatePassword")
	@ResponseBody
	public String updatePassword(@RequestBody Password password,HttpSession session){
		Integer userID=1;
		//User user=userService.get((Integer) session.getAttribute("userID"));
		
		User user=userService.get(userID);

		msg=new JSONObject();
		System.out.println(user.getPassword().equals(DEncryptionUtils.saltMD5Encoder(password.getOldPassword())));
		if(user==null||!user.getPassword().equals(DEncryptionUtils.saltMD5Encoder(password.getOldPassword()))){
			msg.put("status", 404);
		}else {
			user.setPassword(DEncryptionUtils.saltMD5Encoder(password.getNewPassword()));
			userService.update(user);
			msg.put("status", 200);
		}
		
		return msg.toString();
	}
	
	
	
}
