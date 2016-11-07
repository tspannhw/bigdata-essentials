package com.needforcode.corejava.literals;

public class LiteralsDemo {

	public static void main(String arg[]){
	
	int in = 011; //octal
	int hex =0x1A; //hex
	System.out.println(in);
	System.out.println(hex);
	
	float f = 5.5f;
	double doub=5.5;
	System.out.println(f);
	System.out.println(doub);
	System.out.println(0.0f / 0.0f);
	if (Float.isNaN((0.0f/0.0f))){
		System.out.println("nan is true");
	}

		
	char a='\u0041';
	char b= (char)(65);
	char c= 'A';
	char d= '\n';
	char e= '\"';
	System.out.println(a);
	System.out.println(b);
	System.out.println(d);
	System.out.println(c);
	System.out.println(e);
	
	boolean bool = false;
	System.out.println(bool);
	
	String st="";
    String uc = "string \"\u0567\".";
	System.out.println(st);
	System.out.println(uc);
}
}
