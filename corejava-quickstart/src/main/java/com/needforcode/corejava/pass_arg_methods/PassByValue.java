package com.needforcode.corejava.pass_arg_methods;

public class PassByValue {
	
	public static void main(String [] args)
	{
	  int ssn = 3;

	  PassByValue a = new PassByValue();
	  System.out.println("value of ssn of obj a: " + ssn );
	  a.method1(ssn);
	}

	void method1(int arg){
	  System.out.println("arg passed to method: " +arg);
	}

}
