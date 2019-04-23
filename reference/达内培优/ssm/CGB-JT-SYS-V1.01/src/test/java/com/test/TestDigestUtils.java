package com.test;

import org.springframework.util.DigestUtils;

public class TestDigestUtils {

	public static void main(String[] args) {
		String pwd="123456";
		String newPwd=
		DigestUtils.md5DigestAsHex(pwd.getBytes());
		//System.out.println(newPwd);
		for(int i=0;i<1024;i++){
		newPwd=DigestUtils.md5DigestAsHex(newPwd.getBytes());
		newPwd=DigestUtils.md5DigestAsHex(newPwd.getBytes());
		newPwd=DigestUtils.md5DigestAsHex(newPwd.getBytes());
		newPwd=DigestUtils.md5DigestAsHex(newPwd.getBytes());
		}
		System.out.println(newPwd);
	}
}
