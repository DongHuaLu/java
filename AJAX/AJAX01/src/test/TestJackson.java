package test;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.Test;

import com.dolph.model.Person;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJackson {

	@Test
	public void test01(){
		StringWriter out=new StringWriter();
		JsonGenerator jg=null;
		try {
			//1.创建JsonFactory
			JsonFactory jf=new JsonFactory();
			//2.创建JsonGenerator
			jg=jf.createGenerator(out);
			Person p=new Person(1, 12, "张三");
			//3.创建ObjectMapper
			ObjectMapper mapper=new ObjectMapper();
			//4.用mapper输出对象(输出流,对象)
			mapper.writeValue(out, p);
			System.out.println(out.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(jg!=null)
				try {
					jg.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	@Test
	public void test02(){
		try {
			String json = "{\"age\":12,\"id\":1,\"name\":\"张三\"}";
			ObjectMapper mapper=new ObjectMapper();
			Person p=mapper.readValue(json, Person.class);
			System.out.println(p.getId()+","+p.getName());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
