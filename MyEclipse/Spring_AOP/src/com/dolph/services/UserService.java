package com.dolph.services;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dolph.dao.UserDAO;
import com.dolph.domain.User;

@Component("userService")
public class UserService {

	private UserDAO userDAO;

	public void add(User user) {
		userDAO.update(user);
	}

	

	@Resource(name="userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
