package com.dolph.util;

import java.util.Map;
import java.util.Set;

import com.thoughtworks.xstream.XStream;

public class XStreamUtil {
	private static XStreamUtil util;
	private XStreamUtil(){}
	
	public static XStreamUtil getInstacen(){
		if(util==null) util=new XStreamUtil();
		return util;
	}
	
	public String obj2xml(Object obj,Map<String,Class<?>> alias){
		XStream xstream=new XStream();
		Set<String> keys=alias.keySet();
		for(String key:keys){
			xstream.alias(key,alias.get(key));
		}
		return xstream.toXML(obj);		
	}

}
