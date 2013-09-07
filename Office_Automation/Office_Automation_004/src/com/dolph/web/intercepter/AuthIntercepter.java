package com.dolph.web.intercepter;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.dolph.model.ActionResource;
import com.dolph.service.AclService;
import com.dolph.service.ResourceService;
import com.dolph.vo.LoginInfoVO;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthIntercepter extends AbstractInterceptor {

	@Resource
	private ResourceService resourceService;
	@Resource
	private AclService aclService;
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//得到要调用的类名
		String className=invocation.getProxy().getAction().getClass().getName();
		//根据类名得到对应的ActionResource
		ActionResource actionResource=resourceService.findActionResourceByClassName(className);
		//如果不是资源,不用控制
		if(actionResource==null){
			return invocation.invoke();
		}
		//得到调用的方法名
		String methodName=invocation.getProxy().getMethod();
		//根据方法名查出该ActionResource中oper的唯一Sn
		String operSn=actionResource.getOperSnByMethodName(methodName);
		//如果没有定义操作,不用控制
		if(operSn==null){
			return invocation.invoke();
		}
		
		int userId=((LoginInfoVO)ServletActionContext.getRequest().getSession().getAttribute("login")).getId();
		
		boolean permit=aclService.hasPermission(userId, actionResource.getSn(), operSn);
		if(permit){
			return invocation.invoke();
		}
		throw new RuntimeException("无权进行本操作!");
	}

}
