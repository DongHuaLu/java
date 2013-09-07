package com.dolph.model;

import org.apache.commons.lang3.ArrayUtils;

public class ActionMethodOper {
	/***
	 * 操作的唯一标示,如:ADD,DELETE,UPDATA...
	 */
	private String operSn;
	/***
	 * 操作在AclState中索引的位置,索引必须大于0,小于等于31
	 * 同一资源中不同操作的索引是唯一的,不能重复
	 */
	private int operIndex;
	/***
	 * 方法名.同一操作可以对应多个方法
	 * 例:add|addInput,update|updateInput,del...
	 */
	private String methodName;
	/***
	 * 操作名,例:增,删,改,查...
	 */
	private String operName;
	
	public void addMethodName(String methodName){
		if(this.methodName==null){
			this.methodName=methodName;
		}else{
			String[] methodNames=this.methodName.split("\\|");
			if(!ArrayUtils.contains(methodNames,methodName)){
				this.methodName+="|"+methodName;
			}
		}
	}
	
	public String getOperSn() {
		return operSn;
	}
	public void setOperSn(String operSn) {
		this.operSn = operSn;
	}
	public int getOperIndex() {
		return operIndex;
	}
	public void setOperIndex(int operIndex) {
		this.operIndex = operIndex;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getOperName() {
		return operName;
	}
	public void setOperName(String operName) {
		this.operName = operName;
	}
}
