package com.dolph.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dolph.DAO.LogDAO;
import com.dolph.DAO.UserDAO;
import com.dolph.domain.Log;
import com.dolph.domain.User2;
@Component("userService")
public class UserService {
	
	private UserDAO userDAO;
	private LogDAO logDAO;
	
	public LogDAO getLogDAO() {
		return logDAO;
	}
	@Resource(name="logDAO")
	public void setLogDAO(LogDAO logDAO) {
		this.logDAO = logDAO;
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	@Resource(name="userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	//@Transactional
	public void addUser(User2 user){
		userDAO.saveUser(user);
		Log log=new Log();
		log.setMsg("user save"+user.getUsername());
		logDAO.saveLog(log);
		
	}

}
