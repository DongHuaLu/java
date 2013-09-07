package com.dolph.Dao;

import java.util.List;

import com.dolph.model.Role;
import com.dolph.model.User;
import com.dolph.vo.PageVo;

public interface UserDao extends BaseDao {

	PageVo findPersonUsers(String sSearch);

	void update(User user, int[] roleIds);

	List<Role> findRoleIdsOfUser(int userId);

	List findPersonWithUsers(String sSearch);

	User findUserByUsername(String username);

}
