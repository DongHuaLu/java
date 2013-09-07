package com.dolph.DAO;

import java.util.Collection;
import java.util.List;

import com.dolph.model.User;

public interface UserDAO {
	/**
	 * 更具用户名返回User对象
	 * @param username
	 * @return
	 */
	public User findUserByName(String username);
	/**
	 * 找出所有User,不包括传入的Userid
	 * @param userid
	 * @return
	 */
	public List<User> findAllUsers(int userid);
	/**
	 * 根据传入的id集合,返回UserList
	 * @param ids
	 * @return
	 */
	public List<User> findUsersByIds(Collection<Integer> ids);
	/**
	 * 根据组id返回本组所有User,去除传入的自己的id
	 * @param groupid
	 * @param userid
	 * @return
	 */
	public List<User> findUsersbyGroupId(int groupid,int userid);
	public User findUsersById(int senderId);
	public void saveUser(User user);

}
