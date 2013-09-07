package com.dolph.DAO;

import java.util.List;

import com.dolph.model.User;

public interface UserDAO {
	public void save(User user);

	public boolean idExistByName(String username);

	public List<User> listUser();
}
