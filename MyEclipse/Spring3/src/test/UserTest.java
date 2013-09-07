package test;

import org.junit.Test;

import com.dolph.model.User;
import com.dolph.service.UserService;

public class UserTest {
	
	@Test
	public void userDAOTest(){
		UserService us=new UserService();
		User user=new User();
		user.setUsername("d");
		us.addUser(user);
	}

}
