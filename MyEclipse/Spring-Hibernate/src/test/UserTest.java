package test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dolph.domain.User2;
import com.dolph.service.UserService;

public class UserTest {

	@Test
	public void testSave() {
		User2 user = new User2();
		user.setPassword("123");
		user.setUsername("123");

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"beans.xml");

		UserService service = (UserService) ctx.getBean("userService");
		service.addUser(user);
	}

}
