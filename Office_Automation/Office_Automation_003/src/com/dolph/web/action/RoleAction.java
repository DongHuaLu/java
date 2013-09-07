package com.dolph.web.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dolph.annotations.Oper;
import com.dolph.annotations.Res;
import com.dolph.model.Role;
import com.dolph.service.RoleService;
import com.dolph.utils.JSONUtils;
import com.dolph.vo.PageVo;
import com.opensymphony.xwork2.ModelDriven;

@Controller("roleAction")
@Scope("prototype")
@Res(name="角色操作",sn="role",orderNumber=62,parentSn="security")
public class RoleAction implements ModelDriven {

	private String sSearch;
	private RoleService roleService;
	private Role model;

	@Override
	public Object getModel() {
		if (model == null) {
			model = new Role();
		}
		return model;
	}

	@Oper
	public String execute() {
		return "index";
	}

	public void list() {
		PageVo vo = roleService.findAllRoles(sSearch);
		Map map = new HashMap();
		map.put("aaData", vo.getDatas());
		map.put("iTotalRecords", vo.getTotal());
		map.put("iTotalDisplayRecords", vo.getTotal());
		JSONUtils.toJSON(map);
	}
	@Oper
	public String addInput() {
		return "add_input";
	}
	@Oper
	public String add() {
		roleService.addRole(model);
		return "success";
	}
	@Oper
	public String updateInput() {
		model = roleService.findRoleById(model.getId());
		return "update_input";
	}
	@Oper
	public String update() {
		roleService.updateRole(model);
		return "success";
	}
	@Oper
	public String del() {
		roleService.del(model.getId());
		return "success";
	}

	public String getSSearch() {
		return sSearch;
	}

	public void setSSearch(String sSearch) {
		this.sSearch = sSearch;
	}

	@Resource
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

}
