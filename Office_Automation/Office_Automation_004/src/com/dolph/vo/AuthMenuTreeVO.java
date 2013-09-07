package com.dolph.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dolph.model.Menu;

public class AuthMenuTreeVO {
	private Map data=new HashMap();
	private Map attr =new HashMap();
	private List<AuthMenuTreeVO> children=new ArrayList<AuthMenuTreeVO>();
	
	public AuthMenuTreeVO(Menu menu){
		this.data.put("title",menu.getName());
		Map linkattr=new HashMap();
		linkattr.put("href", menu.getHref());
		this.data.put("attr", linkattr);
		
		Set<Menu> menus=menu.getChildren();
		for(Iterator<Menu> iter=menus.iterator();iter.hasNext();){
			Menu subMenu=iter.next();
			AuthMenuTreeVO amtv=new AuthMenuTreeVO(subMenu);
			children.add(amtv);
		}
	}	
	
	
	public Map getAttr() {
		return attr;
	}
	public void setAttr(Map attr) {
		this.attr = attr;
	}
	public List<AuthMenuTreeVO> getChildren() {
		return children;
	}
	public void setChildren(List<AuthMenuTreeVO> children) {
		this.children = children;
	}


	public Map getData() {
		return data;
	}


	public void setData(Map data) {
		this.data = data;
	}
	

}
