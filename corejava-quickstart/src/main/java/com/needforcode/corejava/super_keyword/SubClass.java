package com.needforcode.corejava.super_keyword;

public class SubClass extends SuperClass {
	public int i=10;
	SubClass(){
		System.out.println("super class constructor");
	}
	
	void subMethod(){
		System.out.println("method in SubClass");
	}
	
	static void subMethod2(){
		System.out.println("static method in subclass");
	}

}
