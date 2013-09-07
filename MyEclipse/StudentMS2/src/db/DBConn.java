package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DBConn {
	
		
		private String username="scott";
		private String password="tiger";
		private String driver="oracle.jdbc.driver.OracleDriver";
		private String hostName="192.168.1.208";
		private String port="1523";
		private String datebaseName="OracleDolph1";
		private String url=null;


	
	private String getUrl(){
		return "jdbc:oracle:thin:@"+hostName+":"+port+":"+datebaseName;
	}
	
	public DBConn(){
		
		
		
		/*Properties pp=new Properties();
		//FileInputStream fis=null;
		try {
			//fis=new FileInputStream("dbInfo.properties");
			username=(String) pp.get("username");
			password=(String) pp.get("password");
			hostName=(String) pp.get("hostName");
			port=(String) pp.get("port");
			datebaseName=(String) pp.get("datebaseName");
			url="jdbc:oracle:thin:@"+hostName+":"+port+":"+datebaseName;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}*/
		
		
		
	}
	

	

	
	/* ��ȡConncetion���󲢷��� */
	
	public Connection getConnection() {
		
		Connection con=null;
		
        try {
            	Class.forName(driver);     // ����Jdbc��������
            	
            	con = DriverManager.getConnection(this.getUrl(),username,password);
            	
        } catch (Exception e) {
            
        	e.printStackTrace();
            
        	System.out.println("getConnection()�ڲ����ٴ���:"+ e.getMessage());
        }
        
        return con;
        
	}
}