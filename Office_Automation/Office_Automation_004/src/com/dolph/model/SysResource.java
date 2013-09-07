package com.dolph.model;

import java.util.List;

public interface SysResource {

	public String getResourceType();
	public int getResourceId();
	public int[] getOperIndexs();
	public List<SysResource> getChildrenResources();
	public int getOperIndexByOperSn(String operSn);
}
