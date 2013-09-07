package com.dolph.servlet;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.dolph.model.Place;


public class PlaceServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/xml;charset=utf-8");
		String value=request.getParameter("value");
		List<Place> places=getChildren(value);
	}

	public List<Place> getChildren(String value){
		SAXReader reader=new SAXReader();
		Document doc = null;
		try {
			doc = reader.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("Area.xml"));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		//2. 获取根节点
		Element root=doc.getRootElement();
		Iterator<Element> children= root.elementIterator();
		while(children.hasNext()){
			Element e=children.next();
		}
		
		return null;
		
	}
}
