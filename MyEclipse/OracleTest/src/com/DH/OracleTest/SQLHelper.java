package com.DH.OracleTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class SQLHelper {
	
	private static Connection con=null;
	private static PreparedStatement pre=null;
	private static ResultSet rs=null;
	
	private static String username=null;
	private static String password=null;
	private static String driver="oracle.jdbc.driver.OracleDriver";
	private static String hostName=null;
	private static String port=null;
	private static String datebaseName=null;
	private static String url=null;
	
	static{		
		try {
			Class.forName(driver);
			Properties pp=new Properties();
			FileInputStream fis=null;
			
			try {
				fis=new FileInputStream("dbInfo.properties");
				try {
					pp.load(fis);
					username=(String) pp.get("username");
					password=(String) pp.get("password");
					hostName=(String) pp.get("hostName");
					datebaseName=(String) pp.get("datebaseName");
					url="jdbc:oracle:thin:@"+hostName+":"+port+":"+datebaseName;
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}finally{
				try {
					if(fis!=null){
						fis.close();
					}
					} catch (IOException e) {
					e.printStackTrace();
				}
				fis=null;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ResultSet executeQuery(String sql,String [] parameter){
		try {
			con=DriverManager.getConnection(url,username,password);
			
			pre=con.prepareStatement(sql);
			if (parameter!=null){
				for (int i=0;i<parameter.length;i++){
					pre.setString(i+1,parameter[i]);
				}			
			}
			rs=pre.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public static void executeUpdate(String [] sql,String [][] parameter){
		try {
			con=DriverManager.getConnection(url,username,password);
			con.setAutoCommit(false);
			for (int j=0;j<sql.length;j++){
				pre=con.prepareStatement(sql[j]);
				if(parameter[j]!=null){
					//if(j==1){int s=3/0;}
					for (int i=0;i<parameter[j].length;i++){
						pre.setString(i+1, parameter[j][i]);
					}			
				}
				
				pre.executeUpdate();
				pre.close();
			}
			con.commit();

		
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}finally{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}			
		}
		
	}
	
	public static void close(Statement pre,Connection con){
		if(pre!=null){
			try {
				pre.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			pre=null;
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			con=null;
		}
	}
	
	public static void close(ResultSet rs,Statement pre,Connection con){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs=null;
		}
		if (pre!=null){
			try {
				pre.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			pre=null;
		}
		if (con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			con=null;
	}
	}
	
	public static Connection getCon() {
		return con;
	}

	public static PreparedStatement getPre() {
		return pre;
	}
}
