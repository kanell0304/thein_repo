package com.gjl.klass;

public class MyCar {
	
	int year = 0;
	String carName = "";
	
	public MyCar() {}
	
	public MyCar(int year) {
		this.year = year;
	}
	
	public MyCar(int year, String carName) {
		this.year = year;
		this.carName = carName;
	}

}
