package com.dolph.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dolph.model.Menu;

public class MenuTreeVO {
	private String data;
	private Map attr =new HashMap();
	private List<MenuTreeVO> children=null;
	
	public MenuTreeVO(Menu menu){
		this.data=menu.getName();
		this.attr.put("id",menu.getId());
		this.attr.put("href",menu.getHref());
		Set<Menu> menus=menu.getChildren();
		if( menus!=null && menus.size()>0){
			this.children=new ArrayList<MenuTreeVO>();
			for(Menu m:menus){
				this.children.add(new MenuTreeVO(m));
			}
		}
	}	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Map getAttr() {
		return attr;
	}
	public void setAttr(Map attr) {
		this.attr = attr;
	}
	public List<MenuTreeVO> getChildren() {
		return children;
	}
	public void setChildren(List<MenuTreeVO> children) {
		this.children = children;
	}
	

}
