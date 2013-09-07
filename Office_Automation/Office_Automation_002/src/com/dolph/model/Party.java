package com.dolph.model;

import java.util.Set;

public class Party {
	private Set<Party> childs;
	private String description;
	private int id;
	private String name;
	private Party parent;
	private String sn;
	
	public Set<Party> getChilds() {
		return childs;
	}
	public String getDescription() {
		return description;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Party getParent() {
		return parent;
	}
	public String getSn() {
		return sn;
	}
	public void setChilds(Set<Party> childs) {
		this.childs = childs;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setParent(Party parent) {
		this.parent = parent;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}

}
