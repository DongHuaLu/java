package ser;

import impl.Userimpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.User;

public class Loginser extends HttpServlet {
	
	Userimpl userimpl=new Userimpl();
	int vistorval=0;

	/**
	 * Constructor of the object.
	 */
	public Loginser() {
		super();

	}

	/**
	 * 结束写入计数器文件
	 */
	public void destroy() {
		BufferedWriter bw=null;
		FileWriter f=null;
		super.destroy(); 
			try {
				f=new FileWriter("C://Vistor.txt");
				bw=new  BufferedWriter(f);
				bw.write(vistorval+"");
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					bw.close();
					f.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String status=request.getParameter("status");
		
		if(status.equals("login")){
			String username=request.getParameter("uName");
			System.out.println(username+"-"+request.getRemoteAddr());
			String userPassword=request.getParameter("uPassword");
			User user=new User();
			user=(User)userimpl.queryuser(username/*,userPassword*/);
			
			if(username.equals("")){
				request.setAttribute("error", "用户名不能为空");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else if(!(username.equals(user.getuName()))){
				request.setAttribute("error", "用户名不存在");	
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else if(userPassword.equals("")){
				request.setAttribute("error", "密码不能为空");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else if(!(userPassword.equals(user.getuPassword()))){
				request.setAttribute("error", "密码错误");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else{
				HttpSession session=request.getSession();
				session.setAttribute("uid",user.getuId());
				Cookie cookieuname=new Cookie("cookieuName",username);
				Cookie cookieupass=new Cookie("cookieuPassword",userPassword);
				cookieuname.setMaxAge(60*60*24*Integer.parseInt(request.getParameter("cookieAge")));
				cookieupass.setMaxAge(cookieuname.getMaxAge());
				response.addCookie(cookieuname);
				response.addCookie(cookieupass);	
				vistorval++;//计数器++
				
				response.sendRedirect("/StudentMS2/logined/index.jsp?vistorval="+vistorval+"&ip="+request.getRemoteAddr());

			}
		}
		
		
		if(status.equals("iscookied")){
			System.out.println("======");
			Cookie[] cookies=request.getCookies();
			for (Cookie cookie:cookies){
				if(cookie.getName().equals("cookieuName")){
					request.setAttribute("cookieuName", cookie.getValue());
				}
				if(cookie.getName().equals("cookieuPassword")){
					request.setAttribute("cookieuPassword",cookie.getValue());
				}
			}
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
					
	}



	/**
	 * 
	 * 初始化读取计数器文件
	 */
	public void init() throws ServletException {
		BufferedReader br=null;
		FileReader f=null;
		{
			try {
				f=new FileReader("c:/Vistor.txt");
				br=new BufferedReader(f);
				try {
					String vals=br.readLine();
					vistorval=Integer.parseInt(vals);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}finally {
				try {
					br.close();
					f.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	

}
