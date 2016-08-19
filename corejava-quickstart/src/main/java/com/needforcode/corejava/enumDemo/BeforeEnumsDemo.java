package com.needforcode.corejava.enumDemo;


interface Manager{
	public static final int AGE = 40;
	
	public static final int HEIGHT = 180;
}


public class BeforeEnumsDemo {

	public static void main(String args[]){
	// check if manager age is less than 50
	// no type saftey
	if (Manager.HEIGHT < 50 ){
		System.out.println("manager is less than 50");
	} else {
		System.out.println(" manager is greater than 50");
	}
}
}
