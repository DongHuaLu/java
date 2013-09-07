package com.dolph.model;

public class ACL {
	private int id;
	private String principalType;
	private int principalId;
	private String resourceType;
	private int resourceId;
	private int aclState;
	private int aclTriState;

	public void setPermission(int index, boolean permit, boolean extend) {
		if (index < 0 || index > 31) {
			throw new RuntimeException("授权操作[" + index + "]索引越界,应在0-31中");
		}
		aclState = setBit(aclState, index, permit);
		aclTriState = setBit(aclTriState, index, extend);
	}

	public boolean isPermit(int index) {
		return getBit(aclState, index);
	}
	
	public boolean isExtend(int index){
		return getBit(aclTriState,index);
	}

	private boolean getBit(int state, int index) {
		int temp = 1;
		temp = temp << index;
		temp = state & temp;
		if(temp==0){
			return false;
		}else{
			return true;			
		}
	}

	private int setBit(int state, int index, boolean value) {
		int temp = 1;
		temp = temp << index;
		if (value) {
			state = state | temp;
		} else {
			temp = ~temp;
			state = state & temp;
		}
		return state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrincipalType() {
		return principalType;
	}

	public void setPrincipalType(String principalType) {
		this.principalType = principalType;
	}

	public int getPrincipalId() {
		return principalId;
	}

	public void setPrincipalId(int principalId) {
		this.principalId = principalId;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public int getAclState() {
		return aclState;
	}

	public void setAclState(int aclState) {
		this.aclState = aclState;
	}

	public int getAclTriState() {
		return aclTriState;
	}

	public void setAclTriState(int aclTriState) {
		this.aclTriState = aclTriState;
	}
}
