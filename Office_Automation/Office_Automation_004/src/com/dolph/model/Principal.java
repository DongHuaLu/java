package com.dolph.model;

import java.util.List;

public interface Principal {
	public int getPrincipalId();
	public String getPrincipalType();
	public List<Principal> getParentPrincipals();

}
