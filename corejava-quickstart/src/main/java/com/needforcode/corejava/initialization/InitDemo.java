package com.needforcode.corejava.initialization;

public class InitDemo {
	 
	//constructor
	public InitDemo() {
		this(1);
		System.out.println("constructor called");
	}
	
	public InitDemo(int i){
		System.out.println("param");
	}
	
 
	//static initializer
	static {
		System.out.println("static initializer called");
	}
 
	//instance initializer
	{
		System.out.println("instance initializer called");
	}
 
	public static void main(String[] args) {
		InitDemo obj = new InitDemo();
	}
}
