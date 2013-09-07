package ser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;

import service.BookService;
import service.Cart;
import service.UserService;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String userName=request.getParameter("username");
		String passWord=request.getParameter("password");
		UserService us=new UserService();
		domain.User user=us.checkUser(userName);
		
		if(userName.equals("")){
			request.setAttribute("error","用户名不能为空");
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}else if(user.getUsername()==null){
			request.setAttribute("error","用户名错误");
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}else if(passWord.equals("")){
			request.setAttribute("error","密码不能为空");
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}else if(!user.getPassword().equals(passWord)){
			request.setAttribute("error","密码错误");
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}else{
			request.setAttribute("uid",user.getId());
			Cart cart=new Cart();
			request.getSession().setAttribute("cart", cart);
			BookService bs=new BookService();
			ArrayList al=(ArrayList) bs.getAllBooks();
			request.setAttribute("books",al);
			request.getRequestDispatcher("WEB-INF/wel.jsp").forward(request, response);
		}
		
	
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
