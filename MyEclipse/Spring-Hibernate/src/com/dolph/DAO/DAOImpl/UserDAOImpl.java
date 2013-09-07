package com.dolph.DAO.DAOImpl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.dolph.DAO.UserDAO;
import com.dolph.domain.User2;
@Component("userDAO")
public class UserDAOImpl implements UserDAO {

	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public void saveUser(User2 user) {
		Session ss=sessionFactory.getCurrentSession();
		ss.save(user);
	}

}
