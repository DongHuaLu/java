package com.dolph.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dolph.model.User;
import com.dolph.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport implements SessionAware {
	private String username;
	private String password;
	private UserService userService;
	private Map<String,Object> session;

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

	public String login() {
		System.out.println(this);
		User user=userService.login(username, password);
		if(user!=null){
			session.put("user",user);
			return "bak_index";
		}
		return "loginerror";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

}
