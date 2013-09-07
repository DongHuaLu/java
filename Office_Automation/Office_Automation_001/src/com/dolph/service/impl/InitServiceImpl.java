package com.dolph.service.impl;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import com.dolph.service.InitService;

public class InitServiceImpl implements InitService, BeanFactoryAware {
	private String path;
	private BeanFactory beanFactory;
	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		this.beanFactory=arg0;
	}

	@Override
	public void addIntiData() {
		try {
			Document doc=new SAXReader().read(Thread.currentThread().getContextClassLoader().getResourceAsStream(path));
			Element root=doc.getRootElement();
			String pkg=root.valueOf("@package");
			List<Element> entities=root.selectNodes("entity");
			for(Iterator<Element> iter=entities.iterator();iter.hasNext();){
				Element e=iter.next();
				addEntity(e, pkg, null,null);
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	private void addEntity(Element e,String pkg,Object parent,String callString){
		try {
			String classname=pkg+"."+e.attributeValue("class");
			Object entity=Class.forName(classname).newInstance();
			Iterator iter=e.attributeIterator();
			while(iter.hasNext()){
				Attribute attr=(Attribute) iter.next();
				String propName=attr.getName();
				if(!"class".equals(propName)&&!"call".equals(propName)){
					String propValue=attr.getValue();
					BeanUtils.copyProperty(entity, propName, propValue);
				}
			}
			BeanUtils.copyProperty(entity, "parent", parent);
			String call=e.attributeValue("call");
			if(call!=null){
				callString=call;
			}
			if(callString==null){
				throw new RuntimeException("没有call来创建实体");
			}
			
			String[] callName=callString.split("\\.");
			String serviceName=callName[0];
			String methodName=callName[1];
			Object service=beanFactory.getBean(serviceName);
			for(Method m:service.getClass().getMethods()){
				if(m.getName().equals(methodName)){
					m.invoke(service, entity);
				}
			}
			
			List<Element> subEntities=e.elements();
			for(Iterator<Element> it=subEntities.iterator();it.hasNext();){
				Element subElement=it.next();
				addEntity(subElement, pkg, entity, callString);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void setPath(String path) {
		this.path = path;
	}

}
