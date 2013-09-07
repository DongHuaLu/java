package com.dolph.web.intercepter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dolph.vo.LoginInfoVO;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		LoginInfoVO currentUser = (LoginInfoVO) request.getSession()
				.getAttribute("login");

		if (currentUser == null) {
			StringBuffer fileURL = request.getRequestURL();
			if (fileURL.indexOf(".jpg") > 0 || fileURL.indexOf(".bmp") > 0
					|| fileURL.indexOf(".gif") > 0) {
				chain.doFilter(request, response);
				return;
			}
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
