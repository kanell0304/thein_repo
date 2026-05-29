package com.gjl;
import com.gjl.MyClass;

public class ImplClass extends MyClass{
	
	public void print_x() {
		System.out.println(x);		
	}
	
	@Override
	public void printing() {
		System.out.println("Overriding");
	}
	
	public ImplClass(int x) {
		super(x);
	};
	
}
