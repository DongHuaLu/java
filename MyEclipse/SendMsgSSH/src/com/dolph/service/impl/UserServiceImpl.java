package com.dolph.service.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dolph.DAO.UserDAO;
import com.dolph.model.User;
import com.dolph.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	private UserDAO userDAO;

	@Resource(name="userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User login(String username, String password) {
		User user=userDAO.findUserByName(username);
		if(user==null){
			return null;
		}else if(!password.equals(user.getPassword())){
			return null;
		}
		return user;
	}

	@Override
	public List<User> findAllUsers(int userId) {
		return userDAO.findAllUsers(userId);
	}

	@Override
	public List<User> findUsersByIds(Collection<Integer> ids) {
		return userDAO.findUsersByIds(ids);
	}

	@Override
	public List<User> findUsersbyGroupId(int groupId, int userId) {
		return userDAO.findUsersbyGroupId(groupId, userId);
	}

	@Override
	public User findUserById(int senderId) {
		return userDAO.findUsersById(senderId);
	}

	@Override
	public void add(User user) {
		userDAO.saveUser(user);
	}

}
