package com.dolph.DAO.DAOImpl;

import com.dolph.DAO.UserDAO;
import com.dolph.model.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public void saveUser(User user) {
		System.out.println("user saved"+user.getUsername());
		
	}

}
