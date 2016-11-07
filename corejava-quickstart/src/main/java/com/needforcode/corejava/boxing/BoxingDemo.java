package com.needforcode.corejava.boxing;

public class BoxingDemo {
	
	public static void main(String args[]){
		
		int a =10;
		Integer b = new Integer(a); // this is boxing
		int c = b.intValue(); // this is unboxing
		
		int i =20;
		Integer j =i; // auto boxing
		int k = j; // auto unboxing
	
		System.out.println(i);
		System.out.println(j);
		System.out.println(k);
	}

}
