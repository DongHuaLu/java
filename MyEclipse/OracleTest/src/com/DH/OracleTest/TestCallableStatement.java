package com.DH.OracleTest;
import java.sql.*;

public class TestCallableStatement {

	/**
	 * 1.创建ref cursor类型
	 * create package pack1 is
	 * type mycorser is ref cursor;
	 * end;
	 * 
	 * 2.创建procedure,out一个ref cursor;
	 * create or replace procedure pro1(v_in_deptno in number,v_out_cursor out pack1.mycorser)is
	 * begin
	 *  open v_out_cursor for select * from emp where deptno=v_in_deptno;
	 * end;  
	 */
	public static void main(String[] args) {
		String [] parameter={"20"};
		executeCall(parameter);
		
	}
	
	public static void executeCall(String[] parameter){
		Connection con=null;
		CallableStatement cs=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.208:1523:OracleDolph1", "scott", "tiger");
			cs=con.prepareCall("CALL PRO1(?,?)");
			if(parameter!=null){
				for (int i=0;i<parameter.length;i++){
					cs.setString(i+1,parameter[i]);
				}
			}
			cs.registerOutParameter(2,oracle.jdbc.OracleTypes.CURSOR);
			cs.execute();
			rs=(ResultSet) cs.getObject(2);
			while (rs.next()){
				System.out.println(rs.getString("ename"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rs,cs,con);
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

}
