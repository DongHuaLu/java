package com.dolph.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dolph.Dao.RoleDao;
import com.dolph.model.Role;
import com.dolph.service.RoleService;
import com.dolph.vo.PageVo;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	private RoleDao roleDao;

	@Override
	public List<Role> findAllRoles() {
		return roleDao.findAll(Role.class);
	}

	@Override
	public PageVo findAllRoles(String sSearch) {		
		if(sSearch==null||"".endsWith(sSearch)){
			return roleDao.findPaging("select r.id,r.name from Role r");
		}else{
			try {
				sSearch = new String(sSearch.getBytes("iso8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} 
			return roleDao.findPaging("select r.id,r.name from Role r where r.name like ?", "%"+sSearch+"%");
		}
	}

	@Override
	public void addRole(Role role) {
		roleDao.save(role);
	}

	@Override
	public void del(int roleId) {
		roleDao.dalete(findRoleById(roleId));
	}

	@Override
	public void updateRole(Role role) {
		roleDao.update(role);		
	}
	
	@Override
	public Role findRoleById(int roleId) {
		return roleDao.findById(Role.class, roleId);
	}

	@Resource
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
}
