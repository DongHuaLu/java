package ser;

import impl.Marksimpl;
import impl.Studentimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Marks;
import pojo.Student;

public class Marksser extends HttpServlet {
	
	Marksimpl marksimpl=new Marksimpl();

	/**
	 * Constructor of the object.
	 */
	public Marksser() {
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
		
			
		if(status.equals("saveMarks")){
			Marks marks=new Marks();
			marks.setExamNo(request.getParameter("examNo"));
			marks.setStuNo(request.getParameter("stuNo"));
			marks.setWrittenExam(Integer.parseInt(request.getParameter("writtenExam")));
			marks.setLabExam(Integer.parseInt(request.getParameter("labExam")));
			marksimpl.saveMarks(marks);
			response.sendRedirect("/StudentMS2/logined/marks/queryMarks.jsp");
		}
		
		if(status.equals("queryMarks")){
			String keyword=request.getParameter("keyword");
			request.getSession().setAttribute("keyword", keyword);
			request.getSession().setAttribute("markstotalPage",marksimpl.cluPage(keyword)) ;
			List<Marks> marks=marksimpl.queryMarks(keyword,1);
			request.setAttribute("marks", marks);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/logined/marks/queryMarks.jsp");
			dispatcher.forward(request, response);	
		}
		
		if(status.equals("splitPage")){
			String keyword=(String) request.getSession().getAttribute("keyword");
			int markscurrentPage=Integer.parseInt(request.getParameter("markscurrentPage"));
			request.getSession().setAttribute("markscurrentPage", markscurrentPage);
			List<Marks> marks=marksimpl.queryMarks(keyword, markscurrentPage);
			request.setAttribute("marks", marks);
			request.getRequestDispatcher("/logined/marks/queryMarks.jsp").forward(request, response);
		}
		
		if(status.equals("updateMarks")){
			Marks marks=new Marks();
			marks.setExamNo(request.getParameter("examNo"));
			marks.setLabExam(Integer.parseInt(request.getParameter("labExam")));
			marks.setWrittenExam(Integer.parseInt(request.getParameter("writtenExam")));
			marks.setStuNo(request.getParameter("stuNo"));
			marksimpl.updateMarks(marks);
			response.sendRedirect("/StudentMS2/logined/marks/queryMarks.jsp");
		}
		
		if(status.equals("deleteMarks")){
			String examNo=request.getParameter("examNo");
			marksimpl.deleteMarks(examNo);
			List<Marks> marks=marksimpl.queryMarks(request.getSession().getAttribute("keyword").toString());
			request.setAttribute("marks", marks);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/logined/marks/queryMarks.jsp");
			dispatcher.forward(request, response);
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
