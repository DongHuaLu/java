package com.dolph.one2manyAndmany2one.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class One {

	private int id;
	private String name;
	private Set<Many> many=new HashSet<Many>();
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy="one")
	public Set<Many> getMany() {
		return many;
	}
	public void setMany(Set<Many> many) {
		this.many = many;
	}
}
