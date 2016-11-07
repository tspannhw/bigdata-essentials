package com.needforcode.corejava.overloading;

public class Figure {
	
	public void area(int l, int b){
		System.out.println("executing rectangle area :" + l*b);
	}
	
	public void area(int s){
		System.out.println("executing int side :" + s*s);
	}
	
	public void area(double s){
		System.out.println("executing double side :" + s*s);
	}
	
	public void area(int... s){
		System.out.println(s.length);
	}

	public static void main(String args[]){
		Figure fig = new Figure();
		fig.area(10);
		fig.area(10.5);
		fig.area(1,1,1,1,1);
	}
}

