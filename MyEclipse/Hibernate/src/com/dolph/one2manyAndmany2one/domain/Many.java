package com.dolph.one2manyAndmany2one.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Many {
	private int id;
	private String name;
	private One one;
	@Id
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
	@ManyToOne
	@JoinColumn(name="oneid")
	public One getOne() {
		return one;
	}
	public void setOne(One one) {
		this.one = one;
	}

}
