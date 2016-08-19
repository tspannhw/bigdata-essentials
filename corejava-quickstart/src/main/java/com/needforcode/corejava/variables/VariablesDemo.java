package com.needforcode.corejava.variables;

public class VariablesDemo {
	
	int i; // instance variables
	static int j; // static variables
	
	int method1(){
		int k=1; // local variables, should initialize
		return k;
	}

	public static void main(String []args){
		
		VariablesDemo obj = new VariablesDemo();
		System.out.println(obj.i);
		System.out.println(j);
		System.out.println(obj.method1());
	}
}
