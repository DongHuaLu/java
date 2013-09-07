package test;

import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import services.UserService;
import Interceptor.LogInceptor;
import dao.UserDAO;
import dao.daoimpl.UserDAOimpl;
import domain.User;

public class UserServiceTest {
	
	@Test
	public void testAdd(){
		ApplicationContext appcon=new ClassPathXmlApplicationContext("beens.xml");
		
		UserService userService=(UserService)appcon.getBean("userService");
		
		User user=new User();
		user.setUsername("123");
		userService.add(user);
	}
	
	@Test
	public void testProxy(){
		LogInceptor li=new LogInceptor();
		UserDAO userDAO=new UserDAOimpl();
		li.setTarget(userDAO);
		UserDAO userDAOProxy=(UserDAO)Proxy.newProxyInstance(userDAO.getClass().getClassLoader(),UserDAO.class.getClass().getInterfaces() ,li);
		User user=new User();
		user.setUsername("123");
		userDAOProxy.update(user);
	}
	
	

}
