/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.dolph.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.dolph.struts.form.RegisterForm;
import com.dolph.service.RegisterService;
import com.dolph.domain.User;


/** 
 * MyEclipse Struts
 * Creation date: 03-02-2013
 * 
 * XDoclet definition:
 * @struts.action path="/register" name="registerForm" scope="request" validate="true"
 */
public class RegisterAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		RegisterForm registerForm = (RegisterForm) form;
		RegisterService registerService=new RegisterService();
		User user=new User();
		if(((registerService.queryByUsername(registerForm.getUsername()).getUsername())==null)){
			user.setEmail(registerForm.getEmail());
			user.setPassword(registerForm.getPassword());
			user.setTel(registerForm.getTel());
			user.setUsername(registerForm.getUsername());
			user.setGrade(1);			
		}
		else{
			request.setAttribute("err","用户名已存在");
			return mapping.findForward("err_areadyhas");
		}
		if(registerService.regiser(user)){
			return mapping.findForward("ok");
		}
		else{
			return mapping.findForward("err");
		}
		


	}
}