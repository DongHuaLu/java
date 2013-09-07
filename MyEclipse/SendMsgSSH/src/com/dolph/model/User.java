package com.dolph.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public class User {
	private Set<DeleteMessage> deleteMessages = new HashSet<DeleteMessage>();
	private Group group;
	private int id;
	private String password;
	private Set<ReceiveMessage> receiveMessages = new HashSet<ReceiveMessage>();
	private Set<SendMessage> sendmessgaes = new HashSet<SendMessage>();
	private String username;

	@OneToMany(mappedBy="owner")
	public Set<DeleteMessage> getDeleteMessages() {
		return deleteMessages;
	}

	@ManyToOne
	@JoinColumn(name = "groupid")
	public Group getGroup() {
		return group;
	}

	@Id
	@GeneratedValue(generator = "userseq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "userseq", sequenceName = "user_seq")
	public int getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	@OneToMany(mappedBy = "receiver")
	public Set<ReceiveMessage> getReceiveMessages() {
		return receiveMessages;
	}

	@OneToMany(mappedBy = "sender")
	public Set<SendMessage> getSendmessgaes() {
		return sendmessgaes;
	}

	@Column(unique = true, nullable = false)
	public String getUsername() {
		return username;
	}

	public void setDeleteMessages(Set<DeleteMessage> deleteMessages) {
		this.deleteMessages = deleteMessages;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setReceiveMessages(Set<ReceiveMessage> receiveMessages) {
		this.receiveMessages = receiveMessages;
	}

	public void setSendmessgaes(Set<SendMessage> sendmessgaes) {
		this.sendmessgaes = sendmessgaes;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
