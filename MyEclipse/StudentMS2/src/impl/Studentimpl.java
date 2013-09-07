package impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConn;
import pojo.Student;

public class Studentimpl {
		
	private int pagesize=10;
	
	public void saveStudent(Student student){
		Connection con=null;
		PreparedStatement pre=null;
		DBConn conns=new DBConn();
		con=conns.getConnection();
		try {
			pre=con.prepareStatement("INSERT INTO STUINFO (STUNAME,STUNO,STUSEX,STUAGE,STUSEAT) VALUES (?,?,?,?,?)");
			pre.setString(1, student.getStuName());
			pre.setString(2, student.getStuNo());
			pre.setString(3, student.getStuSex());
			pre.setInt(4, student.getStuAge());
			pre.setString(5, student.getStuAddress());
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}

	
	public List<Student> queryStudent(String keyword,int currentPage){
		ArrayList<Student> students=new ArrayList<Student>();
		Connection con=null;
		PreparedStatement pre=null;
		DBConn conns=new DBConn();
		ResultSet rs=null;
		con=conns.getConnection();
		try {
			pre=con.prepareStatement("SELECT * FROM (SELECT A.*, ROWNUM RN FROM (SELECT * FROM stuInfo where stuName like ? ) A WHERE ROWNUM <=?)WHERE RN >=?");
			pre.setString(1, "%"/*+keyword+"%"*/);
			pre.setInt(2, currentPage*pagesize);
			pre.setInt(3, ((currentPage-1)*pagesize)+1);
			rs=pre.executeQuery();
			while(rs.next()){
				Student studenttemp=new Student();
				studenttemp.setStuAddress(rs.getString("stuAddress"));
				studenttemp.setStuAge(rs.getInt("stuAge"));
				studenttemp.setStuName(rs.getString("stuName"));
				studenttemp.setStuNo(rs.getString("stuNo"));
				studenttemp.setStuSex(rs.getString("stuSex"));
				studenttemp.setStuSeat(rs.getInt("stuSeat"));
				students.add(studenttemp);				
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
		return students;
		
	}
	
	
	public List<Student> queryStudent(String keyword){
		ArrayList<Student> students=new ArrayList<Student>();
		Connection con=null;
		PreparedStatement pre=null;
		ResultSet rs=null;
		DBConn conns=new DBConn();
		con=conns.getConnection();
		try {
			pre=con.prepareStatement("SELECT * FROM stuInfo WHERE stuName like ?");
			pre.setString(1, "%"+keyword+"%");
			rs=pre.executeQuery();
			while (rs.next()){
				Student studenttemp=new Student();
				studenttemp.setStuAddress(rs.getString("stuAddress"));
				studenttemp.setStuAge(rs.getInt("stuAge"));
				studenttemp.setStuName(rs.getString("stuName"));
				studenttemp.setStuNo(rs.getString("stuNo"));
				studenttemp.setStuSex(rs.getString("stuSex"));
				studenttemp.setStuSeat(rs.getInt("stuSeat"));
				students.add(studenttemp);
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
		
		
		return students;
	}

	public void deleteStudent(int stuSeat){
		Connection con=null;
		PreparedStatement pre=null;
		DBConn conns=new DBConn();
		con=conns.getConnection();
		try {
			pre=con.prepareStatement("DELETE FROM stuInfo WHERE stuSeat=?");
			pre.setInt(1, stuSeat);
			pre.executeUpdate();
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
		
		
	}

	public void updateStuent(Student student){

	Connection con=null;
	PreparedStatement pre=null;
	DBConn conns=new DBConn();
	con=conns.getConnection();
	try {
		pre=con.prepareStatement("UPDATE stuInfo SET stuName=?,stuNo=?,stuSex=?,stuAge=?,stuAddress=? WHERE stuSeat=?");
		pre.setString(1, student.getStuName());
		pre.setString(2, student.getStuNo());
		pre.setString(3, student.getStuSex());
		pre.setInt(4, student.getStuAge());
		pre.setString(5, student.getStuAddress());
		pre.setInt(6, student.getStuSeat());
		pre.executeUpdate();
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
		
	}

	public int cluPage(String keyword){
		int totalPage=0;
		Connection con=null;
		PreparedStatement pre=null;
		DBConn conns=new DBConn();
		ResultSet rs=null;
		con=conns.getConnection();
		try {
			pre=con.prepareStatement("SELECT COUNT(*) total FROM stuInfo WHERE stuName LIKE ?");
			pre.setString(1, "%"+keyword+"%");
			rs=pre.executeQuery();
			if(rs.next()){
				int total=rs.getInt("total");
			 	totalPage=total%pagesize==0 ? total/pagesize : (total/pagesize)+1;
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
		return totalPage;
		
	}
	

}