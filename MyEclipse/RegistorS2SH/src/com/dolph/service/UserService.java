package com.dolph.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dolph.DAO.UserDAO;
import com.dolph.model.User;

@Component("userService")
public class UserService {

	private UserDAO userDAO;

	@Resource(name="userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Transactional
	public String add(User user) {
		if (userDAO.idExistByName(user.getUsername())) {
			return "fail";
		} else {
			userDAO.save(user);
			return "success";
		}

	}
	@Transactional
	public List<User> list(){
		return userDAO.listUser();
	}
	
	

}
