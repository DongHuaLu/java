package service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.SQLHelper;

import domain.Book;

public class BookService {
	
	public Book getBookById(String id){
		Book book=new Book();
		String sql="SELECT * FROM BOOKS WHERE BOOKID=?";
		String [] parameters={id};
		SQLHelper sqlHelper=new SQLHelper();
		ResultSet rs=sqlHelper.executeQuery(sql, parameters);
		try {
			while(rs.next()){
				book.setBookId(rs.getInt("BOOKID"));
				book.setBookName(rs.getString("BOOKNAME"));
				book.setPublishhouse(rs.getString("PUBLISHHOUSE"));
				book.setAutor(rs.getString("AUTHOR"));
				book.setPrice(rs.getInt("PRICE"));
				book.setNumber(rs.getInt("NUMS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
		
		
	}
	
	public List<Book> getAllBooks(){
		ArrayList<Book> books=new ArrayList();
		String sql="SELECT * FROM BOOKS";
		String [] parameters=null;
		SQLHelper sqlHelper=new SQLHelper();
		ResultSet rs=sqlHelper.executeQuery(sql, parameters);
		try {
			while(rs.next()){
				Book book=new Book();
				book.setBookId(rs.getInt("BOOKID"));
				book.setBookName(rs.getString("BOOKNAME"));
				book.setPublishhouse(rs.getString("PUBLISHHOUSE"));
				book.setAutor(rs.getString("AUTHOR"));
				book.setPrice(rs.getInt("PRICE"));
				book.setNumber(rs.getInt("NUMS"));
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			sqlHelper.close(rs, sqlHelper.getPre(), sqlHelper.getCon());
		}
		return books;
	
		
	}

}
