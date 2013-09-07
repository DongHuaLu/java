package com.dolph.test;

import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;


public class SAXtest {

	@Test
	public void test01(){
		try {
			//1. 加载XML文件
			SAXReader reader=new SAXReader();
			Document doc=reader.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("Area.xml"));
			//2. 获取根节点
			Element root=doc.getRootElement();
			//3. 获得子节点
			getChild(root);

		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	
	public Iterator<Element> getChild(Element parent){
		Iterator<Element> it=parent.elementIterator();
		while(it.hasNext()){
			Element child=it.next();
			getChild(child);
			String nodename=child.getName();
			String name=child.attributeValue("name");
			//String value=child.attributeValue("value");
			//String zs_value=child.attributeValue("zs_value");
			System.out.println(nodename+","+name);
		}
		return null;
	}
	
}
