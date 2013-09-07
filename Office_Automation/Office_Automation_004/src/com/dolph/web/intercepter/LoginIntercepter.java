package com.dolph.web.intercepter;

import org.apache.struts2.ServletActionContext;

import com.dolph.vo.LoginInfoVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginIntercepter extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		LoginInfoVO currentUser=(LoginInfoVO) ServletActionContext.getRequest().getSession().getAttribute("login");
		if(currentUser==null){
			return "login";
		}
		return invocation.invoke();
	}

}
