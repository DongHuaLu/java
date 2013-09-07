package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConn;

import pojo.Marks;
import pojo.Student;

public class Marksimpl {
	
	private int pagesize=10;
	
	public void saveMarks(Marks marks){
		Connection con=null;
		PreparedStatement pre=null;
		DBConn conns=new DBConn();
		con=conns.getConnection();
		try {
			pre=con.prepareStatement("INSERT INTO stuMarks " +
					"(examNo,stuNo,writtenExam,labExam) VALUES (?,?,?,?) ");
			pre.setString(1, marks.getExamNo());
			pre.setString(2, marks.getStuNo());
			pre.setInt(3, marks.getWrittenExam());
			pre.setInt(4, marks.getLabExam());
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

	public List<Marks> queryMarks(String keyword,int currentPage){
		Connection con=null;
		PreparedStatement pre=null;
		DBConn conns=new DBConn();
		con=conns.getConnection();
		ArrayList<Marks> marks=new ArrayList<Marks>();
		try {
			pre=con.prepareStatement("SELECT TOP (?) * FROM stuMarks m LEFT JOIN stuInfo i ON m.stuNo=i.stuNo " +
					"WHERE (m.examNo LIKE ? OR m.stuNo LIKE ? )" +
					"AND examNo NOT IN (SELECT TOP ((?-1)*?) examNo FROM stuMarks WHERE m.examNo LIKE ? OR m.stuNo LIKE ?)");
			pre.setInt(1, pagesize);
			pre.setString(2, "%"+keyword+"%");
			pre.setString(3, "%"+keyword+"%");
			pre.setInt(4, currentPage);
			pre.setInt(5, pagesize);
			pre.setString(6, "%"+keyword+"%");
			pre.setString(7, "%"+keyword+"%");
			ResultSet rs=pre.executeQuery();
			while(rs.next()){
				Marks markstemp=new Marks();
				markstemp.setStuNo(rs.getString("stuNo"));
				markstemp.setExamNo(rs.getString("examNo"));
				markstemp.setWrittenExam(rs.getInt("writtenExam"));
				markstemp.setLabExam(rs.getInt("labExam"));
				Student studenttemp=new Student();
				studenttemp.setStuName(rs.getString("stuName"));
				studenttemp.setStuSeat(rs.getInt("stuSeat"));
				studenttemp.setStuAddress(rs.getString("stuAddress"));
				studenttemp.setStuSex(rs.getString("stuSex"));
				markstemp.setStudent(studenttemp);
				marks.add(markstemp);
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
		return marks;
	}
	
	public List<Marks> queryMarks(String keyword){
		Connection con=null;
		PreparedStatement pre=null;
		DBConn conns=new DBConn();
		con=conns.getConnection();
		ArrayList<Marks> marks=new ArrayList<Marks>();
		try {
			pre=con.prepareStatement("SELECT * FROM stuMarks m LEFT OUTER JOIN stuInfo i ON m.stuNo=i.stuNo WHERE m.examNO LIKE ? OR m.stuNo LIKE ?");
			pre.setString(1, "%"+keyword+"%");
			pre.setString(2, "%"+keyword+"%");
			ResultSet rs=pre.executeQuery();
			while(rs.next()){
				Marks markstemp=new Marks();
				markstemp.setStuNo(rs.getString("stuNo"));
				markstemp.setExamNo(rs.getString("examNo"));
				markstemp.setWrittenExam(rs.getInt("writtenExam"));
				markstemp.setLabExam(rs.getInt("labExam"));
				Student studenttemp=new Student();
				studenttemp.setStuName(rs.getString("stuName"));
				studenttemp.setStuSeat(rs.getInt("stuSeat"));
				studenttemp.setStuAddress(rs.getString("stuAddress"));
				studenttemp.setStuSex(rs.getString("stuSex"));
				markstemp.setStudent(studenttemp);
				marks.add(markstemp);
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
		return marks;
	}
	
	public void updateMarks(Marks marks){
		Connection con=null;
		PreparedStatement pre=null;
		DBConn conns=new DBConn();
		con=conns.getConnection();
		try {
			pre=con.prepareStatement("UPDATE stuMarks SET stuNo=?,writtenExam=?,labExam=? WHERE examNo=?");
			pre.setString(1, marks.getStuNo());
			pre.setInt(2, marks.getWrittenExam());
			pre.setInt(3, marks.getLabExam());
			pre.setString(4, marks.getExamNo());
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
		Connection con=null;
		PreparedStatement pre=null;
		DBConn conns=new DBConn();
		con=conns.getConnection();
		int totalPage=0;
		ResultSet rs=null;
		try {
			pre=con.prepareStatement("SELECT COUNT(*) total FROM stuMarks WHERE examNo LIKE ? OR stuNo LIKE ?");
			pre.setString(1, "%"+keyword+"%");
			pre.setString(2, "%"+keyword+"%");
			rs=pre.executeQuery();
			if(rs.next()){
				int total=rs.getInt("total");
				totalPage=total%pagesize==0 ? total/pagesize :(total/pagesize)+1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalPage;
	}
	
	public void deleteMarks(String examNo){
		Connection con=null;
		PreparedStatement pre=null;
		DBConn conns=new DBConn();
		con=conns.getConnection();
		try {
			pre=con.prepareStatement("DELETE FROM stuMarks WHERE examNo=?");
			pre.setString(1, examNo);
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
	
	
	
}
