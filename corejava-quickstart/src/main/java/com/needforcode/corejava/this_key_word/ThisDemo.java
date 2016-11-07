package com.needforcode.corejava.this_key_word;

public class ThisDemo {
	
	int a;
	int b;
	int c;
	
	// with out using this key word, observe the result
	ThisDemo(int a,int b){
		this(a,b,0);
		a=a;
		b=b;
		}
	
	// with using this key word, observe the result
	ThisDemo(int a, int b, int c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
	public static void main(String []args){
		
		ThisDemo obj1 = new ThisDemo(10,20); // calling constructor not using this keyword
		System.out.println("value of a & b: " + obj1.a +" "+ obj1.b);
		ThisDemo obj2 = new ThisDemo(10, 20, 30); // calling constructor using this keyword
		System.out.println("value of a & b using this in constructor: "+obj2.a+ " "+obj2.b);
	}
}
