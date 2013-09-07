package com.DH.OracleTest;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.DH.OracleTest.SQLHelper;

public class SQLCL {

	
	public static void main(String[] args) {
		String [] sql={"insert into emp (empno,ename) values (9999,?)","insert into emp (empno,ename) values (8888,?)"};
		String [][] parameter={{"fewfewg"},{"gewtwetew"}};
		SQLHelper.executeUpdate(sql,parameter);
		
	}

}
