package com.dolph.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.dolph.DAO.UserDAO;
import com.dolph.model.User;

@Component("userDAO")
public class UserDAOImpl implements UserDAO {
	private SessionFactory sessionFactory;

	


	@Override
	public void save(User user) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println(sessionFactory);
		session.save(user);
	}
	
	
	

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}





	@Override
	public boolean idExistByName(String username) {
		Session session=sessionFactory.getCurrentSession();
		long count=(Long)session.createQuery("select count(*) from User u where u.username=:username").setString("username",username).uniqueResult();
		if(count>0) return true;
		return false;
	}



	@Override
	public List<User> listUser() {
		Session session=sessionFactory.getCurrentSession();
		ArrayList<User> users=(ArrayList<User>)session.createQuery("from User u").list();
		return users;
	}

}
