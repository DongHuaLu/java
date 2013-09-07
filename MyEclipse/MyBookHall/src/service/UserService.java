package service;
import domain.User;
import DB.SQLHelper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;


public class UserService {

	public User checkUser(String username){
		User user=new User();
		String sql="SELECT * FROM USERS WHERE UNAME=?";
		String [] parameters={username};
		SQLHelper sqlhelper=new SQLHelper();
		ResultSet rs=sqlhelper.executeQuery(sql, parameters);
		try {
			while(rs.next()){
				user.setId(rs.getInt("USERID"));
				user.setPassword(rs.getString("UPASSWORD"));
				user.setTel(rs.getString("TEL"));
				user.setEmail(rs.getString("EMAIL"));
				user.setGrade(rs.getInt("GRADE"));
				user.setUsername(username);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			sqlhelper.close(sqlhelper.getRs(),sqlhelper.getPre(),sqlhelper.getCon());
		}
		return user;
	}
	
	
	
	

	

}
