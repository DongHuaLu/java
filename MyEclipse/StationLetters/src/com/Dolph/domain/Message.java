package com.Dolph.domain;

import java.sql.Date;

public class Message {
	private int messageid;
	private int sendfrom;
	private int sendto;
	private String messagehead;
	private String messagetext;
	private String filename;
	private String fileuuid;
	private Date senddate;
	private String sendfromusername;
	public String getSendfromusername() {
		return sendfromusername;
	}
	public void setSendfromusername(String sendfromusername) {
		this.sendfromusername = sendfromusername;
	}
	public int getMessageid() {
		return messageid;
	}
	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}
	public int getSendfrom() {
		return sendfrom;
	}
	public void setSendfrom(int sendfrom) {
		this.sendfrom = sendfrom;
	}
	public int getSendto() {
		return sendto;
	}
	public void setSendto(int sendto) {
		this.sendto = sendto;
	}
	public String getMessagehead() {
		return messagehead;
	}
	public void setMessagehead(String messagehead) {
		this.messagehead = messagehead;
	}
	public String getMessagetext() {
		return messagetext;
	}
	public void setMessagetext(String messagetext) {
		this.messagetext = messagetext;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFileuuid() {
		return fileuuid;
	}
	public void setFileuuid(String fileuuid) {
		this.fileuuid = fileuuid;
	}
	public Date getSenddate() {
		return senddate;
	}
	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}
}
