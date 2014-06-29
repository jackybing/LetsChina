package com.ltca.util;

import java.util.Date;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class DEncryptionUtils {
	private static final String salt="letschina";

	public static String saltMD5Encoder(String rawStr){
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		//带盐值的MD5加密
		return encoder.encodePassword(rawStr, salt);
	}
	
	public static String standPwdEncoder(String rawStr){
		StandardPasswordEncoder encoder = new StandardPasswordEncoder();
		return encoder.encode(rawStr);
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(saltMD5Encoder("zjb"));
		
	}
	
	
}
