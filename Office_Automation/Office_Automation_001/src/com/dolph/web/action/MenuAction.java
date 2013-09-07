package com.dolph.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dolph.model.Menu;
import com.dolph.service.MenuService;
import com.dolph.utils.JSONUtils;
import com.dolph.vo.MenuTreeVO;
import com.opensymphony.xwork2.ModelDriven;

@Controller("menuAction")
@Scope("prototype")
public class MenuAction implements ModelDriven{

	protected MenuService menuService;

	
	protected Menu model;
	@Override
	public Object getModel() {
		if (model==null){
			model=new Menu();
		}return model;
	}
	
	
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

	public String updateInput(){
		model=menuService.findMenuById(model.getId());		
		return "update_input";
	}
	
	public String update(){
		if(model.getParent().getId()==0){
			model.setParent(null);
		}
		menuService.update(model);
		return "success";
	}
	
	public String addInput(){
		return "add_input";
	}
	
	
	public String add(){
		menuService.addMenu(model);
		return "success";
	}
	
	public String del(){
		menuService.delete(model.getId());
		return "success";
	}

	@Resource
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
	




}
