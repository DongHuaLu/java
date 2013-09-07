package com.dolph.DAO;

import java.util.Collection;
import java.util.List;

import com.dolph.model.User;

public interface UserDAO {
	/**
	 * �����û�������User����
	 * @param username
	 * @return
	 */
	public User findUserByName(String username);
	/**
	 * �ҳ�����User,�����������Userid
	 * @param userid
	 * @return
	 */
	public List<User> findAllUsers(int userid);
	/**
	 * ���ݴ����id����,����UserList
	 * @param ids
	 * @return
	 */
	public List<User> findUsersByIds(Collection<Integer> ids);
	/**
	 * ������id���ر�������User,ȥ��������Լ���id
	 * @param groupid
	 * @param userid
	 * @return
	 */
	public List<User> findUsersbyGroupId(int groupid,int userid);
	public User findUsersById(int senderId);
	public void saveUser(User user);

}
