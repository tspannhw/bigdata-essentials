package com.needforcode.corejava.strings;

public class StringDemo {

	String a = "hello";
	int b = 123;
	
	public static void main(String []args ){
		
		StringDemo obj = new StringDemo();
		System.out.println(obj.a+obj.b); // Non strings are converted to strings automatically.
	}
}
