package test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dolph.aop.Aop;
import com.dolph.domain.User;
import com.dolph.services.UserService;


public class UserServiceTest {

	@Test
	public void testAdd() {
		BeanFactory bf= new ClassPathXmlApplicationContext(
				"beens.xml");

		UserService userService = (UserService) bf.getBean("userService");
		User user = new User();
		user.setUsername("123");
		userService.add(user);
	}

}
