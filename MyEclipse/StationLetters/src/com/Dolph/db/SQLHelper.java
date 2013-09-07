package com.Dolph.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import com.Dolph.db.DBConn;;

public class SQLHelper {
	private Connection con = null;
	private PreparedStatement pre = null;
	private ResultSet rs = null;
	

	public void executeUpdate(String sql,String[] parameters){
		DBConn dbc=new DBConn();
		con=dbc.getConnection();
		try {
			pre=con.prepareStatement(sql);
			if(parameters !=null){
				for (int i=0;i<parameters.length;i++){
					pre.setString(i+1,parameters[i]);
				}
			pre.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pre, con);
		}
		
	}
	
	
	public ResultSet executeQuery(String sql, String[] parameters) {
	
		DBConn dbc = new DBConn();
		con = dbc.getConnection();
		//ArrayList al = null;
		try {
			pre = con.prepareStatement(sql);
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					pre.setString(i + 1, parameters[i]);
				}
			}
			rs = pre.executeQuery();
						
			/*ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while (rs.next()) {
				Object[] objects = new Object[columnCount];
				for (int i = 0; i < objects.length; i++) {
					objects[i] = rs.getObject(i + 1);
				}
				al.add(objects);
			}*/

		} catch (SQLException e) {
			e.printStackTrace();
		} /*finally {
			this.close(pre, con);

		}*/
		return rs;

	}
	
	private void close(PreparedStatement pre, Connection con){
		if (pre != null)
			try {
				pre.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		pre = null;
		
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		con=null;
	}
	
	public Connection getCon() {
		return con;
	}

	public PreparedStatement getPre() {
		return pre;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void close(ResultSet rs){
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		rs = null;
	}
	

	public void close(ResultSet rs, PreparedStatement pre, Connection con) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		rs = null;

		if (pre != null)
			try {
				pre.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		pre = null;
		
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		con=null;
		
		
	}

}
