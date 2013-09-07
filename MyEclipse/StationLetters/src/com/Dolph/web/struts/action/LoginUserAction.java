/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.Dolph.web.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.Dolph.domain.User;
import com.Dolph.service.UserService;
import com.Dolph.web.struts.form.LoginUserForm;

/**
 * MyEclipse Struts Creation date: 03-04-2013
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/loginUser" name="loginUserForm" parameter="flag"
 *                scope="request" validate="true"
 */
public class LoginUserAction extends DispatchAction {
	/*
	 * Generated Methods
	 */
	public ActionForward loginUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		LoginUserForm loginUserForm = (LoginUserForm) form;
		User user = new User();
		user.setUsername(loginUserForm.getUsername());
		UserService userService = new UserService();
		userService.getUser(user);
		if (loginUserForm.getUsername().equals("")) {
			request.setAttribute("errinfo", "用户名为空");
			return mapping.findForward("err");
		} else if (loginUserForm.getPassword().equals("")) {
			request.setAttribute("errinfo", "密码为空");
			return mapping.findForward("err");
		} else if (userService.checkUsername(loginUserForm.getUsername())) {
			request.setAttribute("errinfo", "用户名不存在");
			return mapping.findForward("err");
		} else if (!user.getPassword().equals(loginUserForm.getPassword())) {
			request.setAttribute("errinfo", "密码错误");
			return mapping.findForward("err");
		} else {
			request.getSession().setAttribute("user", user);
			return mapping.findForward("ok");
		}
	}

	public ActionForward register(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("register");
	}

}