package services;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.UserDAO;
import domain.User;
@Component("userService")
public class UserService {
	
	private UserDAO userDAO;
	
	public void add(User user){
		userDAO.update(user);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	@Resource(name="userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
