package com.javabrains.action;

import com.javabrains.model.User;
import com.javabrains.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//we can use interface Action or class ActionSupport
//If an Action implements the “ModelDriven” interface, it gains the extra ability to transfer the form data into the object automatically
public class LoginAction extends ActionSupport implements ModelDriven<User>{

//	private String userId;
//	private String password;
	private User user = new User();
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void validate() {
		
		/*
		 * Before execute, Validate is called
		 * if there are any field errors, it will be redirected to "input" Result --- check login.xml
		 */
		if(user.getUserId().isEmpty()) {
			addFieldError("userId", "Used ID cannnot be black");
		}
		if(user.getPassword().isEmpty()) {
			addFieldError("password","Password cannot be blank");
		}
	}
	
	public String execute() {
		LoginService loginService = new LoginService();
		
		if(loginService.verifyLogin(user)) {
			return LOGIN;
		}else {
			return ERROR;
		}
//		if(getUserId().equals("vamsi") && getPassword().equals("1234")) {
//			return LOGIN;
//		}else {
//			return ERROR;
//		}
	}
	/*public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	*/

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
