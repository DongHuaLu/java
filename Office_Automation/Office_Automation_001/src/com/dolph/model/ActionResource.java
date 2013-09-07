package com.dolph.model;

import java.util.Map;

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
	private int orderNumber;
	/***
	 * 资源所包含的操作, key就是operSn,操作唯一标识
	 */
	private Map<String, ActionMethodOper> opers;

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
}
