package com.dolph.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dolph.DAO.UserDAO;
import com.dolph.model.User;

public class UserService {
	private UserDAO userDAO;
	
	
	public void addUser(User user){
		BeanFactory bf=new ClassPathXmlApplicationContext("beans.xml");
		userDAO=(UserDAO) bf.getBean("userDAO");
		userDAO.saveUser(user);
	}
	
	
	
}
