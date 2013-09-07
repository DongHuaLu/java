package com.dolph.web.action;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dolph.model.User;
import com.dolph.service.UserService;
import com.dolph.vo.LoginInfoVO;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction {

	private String username;
	private String password;
	
	@Resource
	private UserService userService;
	
	public String execute(){
		User user = userService.login(username,password);
		LoginInfoVO vo=new LoginInfoVO();
		vo.setId(user.getId());
		vo.setUsername(user.getUsername());
		vo.setPersonName(user.getPerson().getName());
		vo.setIp(ServletActionContext.getRequest().getRemoteAddr());
		vo.setLoginTime(new Date());
		ServletActionContext.getRequest().getSession().setAttribute("login",vo);
		return "back_index";
	}
	
	public String quit(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "login";
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
	
}
