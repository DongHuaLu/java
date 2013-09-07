package com.dolph.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="t_receivemessage")
public class ReceiveMessage {
	private int id;
	private String title;
	private String content;
	private Date receiveTime;
	private String senderName;
	private boolean isread;
	private User Receiver;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="messageseq")
	@SequenceGenerator(name="messageseq",sequenceName="message_seq")
	public int getId() {
		return id;
	}
	
	@ManyToOne
	@JoinColumn(name="receiverid")
	public User getReceiver() {
		return Receiver;
	}
	public void setReceiver(User receiver) {
		Receiver = receiver;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public boolean isIsread() {
		return isread;
	}
	public void setIsread(boolean isread) {
		this.isread = isread;
	}

}
