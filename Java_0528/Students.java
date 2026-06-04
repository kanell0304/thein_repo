package com.gjl;

import java.util.ArrayList;

public class Students {
	
	private String st_name;
	private int age = 20;
	private String address = "서울특별시";
	
	public String getSt_name() {
		return st_name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void displayInfo() {
		System.out.println("st_name: " + st_name + ", age: " + age + ", address: " + address);
	}
	
	public Students(String st_name) {
		this.st_name = st_name;
	}
	
	public Students(String st_name, int age) {
		this.st_name = st_name;
		this.age = age;
	}
	
	public Students(String st_name, int age, String address) {
		this.st_name = st_name;
		this.age = age;
		this.address = address;
	}
}
