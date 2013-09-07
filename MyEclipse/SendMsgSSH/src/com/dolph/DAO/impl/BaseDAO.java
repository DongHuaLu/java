package com.dolph.DAO.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDAO {
	private SessionFactory sessionFactory;
	
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
