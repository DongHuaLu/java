package com.dolph.DAO.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.dolph.DAO.UserDAO;
import com.dolph.model.User;

@Repository("userDAO")
public class UserDAOImpl extends BaseDAO implements UserDAO{
	
	@Override
	public User findUserByName(String username) {
		String hql="select u from User u where u.username = ?";
		return (User) getSession().createQuery(hql)
									.setParameter(0, username)
									.uniqueResult();
	}

	@Override
	public List<User> findAllUsers(int userid) {
		String hql="from User u where u.id!=?";
		return (List<User>)getSession().createQuery(hql)
							.setParameter(0, userid)
							.list();
	}

	@Override
	public List<User> findUsersByIds(Collection<Integer> ids) {
		String hql="from User u where u.id in (:ids)";
		return (List<User>)getSession().createQuery(hql)
							.setParameterList("ids",ids)
							.list();
	}

	@Override
	public List<User> findUsersbyGroupId(int groupid, int userid) {
		String hql="from User u where u.group.id = ? and u.id != ?";
		return (List<User>) getSession().createQuery(hql)
							.setParameter(0, groupid)
							.setParameter(1, userid)
							.list();
	}

	@Override
	public User findUsersById(int senderId) {
		return (User) getSession().load(User.class, senderId);
	}

	@Override
	public void saveUser(User user) {
		getSession().save(user);
		
	}

}
