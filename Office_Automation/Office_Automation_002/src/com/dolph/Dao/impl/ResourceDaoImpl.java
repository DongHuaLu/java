package com.dolph.Dao.impl;

import org.springframework.stereotype.Repository;

import com.dolph.Dao.ResourceDao;
import com.dolph.model.ActionResource;

@Repository("resourceDao")
public class ResourceDaoImpl extends BaseDaoImpl implements ResourceDao {

	@Override
	public ActionResource findActionResourceBySn(String sn) {
		String hql="select ar from ActionResource ar where ar.sn=?";
		return (ActionResource) getSession().createQuery(hql).setParameter(0, sn).uniqueResult();
	}

}
