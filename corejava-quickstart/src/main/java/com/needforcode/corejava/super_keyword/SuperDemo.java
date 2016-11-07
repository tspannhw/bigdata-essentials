package com.needforcode.corejava.super_keyword;

public class SuperDemo extends SubClass {
	public SuperDemo() {
		System.out.println("main class constructor");	
		}
	
	int i=20;
	public void demoMethod(){
		super.subMethod();
		super.superMethod();
		super.subMethod2();
		SubClass.subMethod2();
		System.out.println(super.i);
	}
	
	public static void main(String args[]){
		SuperDemo obj = new SuperDemo();
		obj.demoMethod();
		// super.subMethod(); // error : super can't be used in static context
	}
}
