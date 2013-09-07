package com.DH.OracleTest;
import java.sql.*;

public class TestCallableStatement3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] parameter={"7369","222.2"};
		executeCall(parameter);
		
	}
	
	public static void executeCall(String[] parameter){
		Connection con=null;
		CallableStatement cs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.208:1523:OracleDolph1", "scott", "tiger");
			cs=con.prepareCall("CALL PRO1(?,?)");
			if(parameter!=null){
				for (int i=0;i<parameter.length;i++){
					cs.setString(i+1,parameter[i]);
				}
			}
			cs.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(cs, con);
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

}
