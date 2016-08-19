package com.needforcode.corejava.equals;


class Student {
	Student(int id, String name){
		this.id=id;
		this.name=name;
	}
	int id;
	String name;
}


public class NoEqualsDemo {
	
	public static void main(String args[]){
		
		Student s1 = new Student(1,"jack");
		Student s2 = new Student(1,"jack");
		
		System.out.println(s1.equals(s2));
	}

}
