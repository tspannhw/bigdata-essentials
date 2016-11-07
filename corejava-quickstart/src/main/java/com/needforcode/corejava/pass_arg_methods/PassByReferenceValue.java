package com.needforcode.corejava.pass_arg_methods;

public class PassByReferenceValue {
	
	int ssn;
	public static void main(String [] args)
	{

	  PassByReferenceValue a = new PassByReferenceValue();
	  a.ssn=10;
	  System.out.println("value of ssn of obj a: " + a.ssn );
	  a.method1(a); // pass by object reference value
	  System.out.println("value of ssn after method invoke: " +a.ssn);
	}

	void method1(PassByReferenceValue arg){
		System.out.println("arg passed to method: " +arg); // object refrence value passed
	    arg.ssn=20;
	}

}
