package com.dolph.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dolph.annotations.Oper;
import com.dolph.annotations.Res;
import com.dolph.model.Menu;
import com.dolph.service.MenuService;
import com.dolph.utils.JSONUtils;
import com.dolph.vo.MenuTreeVO;
import com.opensymphony.xwork2.ModelDriven;

@Controller("menuAction")
@Scope("prototype")
@Res(name="菜单操作",sn="menu",orderNumber=63,parentSn="security")
public class MenuAction extends BaseAction implements ModelDriven{

	protected MenuService menuService;

	
	protected Menu model;
	@Override
	public Object getModel() {
		if (model==null){
			model=new Menu();
		}return model;
	}
	
	@Oper
	public String execute(){
		return "index";
	}
	
	public void tree(){
		List<Menu> ms=menuService.findRootMenus();
		List<MenuTreeVO> vos=new ArrayList<MenuTreeVO>();
		for(Menu m:ms){
			MenuTreeVO vo=new MenuTreeVO(m);
			vos.add(vo);
		}		
		JSONUtils.toJSON(vos);
	}
	@Oper
	public String updateInput(){
		model=menuService.findMenuById(model.getId());		
		return "update_input";
	}
	@Oper
	public String update(){
		if(model.getParent().getId()==0){
			model.setParent(null);
		}
		menuService.update(model);
		return "success";
	}
	@Oper
	public String addInput(){
		return "add_input";
	}
	
	@Oper
	public String add(){
		menuService.addMenu(model);
		return "success";
	}
	@Oper
	public String del(){
		menuService.delete(model.getId());
		return "success";
	}

	@Resource
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
	




}
