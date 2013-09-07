package com.dolph.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.dolph.model.User;
import com.dolph.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class RegistorAction extends ActionSupport {
	private String username;
	private String password;
	private String password2;
	private UserService userService;
	private List<User> users;
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String registor()  {
		User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		return userService.add(user);
	}
	
	public String list(){
		users=userService.list();
		return "list";
	}

	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

}
