package com.dolph.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dolph.domain.User;
import com.dolph.dbutil.*;


public class RegisterService {
	
	public Boolean regiser(User user){
		String sql="insert into users (UNAME,UPASSWORD,EMAIL,TEL,GRADE) values(?,?,?,?,?)";
		String [] parameters={user.getUsername(),user.getPassword(),user.getEmail(),user.getTel(),user.getGrade()+""};
		SQLHelper sqlHelper=new SQLHelper();
		sqlHelper.executeUpdate(sql, parameters);
		return true;
		
	}
	
	public User queryByUsername(String username){
		String sql="select * from users where uname=?";
		String [] parameters={username};
		SQLHelper sqlHelper=new SQLHelper();
		User user=new User();
		ResultSet rs=sqlHelper.executeQuery(sql, parameters);
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
			sqlHelper.close(sqlHelper.getRs(),sqlHelper.getPre(),sqlHelper.getCon());
		}
		return user;		
	}

}
