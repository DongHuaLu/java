package com.dolph.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

public class ActionResource implements SysResource {
	private int id;
	/***
	 * 资源对应的action名(可能有多个 用|分开 例:...partyAction|...|companyAction)
	 */
	private String className;
	/***
	 * 资源名(例:组织机构管理,公文管理)
	 */
	private String name;
	/***
	 * 资源的唯一标示(company,department...)
	 */
	private String sn;
	/***
	 * 资源的排序号
	 */
	/***
	 * 父资源的唯一标识
	 */
	private String parentSn;
	
	private int orderNumber;
	/***
	 * 资源所包含的操作, key就是operSn,操作唯一标识
	 */
	private Map<String, ActionMethodOper> opers;
	
	private ActionResource parent;
	
	private Set<ActionResource> children=new HashSet<ActionResource>();
	
	
	public void addActionMethodOper(String methodName,String operName,String operSn,int operIndex){
		if(opers == null){
			opers = new HashMap<String, ActionMethodOper>();
		}
		ActionMethodOper amo = opers.get(operSn);
		if(amo != null){
			amo.addMethodName(methodName);
		}else{
			//首先判断索引值是否已经存在，如果已经存在，就要抛出异常，因为operIndex不允许重复
			for(ActionMethodOper o : opers.values()){
				if(o.getOperIndex() == operIndex){
					throw new RuntimeException("针对资源[" + name + "]的操作[" + 
												o.getOperName() + "]已经和索引[" 
												+ o.getOperIndex() + "]绑定，无法把操作[" + 
												operName + "]再次绑定到相同的索引");
				}
			}
			amo = new ActionMethodOper();
			amo.setMethodName(methodName);
			amo.setOperName(operName);
			amo.setOperIndex(operIndex);
			amo.setOperSn(operSn);
			opers.put(operSn, amo);
		}
	}
	
	
	
	
	public void addClassName(String className){
		if(this.className==null){
			this.className=className;
		}else{
			String[] classNames=this.className.split("\\|");
			if(!ArrayUtils.contains(classNames,className)){
				this.className+="|"+className;
			}
		}
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Map<String, ActionMethodOper> getOpers() {
		return opers;
	}

	public void setOpers(Map<String, ActionMethodOper> opers) {
		this.opers = opers;
	}

	public ActionResource getParent() {
		return parent;
	}

	public void setParent(ActionResource parent) {
		this.parent = parent;
	}

	public Set<ActionResource> getChildren() {
		return children;
	}

	public void setChildren(Set<ActionResource> children) {
		this.children = children;
	}

	public String getParentSn() {
		return parentSn;
	}

	public void setParentSn(String parentSn) {
		this.parentSn = parentSn;
	}
}
