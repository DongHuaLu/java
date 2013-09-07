package com.dolph.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dolph.model.ActionResource;
import com.dolph.model.Menu;

public class ActionResourceTreeVO {
	private String data;
	private Map attr =new HashMap();
	private List<ActionResourceTreeVO> children=null;
	
	public ActionResourceTreeVO(ActionResource actionResource) {
		this.data=actionResource.getName();
		this.attr.put("id",actionResource.getId());
		Set<ActionResource> actionResources=actionResource.getChildren();
		if( actionResources!=null && actionResources.size()>0){
			this.children=new ArrayList<ActionResourceTreeVO>();
			for(ActionResource a:actionResources){
				this.children.add(new ActionResourceTreeVO(a));
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

	public List<ActionResourceTreeVO> getChildren() {
		return children;
	}

	public void setChildren(List<ActionResourceTreeVO> children) {
		this.children = children;
	}
}
