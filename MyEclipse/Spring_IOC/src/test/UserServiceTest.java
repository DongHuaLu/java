package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import services.UserService;
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

}
