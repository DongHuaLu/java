package com.dolph.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="t_group")
public class Group {
	private int id;
	private String name;
	private Set<User> users=new HashSet<User>();
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="groupSeq")
	@SequenceGenerator(name="groupSeq",sequenceName="group_seq")
	public int getId() {
		return id;
	}
	
	@OneToMany(mappedBy="group")
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
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

}
