package com.dolph.DAO.DAOImpl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.dolph.DAO.LogDAO;
import com.dolph.domain.Log;

@Component("logDAO")
public class LogDAOImpl implements LogDAO {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveLog(Log log) {
		Session ss=sessionFactory.getCurrentSession();
		ss.save(log);
	}

}
