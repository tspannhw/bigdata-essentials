package com.needforcode.corejava.tostring;

/*
 * 1) simple, convenient mechanism for debugging classes
 * 2) widely used for logging, and for passing informative error messages to Exception constructors
 */
public class ToStringDemo {
	
	int i;
	
	public ToStringDemo(int i) {
	this.i=i;
	}
	
	@Override
	public String toString() {
		// this will be returned when a call to obj.toString is made for obj of this class.
		String s = this.i + " is roll no of " + Integer.toHexString(hashCode());
		return s;
	}
	
	public static void main(String args[]){
		
		ToStringDemo obj1 = new ToStringDemo(1);
		ToStringDemo obj2  = new ToStringDemo(2);
		System.out.println(obj1);
		System.out.println(obj2);
		
	}

}
