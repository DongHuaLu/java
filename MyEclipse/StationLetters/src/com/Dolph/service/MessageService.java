package com.Dolph.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Dolph.db.SQLHelper;
import com.Dolph.domain.Message;
import com.Dolph.domain.User;

public class MessageService {
	
	public boolean addMessage(Message message){
		SQLHelper sqlhelper=new SQLHelper();
		String sql="insert into message (SENDDATE,SENDFROM,SENDTO,MESSAGEHEAD,MESSAGETEXT,FILENAME,FILEUUID)values(sysdate,?,?,?,?,?,?)";
		String [] parameters={message.getSendfrom()+"",message.getSendto()+"",message.getMessagehead(),message.getMessagetext(),message.getFilename(),message.getFileuuid()};
		sqlhelper.executeUpdate(sql, parameters);		
		return true;
		
	}

	public ArrayList showMessage(User user){		
		String sql="select * from (select username,message.* from message left join users on  users.userid=message.sendto)where sendto=?";
		String [] parameters={user.getUserid()+""};
		SQLHelper sqlhelper=new SQLHelper();
		ResultSet rs=null;		
		rs=sqlhelper.executeQuery(sql, parameters);
		ArrayList<Message> al=new ArrayList<Message>();
		try {
			while(rs.next()){
				Message message=new Message();
				message.setFilename(rs.getString("FILENAME"));
				message.setFileuuid(rs.getString("FILEUUID"));
				message.setMessagehead(rs.getString("MESSAGEHEAD"));
				message.setMessagetext(rs.getString("MESSAGETEXT"));
				message.setSenddate(rs.getDate("SENDDATE"));
				message.setSendfrom(rs.getInt("SENDFROM"));
				message.setSendfromusername(rs.getString("USERNAME"));
				al.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			sqlhelper.close(rs, sqlhelper.getPre(),sqlhelper.getCon());
		}
		return al;
		
	}

	
}
