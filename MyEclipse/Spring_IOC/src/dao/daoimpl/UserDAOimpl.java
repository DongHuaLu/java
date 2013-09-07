package dao.daoimpl;

import dao.UserDAO;
import domain.User;

public class UserDAOimpl implements UserDAO{
	
	private String test;
	
	@Override
	public void update(User user) {
		System.out.println("User insert...."+user.getUsername()+":"+test);
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

}
