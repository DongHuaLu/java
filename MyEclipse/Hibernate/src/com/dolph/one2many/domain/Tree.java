package com.dolph.one2many.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;

@Entity
public class Tree {
	private int id;
	private Set<Leaf> leafs=new HashSet<Leaf>();
	private String name;
	
	@Id
	public int getId() {
		return id;
	}
	@OneToMany
	@JoinColumn(name="treeid")
	public Set<Leaf> getLeafs() {
		return leafs;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setLeafs(Set<Leaf> leafs) {
		this.leafs = leafs;
	}
	public void setName(String name) {
		this.name = name;
	}

}
