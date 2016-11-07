package com.needforcode.corejava.arrays;

public class ObjArraysDemo {
	
	public ObjArraysDemo(int i) {
		this.i=i;
	}
	
	int i;
	public static void main(String []args){
		
		ObjArraysDemo[] arrayObj = new ObjArraysDemo[3]; // try to increase length & run
		
		ObjArraysDemo obj1 = new ObjArraysDemo(2);
		ObjArraysDemo obj2 = new ObjArraysDemo(1);
		ObjArraysDemo obj3 = new ObjArraysDemo(3);
		arrayObj[0]=obj1;
		arrayObj[1]=obj2;
		arrayObj[2]=obj3;
		
		for (int i=0;i< arrayObj.length; i++) {
			System.out.println(arrayObj[i]+ " " + arrayObj[i].i);
		}
	}
}
