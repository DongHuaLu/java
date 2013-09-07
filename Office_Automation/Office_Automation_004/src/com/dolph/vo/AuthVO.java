package com.dolph.vo;

public class AuthVO {
	private int resourceId;
	private int operIndex;
	private boolean permit;//ture 许可,false 拒绝
	private boolean extend;//true 继承,false 不继承
	
	public int getOperIndex() {
		return operIndex;
	}
	public void setOperIndex(int operIndex) {
		this.operIndex = operIndex;
	}
	
	public boolean isExtend() {
		return extend;
	}
	public void setExtend(boolean extend) {
		this.extend = extend;
	}
	public boolean isPermit() {
		return permit;
	}
	public void setPermit(boolean permit) {
		this.permit = permit;
	}
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

}
