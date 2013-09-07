package com.dolph.service;

import java.util.List;

import com.dolph.model.Role;
import com.dolph.vo.PageVo;

public interface RoleService {

	List<Role> findAllRoles();
	
	PageVo findAllRoles(String sSearch);
	
	public void addRole(Role role);
	public void del(int roleId);
	public void updateRole(Role role);
	public Role findRoleById(int roleId);

}
