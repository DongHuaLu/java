package dh;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.io.*;

public class LoginCl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	{
		String u=req.getParameter("username");
		String p=req.getParameter("password");
		
		try {
			if(u.equals("DH")&&p.equals("123"))
				resp.sendRedirect("welcome?username="+u+"&password="+p);
			else
				resp.sendRedirect("hello");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	{
		
		this.doGet(req, resp);

	}

	
	
}
