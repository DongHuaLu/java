package com.dolph.service;

import java.util.List;

import com.dolph.model.ACL;
import com.dolph.vo.AuthVO;

public interface AclService {

	void addOrUpdatePermission(int principalId, String principalType,
			String resourceTpye, List<AuthVO> authvos);

	List<ACL> findAcls(int principalId, String principalType, String resourceType);

	List<AuthVO> findAclVOs(int principalId, String principalType, String string);


}
