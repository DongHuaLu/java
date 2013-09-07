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
@Table(name = "t_deletemessage")
public class DeleteMessage {
	private String content;
	private Date deleteTime;
	private int id;
	private User owner;
	private String receiverName;
	private Date receiveTime;
	private String senderName;
	private Date sendTime;
	private String title;

	public String getContent() {
		return content;
	}

	public Date getDeleteTime() {
		return deleteTime;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "messageseq")
	@SequenceGenerator(name = "messageseq", sequenceName = "message_seq")
	public int getId() {
		return id;
	}
	@ManyToOne
	@JoinColumn(name="ownerid")
	public User getOwner() {
		return owner;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public Date getReceiveTime() {
		return receiveTime;
	}

	public String getSenderName() {
		return senderName;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public String getTitle() {
		return title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
