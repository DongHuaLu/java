package com.dolph.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dolph.model.Role;
import com.dolph.model.User;
import com.dolph.service.RoleService;
import com.dolph.service.UserService;
import com.dolph.utils.JSONUtils;
import com.dolph.vo.PageVo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
@Controller("userAction")
@Scope("prototype")
public class UserAction implements ModelDriven {
	
	private String sSearch;	
	private UserService userService;	
	private RoleService roleService;
	private int[] roleIds;

	private User model;
	@Override
	public Object getModel() {
		if(model==null){
			model=new User();
		}
		return model;
	}
	
	public String execute(){
		return "index";
	}
	
	
	public void list(){
		PageVo vo=userService.findPersonUsers(sSearch);
		Map map=new HashMap();
		map.put("aaData", vo.getDatas());
		map.put("iTotalRecords", vo.getTotal());
		map.put("iTotalDisplayRecords", vo.getTotal());
		JSONUtils.toJSON(map);
	}
	
	public String addInput(){
		List<Role> roles=roleService.findAllRoles();
		ActionContext.getContext().put("roles",roles);
		return "add_input";
	}
	
	public String add(){
		userService.addUser(model,roleIds);
		return "success";
	}
	
	public String updateInput(){
		model=userService.findUserById(model.getId());
		List<Role> roles=roleService.findAllRoles();
		ActionContext.getContext().put("roles",roles);
		List<Role> selectedRoles=userService.findRoleIdsOfUser(model.getId());
		ActionContext.getContext().put("selectedRoles",selectedRoles);
		return "update_input";
	}
	
	/*<s:iterator value="roles">
	 	<option value="...." <s:property value="hasSelected(id,selectedRoles)"/>/>
	 </s:iterator>	 
	 */
	
	public String hasSelected(int roleId,List<Integer> selectedRoles){
		System.out.println(roleId);
		System.out.println(selectedRoles);
		if(selectedRoles==null){
			return "";
		}
		for(Integer i:selectedRoles){
			if(i.equals(roleId))
				return "selected";
		}
		return "";
	}
	
	public String update(){
		userService.updateUser(model,roleIds);
		return "success";
	}
	
	
	public String del(){
		userService.delUser(model.getId());
		return "success";
	}

	public String getSSearch() {
		return sSearch;
	}

	public void setSSearch(String sSearch) {
		this.sSearch = sSearch;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Resource
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public int[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(int[] roleIds) {
		this.roleIds = roleIds;
	}
}
