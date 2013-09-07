package com.dolph.many2one.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@SequenceGenerator(name="personseq",sequenceName="person_seq")
@Entity
public class Person {
	
	private int id;	
	private String name;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="personseq")
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
}
