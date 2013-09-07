package com.dolph.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dolph.model.Person;

public class PersonJsonServlet extends HttpServlet {
	Map<Integer,List<Person>> persons=new HashMap<Integer,List<Person>>();

	public PersonJsonServlet() {
		List<Person> ps=new ArrayList<Person>();
		ps.add(new Person(1,12,"张三"));
		ps.add(new Person(2,13,"李四"));
		ps.add(new Person(3,13,"王五"));
		persons.put(1, ps);
		ps=new ArrayList<Person>();
		ps.add(new Person(11,14,"吃的1"));
		ps.add(new Person(12,15,"吃的2"));
		ps.add(new Person(13,16,"吃的3"));
		ps.add(new Person(14,17,"吃的4"));
		persons.put(2, ps);
		ps=new ArrayList<Person>();
		ps.add(new Person(23,213,"德克士1"));
		ps.add(new Person(24,413,"德克士2"));
		ps.add(new Person(25,313,"德克士3"));
		persons.put(3, ps);
		
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		Writer out = response.getWriter();
		int dtd=Integer.parseInt(request.getParameter("dtd"));
		
		List<Person> ps=persons.get(dtd);
		StringBuffer sb=new StringBuffer();
		sb.append("[");
		
		int index=0;
		for(int i=0;i<ps.size();i++){
			if(index==0){
				sb.append("{");
				index++;
			}else{
				sb.append(",{");
			}			
			sb.append("id:"+ps.get(i).getId());
			sb.append(",name:\""+ps.get(i).getName()+"\"");
			sb.append(",age:"+ps.get(i).getAge());
			sb.append("}");
		}
		sb.append("]");
		
		out.write(sb.toString());
		
	}

}





