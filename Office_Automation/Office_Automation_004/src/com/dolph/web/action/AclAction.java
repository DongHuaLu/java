package com.dolph.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dolph.model.ACL;
import com.dolph.model.ActionResource;
import com.dolph.model.Company;
import com.dolph.model.Menu;
import com.dolph.model.Role;
import com.dolph.service.AclService;
import com.dolph.service.MenuService;
import com.dolph.service.PartyService;
import com.dolph.service.ResourceService;
import com.dolph.service.RoleService;
import com.dolph.service.UserService;
import com.dolph.utils.JSONUtils;
import com.dolph.vo.AuthVO;
import com.dolph.vo.MenuTreeVO;
import com.dolph.vo.PartyTreeVO;
import com.opensymphony.xwork2.ActionContext;

@Controller("aclAction")
@Scope("prototype")
public class AclAction {
	private RoleService roleService;
	private MenuService menuService;
	private AclService aclService;
	private ResourceService resourceService;
	private UserService userService;
	private PartyService partyService;
	
	private String sSearch;
	private int rootMenuId;
	private String principalType;
	private int principalId;
	private List<AuthVO> authvos;

	/************************************index*****************************************/
	public void roleAuthIndexTree() {
		List<Role> roles=roleService.findAllRoles();
		List vos=new ArrayList();
		for(Role role:roles){
			Map roleTreeVO=new HashMap();
			roleTreeVO.put("data", role.getName());
			Map attr=new HashMap();
			attr.put("id", role.getId());
			attr.put("principalType", "Role");
			roleTreeVO.put("attr", attr);
			vos.add(roleTreeVO);
		}
		JSONUtils.toJSON(vos);
	}
	
	public String roleAuthIndex() {
		return "role_auth_index";
	}
	
	public void userAuthIndexTree() {
		List persons=userService.findPersonWtihUsers(sSearch);
		Map map=new HashMap();
		map.put("aaData",persons);
		JSONUtils.toJSON(map);
	}
	
	public String userAuthIndex() {
		return "user_auth_index";
	}
	
	public void partyAuthIndexTree() {
		Company c=partyService.findRootCompany();
		PartyTreeVO vo=new PartyTreeVO(c);
		JSONUtils.toJSON(vo);
	}	
	
	public String partyAuthIndex() {
		return "party_auth_index";
	}

	/**************************************menuResource***********************************************/
	public String allMenuReosurce(){
		List<Integer> topMenuIds=menuService.findRootMenuIds();
		ActionContext.getContext().put("menuIds", topMenuIds);		
		return "all_menu_reosurce";
	}
	
	public void allMenuReosurceTree(){
		Menu rootMenu=menuService.findMenuById(rootMenuId);
		MenuTreeVO vo=new MenuTreeVO(rootMenu);
		JSONUtils.toJSON(vo);
	}
	
	public void authMenu(){
		aclService.addOrUpdatePermission(principalId,principalType,"Menu",authvos);
	}
	
	public void findMenuAcls(){
		List<AuthVO> vos=aclService.findAclVOs(principalId,principalType,"Menu");
		System.out.println(vos.size());
		JSONUtils.toJSON(vos);

	}
	
	/************************************actionResource***********************************************/
	public String allActionResource(){
		List<ActionResource> actionResources=resourceService.findAllActionResources();
		ActionContext.getContext().put("actionResources",actionResources );
		return "all_action_reosurce";
	}
	
	public void authActionResource(){
		aclService.addOrUpdatePermission(principalId, principalType, "ActionResource", authvos);
	}
	
	public void findActionAcls(){
		List<AuthVO> vos=aclService.findAclVOs(principalId,principalType,"ActionResource");
		JSONUtils.toJSON(vos);
	}
	


	
	





	
	
	
	
	
	public String getPrincipalType() {
		return principalType;
	}

	public void setPrincipalType(String principalType) {
		this.principalType = principalType;
	}

	public int getPrincipalId() {
		return principalId;
	}

	public void setPrincipalId(int principalId) {
		this.principalId = principalId;
	}

	public int getRootMenuId() {
		return rootMenuId;
	}

	public void setRootMenuId(int rootMenuId) {
		this.rootMenuId = rootMenuId;
	}

	public List<AuthVO> getAuthvos() {
		return authvos;
	}

	public void setAuthvos(List<AuthVO> authvos) {
		this.authvos = authvos;
	}
	@Resource
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	@Resource
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	@Resource
	public void setAclService(AclService aclService) {
		this.aclService = aclService;
	}
	@Resource
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getSSearch() {
		return sSearch;
	}

	public void setSSearch(String sSearch) {
		this.sSearch = sSearch;
	}

	@Resource
	public void setPartyService(PartyService partyService) {
		this.partyService = partyService;
	}
}
