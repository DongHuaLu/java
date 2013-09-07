package services;

import org.springframework.beans.factory.annotation.Autowired;

import dao.UserDAO;
import domain.User;

public class UserService {
	
	private UserDAO userDAO;
	
	public void add(User user){
		userDAO.update(user);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
