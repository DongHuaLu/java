package com.dolph.many2one.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;



@SequenceGenerator(name="carseq",sequenceName="car_seq")
@Entity
public class Car {
	private int id;
	private String name;
	private Person person;
	
	@ManyToOne
	@JoinColumn(name="personid")
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="carseq")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
