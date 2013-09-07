package com.dolph.utils;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.sdicons.json.mapper.JSONMapper;
import com.sdicons.json.mapper.MapperException;

public class JSONUtils {
	public static void toJSON(Object o){
		try {
			String s=JSONMapper.toJSON(o).render(false);
			System.out.println(s);
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().print(s);
		} catch (MapperException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
