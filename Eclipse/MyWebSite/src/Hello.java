
import javax.servlet.http.*;

import java.io.*;

public class Hello extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	 {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	 {
		
		
		try {
			PrintWriter pw=resp.getWriter();
			
			pw.println("<html>");
			pw.println("<body>");
			pw.println("<hl>��¼</hl>");
			pw.println("<from action=?? method=get>");
			pw.println("�û���:<input type=text name=username><br>");
			pw.println("����:<input type=text name=password><br>");
			pw.println("<input type=submit value=�ύ");
			pw.println("</body>");
			pw.println("</html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
