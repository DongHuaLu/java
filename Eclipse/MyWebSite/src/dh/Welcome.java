package dh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Welcome extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	 {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	{
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		try {
			PrintWriter pw=resp.getWriter();
			
			pw.println("Welcome"+"   "+username+"  "+password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
