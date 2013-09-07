package com.dolph.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User implements Principal {
	private int id;
	private String username;
	private String password;
	private Person person;
	private Set<UserRoles> userRoles=new HashSet<UserRoles>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Set<UserRoles> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}
	@Override
	public int getPrincipalId() {
		return id;
	}
	@Override
	public String getPrincipalType() {
		return "User";
	}
	@Override
	public List<Principal> getParentPrincipals() {
		List<Principal> parents=new ArrayList<Principal>();
		Principal parentParty=person.getParent();
		if(parentParty!=null){
			parents.add(parentParty);
		}
		
		if(userRoles!=null){
			for(UserRoles ur:userRoles){
				parents.add(ur.getRole());
			}
		}
		
		return parents;
	}

}
