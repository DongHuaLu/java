/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.Dolph.web.struts.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

/** 
 * MyEclipse Struts
 * Creation date: 03-04-2013
 * 
 * XDoclet definition:
 * @struts.form name="sendMessageForm"
 */
public class SendMessageForm extends ActionForm {
	private String sendfrom;
	private String sendto;
	private String messagehead;
	private String messagetext;
	private FormFile myfile;
	
	
	public String getSendfrom() {
		return sendfrom;
	}
	public void setSendfrom(String sendfrom) {
		this.sendfrom = sendfrom;
	}
	public String getSendto() {
		return sendto;
	}
	public void setSendto(String sendto) {
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
	public FormFile getMyfile() {
		return myfile;
	}
	public void setMyfile(FormFile myfile) {
		this.myfile = myfile;
	}
	
	
	
}