package com.Dolph.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.Dolph.domain.User;
import com.Dolph.db.*;

public class UserService {

	public boolean register(User user) {
		SQLHelper sqlhelper = new SQLHelper();
		String sql = "insert into users (username,userpassword) values(?,?)";
		String[] parameters = { user.getUsername(), user.getPassword() };
		sqlhelper.executeUpdate(sql, parameters);
		return true;
	}

	public boolean checkUsername(String username) {
		SQLHelper sqlhelper = new SQLHelper();
		String sql = "select * from users where username=?";
		String[] parameters = { username };
		ResultSet rs = null;
		rs = sqlhelper.executeQuery(sql, parameters);
		try {
			while (rs.next()) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sqlhelper.close(rs, sqlhelper.getPre(), sqlhelper.getCon());
		}
		return true;

	}

	public User getUser(User user) {
		String sql = "select * from users where username=?";
		String[] parameters = {user.getUsername()};
		SQLHelper sqlhelper = new SQLHelper();
		ResultSet rs = null;
		rs=sqlhelper.executeQuery(sql, parameters);
		try {
			while (rs.next()) {
				user.setUserid(rs.getInt("userid"));
				user.setPassword(rs.getString("userpassword"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlhelper.close(rs, sqlhelper.getPre(), sqlhelper.getCon());
		}
		return user;

	}
	
	public String getUsername(int userid){
		String sql="select USERNAME from users where userid=?";
		String [] parameters={userid+""};
		SQLHelper sqlhelper=new SQLHelper();
		ResultSet rs=null;
		rs=sqlhelper.executeQuery(sql, parameters);
		String username = null;
		try {
			while(rs.next()){
				username=rs.getString("username");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			sqlhelper.close(rs,sqlhelper.getPre(), sqlhelper.getCon());
		}
		return username;
	
	
	}


}
