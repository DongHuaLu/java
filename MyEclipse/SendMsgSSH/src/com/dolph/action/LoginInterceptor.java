package com.dolph.action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Object o=invocation.getInvocationContext().getSession().get("user");
		if(o==null){
			return "login";
		}
		
		return invocation.invoke();
	}

}
