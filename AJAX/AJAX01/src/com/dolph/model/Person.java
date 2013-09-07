package com.dolph.model;

public class Person {
	private int age;
	private int id;
	private String name;
	
	public Person() {
	}
	
	public Person(int id,int age,String name){
		super();
		this.id=id;
		this.age=age;
		this.name=name;
	}
	
	public int getAge() {
		return age;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}

}
