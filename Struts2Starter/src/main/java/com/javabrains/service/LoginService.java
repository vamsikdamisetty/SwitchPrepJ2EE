package com.javabrains.service;

import com.javabrains.model.User;

public class LoginService {

	public boolean verifyLogin(User user) {
		if(user.getUserId().equals("vamsi") && user.getPassword().equals("1234")) {
			return true;
		}
		return false;
	}
}
