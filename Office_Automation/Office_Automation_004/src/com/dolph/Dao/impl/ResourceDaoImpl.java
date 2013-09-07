package com.dolph.Dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dolph.Dao.ResourceDao;
import com.dolph.model.ActionResource;
import com.dolph.vo.PageVo;

@Repository("resourceDao")
public class ResourceDaoImpl extends BaseDaoImpl implements ResourceDao {

	@Override
	public ActionResource findActionResourceBySn(String sn) {
		String hql="select ar from ActionResource ar where ar.sn=?";
		return (ActionResource) getSession().createQuery(hql).setParameter(0, sn).uniqueResult();
	}

	@Override
	public List<ActionResource> findRootActionResources() {
		String hql="select ar from ActionResource ar where ar.parent is null order by ar.orderNumber";
		return getSession().createQuery(hql).list();
	}

	@Override
	public void update(ActionResource ar) {
		ActionResource old=(ActionResource) getSession().load(ActionResource.class,ar.getId());
		ar.setOpers(old.getOpers());
		getSession().merge(ar);
	}

	@Override
	public List<ActionResource> findAll() {
		String hql="select ar from ActionResource ar order by ar.orderNumber";
		return getSession().createQuery(hql).list();
	}

	@Override
	public ActionResource findActionResourceByClassName(String className) {
		String hql="select r from ActionResource r where r.className like ?";
		return (ActionResource) getSession().createQuery(hql).setParameter(0, "%"+className+"%").uniqueResult();
	}


}
