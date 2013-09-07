package com.dolph.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dolph.Dao.AclDao;
import com.dolph.Dao.MenuDao;
import com.dolph.Dao.UserDao;
import com.dolph.model.ACL;
import com.dolph.model.Menu;
import com.dolph.model.Principal;
import com.dolph.model.SysResource;
import com.dolph.model.User;
import com.dolph.service.AclService;
import com.dolph.vo.AuthVO;

@Service("aclService")
public class AclServiceImpl implements AclService {
	@Resource
	private AclDao aclDao;
	@Resource
	private MenuDao menuDao;
	@Resource
	private UserDao userDao;

	@Override
	public void addOrUpdatePermission(int principalId, String principalType,
			String resourceType, List<AuthVO> authvos) {
		// 先删除主体所有的ACL记录
		aclDao.delAllACLs(principalId, principalType, resourceType);
		
		
		if (authvos != null) {
			for (AuthVO authvo : authvos) {
				int operIndex = authvo.getOperIndex();
				int resourceId = authvo.getResourceId();
				boolean permit = authvo.isPermit();
				boolean extend = authvo.isExtend();

				ACL acl = aclDao.findAcl(principalId, principalType,
						resourceType, resourceId);
				if (acl == null) {
					acl = new ACL();
					acl.setPrincipalId(principalId);
					acl.setPrincipalType(principalType);
					acl.setResourceId(resourceId);
					acl.setResourceType(resourceType);
					acl.setPermission(operIndex, permit, extend);
					aclDao.save(acl);
				} else {
					acl.setPermission(operIndex, permit, extend);
					aclDao.update(acl);
				}
			}
		}

	}


	@Override
	public List<ACL> findAcls(int principalId, String principalType,
			String resourceType) {
		return aclDao.findAcls(principalId,principalType,resourceType);
	}
	@Override
	public List<AuthVO> findAclVOs(int principalId, String principalType,
			String resourceType) {
		List<AuthVO> vos=new ArrayList<AuthVO>();
		List<SysResource> sysResources=aclDao.findAllSysResources(resourceType);
		for(SysResource sysResource:sysResources){
			int [] operIndexs=sysResource.getOperIndexs();
			if(operIndexs!=null){
				for(int operIndex:operIndexs){
					AuthVO vo=searchAcl(principalId,principalType,sysResource.getResourceId(),resourceType,operIndex);
					if(vo!=null){
						vos.add(vo);						
					}
				}
			}
		}		
		return vos;
	}
	private AuthVO searchAcl(int principalId, String principalType,
			int resourceId,String resourceType, int operIndex) {
		//查询主体是否有该资源的授权(acl记录)
		ACL acl=aclDao.findAcl(principalId, principalType, resourceType, resourceId);
		AuthVO vo=null;
		if(acl!=null && !acl.isExtend(operIndex)){
			vo=new AuthVO();
			vo.setResourceId(resourceId);
			vo.setPermit(acl.isPermit(operIndex));
			vo.setExtend(acl.isExtend(operIndex));
			vo.setOperIndex(operIndex);
			return vo;
		}
		Principal principal=aclDao.findPrincipalById(principalType,principalId);
		List<Principal> parent=principal.getParentPrincipals();
		if(parent!=null){
			for(Principal p:parent){
				AuthVO pvo=searchAcl(p.getPrincipalId(), p.getPrincipalType(), resourceId, resourceType, operIndex);
				if(pvo!=null){
					vo=new AuthVO();
					vo.setExtend(true);
					vo.setPermit(pvo.isPermit());
					vo.setResourceId(resourceId);
					vo.setOperIndex(operIndex);
				}
			}
		}
		return vo;
	}
	@Override
	public List<Menu> findPermitMenu(int userId) {
		List<Menu> topMenus=menuDao.findRootMenus();		
		removeDenyMenus(topMenus,userId);
		return topMenus;
	}
	private void removeDenyMenus(Collection<Menu> topMenus, int userId) {
		for(Iterator<Menu> iter=topMenus.iterator();iter.hasNext();){
			Menu menu=iter.next();
			AuthVO vo=searchAcl(userId, "User", menu.getId(), "Menu", menu.getOperIndexs()[0]);
			if(vo==null || !vo.isPermit()){
				iter.remove();
			}else{
				removeDenyMenus(menu.getChildren(),userId);
			}
		}
		
	}
	@Override
	public boolean hasPermission(int userId, String resourceSn, String operSn) {
		User user=userDao.findById(User.class, userId);
		SysResource sysResource=aclDao.findSysResourceByResourceSn(resourceSn);
		int operIndex=sysResource.getOperIndexByOperSn(operSn);
		AuthVO vo=searchAcl(user.getPrincipalId(), user.getPrincipalType(), sysResource.getResourceId(), sysResource.getResourceType(), operIndex);
		if(vo!=null && vo.isPermit()){
			return true;
		}		
		return false;
	}
	
	


}
