package com.dolph.Dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dolph.Dao.InitDao;
import com.dolph.model.ACL;
import com.dolph.model.Person;
import com.dolph.model.Principal;
import com.dolph.model.Role;
import com.dolph.model.SysResource;
import com.dolph.model.User;
import com.dolph.model.UserRoles;

@Repository("initDao")
public class InitDaoImpl extends BaseDaoImpl implements InitDao {

	@Override
	public void addInitAdmin() {		
		getSession().flush();
		getSession().clear();

		Person admin=new Person();
		admin.setName("超级管理员");
		getSession().save(admin);
		
		User adminUser=new User();
		adminUser.setPerson(admin);
		adminUser.setUsername("admin");
		adminUser.setPassword("admin");
		getSession().save(adminUser);
		
		Role adminRole=new Role();
		adminRole.setName("系统管理员");
		getSession().save(adminRole);
		
		Role commonRole=new Role();
		commonRole.setName("普通员工");
		getSession().save(commonRole);
		
		UserRoles ur1=new UserRoles();
		ur1.setUser(adminUser);
		ur1.setRole(adminRole);
		getSession().save(ur1);
		
		UserRoles ur2=new UserRoles();
		ur2.setUser(adminUser);
		ur2.setRole(commonRole);
		getSession().save(ur2);
		
		String hql="select r from com.dolph.model.SysResource r where r.sn in ('system','security','party')";
		List<SysResource> sysResources=getSession().createQuery(hql).list();
		
		for(SysResource r:sysResources){
			saveAllPermitAcl(adminRole,r);
			saveAllPermitAcl(adminUser,r);
		}
		hql="select r from com.dolph.model.SysResource r where r.sn in ('personal','workflow')";
		sysResources=getSession().createQuery(hql).list();
			
		for(SysResource r:sysResources){
				saveAllPermitAcl(commonRole,r);
		}
	}

	private void saveAllPermitAcl(Principal principal, SysResource r) {
		ACL acl=new ACL();
		acl.setPrincipalId(principal.getPrincipalId());
		acl.setPrincipalType(principal.getPrincipalType());
		acl.setResourceId(r.getResourceId());
		acl.setResourceType(r.getResourceType());
		acl.setAclState(-1);
		acl.setAclTriState(0);
		getSession().save(acl);
		
		List<SysResource> sysResources=r.getChildrenResources();
		
		if(sysResources!=null){
			for(SysResource res:sysResources){
				saveAllPermitAcl(principal, res);
			}
		}
	}

}
