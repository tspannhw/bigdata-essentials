package com.needforcode.corejava.tostring;

public class NoToStringDemo {
	
	String s = getClass().getName() + '@' + Integer.toHexString(hashCode());

	public static void main(String args[]){
		
		NoToStringDemo obj = new NoToStringDemo();
		// toString() returns the class name of the obj & hex representation of hashcode.
		System.out.println(obj.toString());
		System.out.println(obj.s);
		// how is it printing obj.toString when i print obj.
		System.out.println(obj);
		// This is what happening in printstream.println();
		System.out.println(String.valueOf(obj));
	}

}
