package ser;

import impl.Studentimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Student;

public class Studentser extends HttpServlet {
	
	Studentimpl studentimpl=new Studentimpl();
	
	/**
	 * Constructor of the object.
	 */
	public Studentser() {
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
		String status=request.getParameter("status");
		
		if(status.equals("queryStudent")){//查询数据			
			String keyword=request.getParameter("keyword");
			request.getSession().setAttribute("keyword", keyword);
			request.getSession().setAttribute("studentscurrentPage", 1);
			request.getSession().setAttribute("studentstotalPage", studentimpl.cluPage(keyword));
			List<Student> students=studentimpl.queryStudent(keyword,1);
			
			request.setAttribute("students", students);//把students list传到request中
			RequestDispatcher dispatcher=request.getRequestDispatcher("/logined/student/queryStudent.jsp");
			dispatcher.forward(request, response);//把request和response重新发回到dispatcher中;
		}
		
		if(status.equals("splitPage")){
			int studentscurrentPage=Integer.parseInt(request.getParameter("studentscurrentPage"));
			String keyword=(String) request.getSession().getAttribute("keyword");
			request.getSession().setAttribute("studentscurrentPage", studentscurrentPage);
			List<Student> students=studentimpl.queryStudent(keyword, studentscurrentPage);
			request.setAttribute("students", students);
			request.getRequestDispatcher("/logined/student/queryStudent.jsp").forward(request, response);
		}
		
		if (status.equals("saveStudent")){//插入学生数据
			Student student=new Student();
			student.setStuName(request.getParameter("stuName"));
			student.setStuNo(request.getParameter("stuNo"));
			student.setStuSex(request.getParameter("stuSex"));
			student.setStuAge(Integer.parseInt(request.getParameter("stuAge")));
			student.setStuAddress(request.getParameter("stuAddress"));
			studentimpl.saveStudent(student);	
			this.getServletContext().setAttribute("students", studentimpl.queryStudent(""));
			response.sendRedirect("/StudentMS2/logined/student/queryStudent.jsp");
		}
		if (status.equals("deleteStudent")){//删除数据
			studentimpl.deleteStudent(Integer.parseInt(request.getParameter("stuSeat")));
			String keyword=(String) request.getSession().getAttribute("keyword");
			List<Student> students=studentimpl.queryStudent(keyword);
			request.setAttribute("students", students);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/logined/student/queryStudent.jsp");
			dispatcher.forward(request, response);
			this.getServletContext().setAttribute("students", studentimpl.queryStudent(""));	
		}
		
		if (status.equals("updateStudent")){//更新数据
			Student student=new Student();
			student.setStuSeat(Integer.parseInt(request.getParameter("stuSeat")));
			student.setStuName(request.getParameter("stuName"));
			student.setStuSex(request.getParameter("stuSex"));
			student.setStuAddress(request.getParameter("stuAddress"));
			student.setStuAge(Integer.parseInt(request.getParameter("stuAge")));
			student.setStuNo(request.getParameter("stuNo"));
			studentimpl.updateStuent(student);
			this.getServletContext().setAttribute("students", studentimpl.queryStudent(""));
			response.sendRedirect("/StudentMS2/logined/student/queryStudent.jsp");
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
