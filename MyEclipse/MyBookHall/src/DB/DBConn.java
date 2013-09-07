package DB;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBConn {
	private String username;
	private String password;
	private String host;
	private String port;
	private String dbname;
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private String geturl(){
		return "jdbc:oracle:thin:@"+host+":"+port+":"+dbname;
	}
	
	public static void main(String[] args) {
		DBConn dc=new DBConn();
		dc.getConnection();
	}
	
	public Connection getConnection(){
		Properties pp=new Properties();
		FileInputStream fis=null;
		Connection con=null;
		try {
			fis=new FileInputStream("f:\\dbInfo.properties");
			pp.load(fis);
			username=(String) (pp.get("username"));
			password=(String) (pp.get("password"));
			host=(String) (pp.get("host"));
			port=(String) (pp.get("port"));
			dbname=(String) (pp.get("datebaseName"));
			con=DriverManager.getConnection(this.geturl(), username, password);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
