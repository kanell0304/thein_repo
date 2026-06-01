package com.gjl.klass;

public class Calc {
	
	int num1;
	int num2;
	
	public Calc(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public double plus(double num1, double num2) {
		return num1 + num2;
	}
	
	public double subtraction(double num1, double num2) {
		return num1 - num2;
	}
	
	public double multiply(double num1, double num2) {
		return num1 * num2;
	}
	
	public double divide(double num1, double num2) {
		return num1 / num2;
	}
	
	public double modulo(double num1, double num2) {
		return num1 % num2;
	}

}
