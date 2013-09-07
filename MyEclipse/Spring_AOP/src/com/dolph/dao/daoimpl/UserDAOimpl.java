package com.dolph.dao.daoimpl;

import org.springframework.stereotype.Component;

import com.dolph.dao.UserDAO;
import com.dolph.domain.User;


@Component("userDAO")
public class UserDAOimpl implements UserDAO {

	private String test;

	@Override
	public void update(User user) {
		System.out.println("User insert...." + user.getUsername() + ":" + test);
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

}
