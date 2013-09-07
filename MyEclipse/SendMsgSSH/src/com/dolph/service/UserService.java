package com.dolph.service;

import java.util.Collection;
import java.util.List;

import com.dolph.model.User;

public interface UserService {
	public User login(String username,String password);
	
	public List<User> findAllUsers(int userId);
	
	public List<User> findUsersByIds(Collection<Integer> ids);

	public List<User> findUsersbyGroupId(int groupId,int userId);

	public User findUserById(int senderId);
	
	public void add(User user);

}
