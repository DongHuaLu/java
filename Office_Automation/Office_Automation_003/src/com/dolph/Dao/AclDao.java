package com.dolph.Dao;

import java.util.List;

import com.dolph.model.ACL;
import com.dolph.model.Principal;
import com.dolph.model.SysResource;

public interface AclDao extends BaseDao {

	void delAllACLs(int principalId, String principalType, String resourceType);

	ACL findAcl(int principalId, String principalType, String resourceType,
			int resourceId);

	List<ACL> findAcls(int principalId, String principalType,
			String resourceType);

	List<SysResource> findAllSysResources(String resourceType);

	Principal findPrincipalById(String principalType, int principalId);



}
