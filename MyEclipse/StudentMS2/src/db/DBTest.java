package db;

import java.sql.*;

public class DBTest {

	
	public static void main(String[] args) {
		DBConn dc=new DBConn();
		Connection con=null;
		PreparedStatement pp=null; 
		ResultSet rs=null ;
		con=dc.getConnection();
		
		try {
			System.out.println(con);
			pp=con.prepareStatement("select * from user1");
			rs=pp.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("uname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
