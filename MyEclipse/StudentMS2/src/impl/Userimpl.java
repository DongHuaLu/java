package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConn;

import pojo.User;

public class Userimpl {
	/*public User queryuser(String uName,String password){
		Connection con=null;
		PreparedStatement pre=null;
		DBConn conns=new DBConn();
		con=conns.getConnection();
		ResultSet rs=null;
		User user=new User();
		try {						//SELECT * FROM user1 where uname=? or 'a'='a' and upassword=? or 'a'='a'
			pre=con.prepareStatement("SELECT * FROM user1 where uname=? and upassword=?");
			pre.setString(1, uName);
			pre.setString(2, password);
			rs=pre.executeQuery();
			while (rs.next()){
				user.setuId(rs.getInt("uid"));
				System.out.println(user.getuId());
				user.setuName(rs.getString("uname"));
				user.setuPassword(rs.getString("upassword"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user;
		
		
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	public User queryuser(String uName){
		Connection con=null;
		PreparedStatement pre=null;
		DBConn conns=new DBConn();
		con=conns.getConnection();
		ResultSet rs=null;
		User user=new User();
		try {
			pre=con.prepareStatement("SELECT * FROM USER1 WHERE uname = ?");
			pre.setString(1, uName);
			System.out.println(uName);
			rs=pre.executeQuery();
			while(rs.next()){
				user.setuId(rs.getInt("UID1"));
				System.out.println(""+user.getuId());
				user.setuName(rs.getString("UNAME"));
				System.out.println(user.getuName());
				user.setuPassword(rs.getString("UPASSWORD"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}				
		return user;
		
	}

}
