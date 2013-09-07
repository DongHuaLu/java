package com.dolph.Dao.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dolph.Dao.AclDao;
import com.dolph.model.ACL;
import com.dolph.model.Principal;
import com.dolph.model.SysResource;

@Repository("aclDao")
public class AclDaoImpl extends BaseDaoImpl implements AclDao {

	@Override
	public void delAllACLs(int principalId, String principalType,
			String resourceType) {
		Iterator acls=getSession().createQuery("select a from ACL a where a.principalId = ? and a.principalType = ? and a.resourceType=?")
								.setParameter(0, principalId)
								.setParameter(1, principalType)
								.setParameter(2, resourceType)
								.iterate();
		while(acls.hasNext()){
			getSession().delete(acls.next());
		}
	}
	
	@Override
	public ACL findAcl(int principalId, String principalType,
			String resourceType, int resourceId) {
		return (ACL)getSession().createQuery("select a from ACL a where a.principalId = ? and a.principalType = ? and a.resourceType=? and a.resourceId=?")
										.setParameter(0, principalId)
										.setParameter(1, principalType)
										.setParameter(2, resourceType)
										.setParameter(3, resourceId)
										.uniqueResult();
	}

	@Override
	public List<ACL> findAcls(int principalId, String principalType,
			String resourceType) {
		return getSession().createQuery("select a from ACL a where a.principalId = ? and a.principalType = ? and a.resourceType = ?")
											.setParameter(0, principalId)
											.setParameter(1, principalType)
											.setParameter(2, resourceType)
											.list();
	}

	@Override
	public List<SysResource> findAllSysResources(String resourceType) {
		String hql="from "+resourceType;
		return getSession().createQuery(hql).list();
	}

	@Override
	public Principal findPrincipalById(String principalType, int principalId) {
		String hql="from "+principalType+" p where p.id = ?";
		return (Principal)getSession().createQuery(hql).setParameter(0, principalId).uniqueResult();
	}

	@Override
	public SysResource findSysResourceByResourceSn(String resourceSn) {
		String hql="select r from com.dolph.model.SysResource r where r.sn = ?";
		return (SysResource) getSession().createQuery(hql).setParameter(0, resourceSn).uniqueResult();
	}

}
