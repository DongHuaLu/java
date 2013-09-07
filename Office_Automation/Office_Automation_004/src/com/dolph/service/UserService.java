package com.dolph.service;

import java.util.List;

import com.dolph.model.Role;
import com.dolph.model.User;
import com.dolph.vo.PageVo;

public interface UserService {

	PageVo findPersonUsers(String sSearch);

	void addUser(User user);

	void addUser(User user, int[] roleIds);

	void delUser(int id);

	User findUserById(int id);

	List<Role> findRoleIdsOfUser(int id);

	void updateUser(User user, int[] roleIds);
	
	void updateUser(User user);

	List findPersonWtihUsers(String sSearch);

	User login(String username, String password);
}
