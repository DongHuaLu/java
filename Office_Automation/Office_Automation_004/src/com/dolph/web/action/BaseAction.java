package com.dolph.web.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.dolph.service.AclService;
import com.dolph.vo.LoginInfoVO;

public class BaseAction {
	@Resource
	public AclService aclService;

	protected LoginInfoVO currentUser(){
		return (LoginInfoVO) ServletActionContext.getRequest().getSession().getAttribute("login");		
	}
	
	public boolean permit(String resourceSn,String operSn){
		return aclService.hasPermission(currentUser().getId(),resourceSn,operSn);				 
	}
}
