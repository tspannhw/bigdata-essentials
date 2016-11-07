package com.needforcode.corejava.constructors;

class ConstructorOverloadingDemo extends SuperClass {
	
	  static int i;
	  int j;

	  //constructor method
	  ConstructorOverloadingDemo() {
		  this(100); // this calls param constructor of this class
		  System.out.println("Default Constructor called.");

	  }
	  
	  // constructor over loading
	  ConstructorOverloadingDemo(int k) {
		  super(); // super() calls the super class default constructor.
		  System.out.println("Param Constructor called.:" +k);

		  }
	  
	  public static void main(String[] args) {
		  System.out.println(i);
	    ConstructorOverloadingDemo object = new ConstructorOverloadingDemo();
		  System.out.println(i);
		  System.out.println(object.j);

	  }
	}
