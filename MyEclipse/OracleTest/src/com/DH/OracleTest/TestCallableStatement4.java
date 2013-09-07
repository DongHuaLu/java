package com.DH.OracleTest;
import java.sql.*;

public class TestCallableStatement4 {

//	--输入表名,每页显示记录数,当前页,排序字段(deptno降序),
//	--返回总记录数,总页数,返回的结果集
//
//	procedure过程
//	
//	create or replace procedure pro0(v_in_tablename in varchar2,v_in_pagesize in number,v_in_currentpage in number,v_in_ordkeyword in varchar2,
//	v_out_returnwholenumber out number,v_out_wholepage out number,v_out_cursor out pack1.mycursor) is
//	v_sql varchar2(2000);
//	v_start number;
//	v_end number;
//	begin
//	  --select count(*) into v_out_returnwholenumber from v_in_tablename;
//	  --select (count(*)/v_in_pagesize) into v_out_wholepage from v_in_tablename;
//	  
//	  v_start:=((v_in_currentpage-1)*v_in_pagesize)+1;
//	  v_end:=(v_in_currentpage*v_in_pagesize);
//	  v_sql:='select A2.* from 
//	              (select A1.*,ROWNUM rn from 
//	                 (select * from '||v_in_tablename||' order by ' ||v_in_ordkeyword||') A1 
//	               where rownum<='||v_end ||') A2
//	          where rn>='||v_start;
//	     
//	     open v_out_cursor for v_sql;
//	   v_sql:='select count(*) from '|| v_in_tablename;
//	   execute IMMEDIATE v_sql into v_out_returnwholenumber;
//	   if (v_out_returnwholenumber mod v_in_pagesize ) = 0 then
//	     v_out_wholepage:=v_out_returnwholenumber/v_in_pagesize;
//	   else
//	     v_out_wholepage:=(v_out_returnwholenumber/v_in_pagesize)+1;
//	   end if;
//	end;
	
	
	public static void main(String[] args) {
		String [] parameter={"emp","4","1","deptno"};
		executeCall(parameter);
		
	}
	
	public static void executeCall(String[] parameter){
		Connection con=null;
		CallableStatement cs=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.208:1523:OracleDolph1", "scott", "tiger");
			cs=con.prepareCall("CALL PRO0(?,?,?,?,?,?,?)");
			if(parameter!=null){
				for (int i=0;i<parameter.length;i++){
					cs.setString(i+1,parameter[i]);
				}
			}
			cs.registerOutParameter(5,oracle.jdbc.OracleTypes.NUMBER);
			cs.registerOutParameter(6,oracle.jdbc.OracleTypes.NUMBER);
			cs.registerOutParameter(7,oracle.jdbc.OracleTypes.CURSOR);
			cs.execute();
			rs=(ResultSet) cs.getObject(7);
			while (rs.next()){
				System.out.println(rs.getString("ename")+"  "+rs.getString("deptno"));
			}
			System.out.println("总条数="+cs.getInt(5)+"总页数="+cs.getInt(6));
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
