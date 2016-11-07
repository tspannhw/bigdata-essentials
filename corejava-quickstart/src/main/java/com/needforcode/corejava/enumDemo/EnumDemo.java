package com.needforcode.corejava.enumDemo;

public class EnumDemo
{
 public static void main(String args[]){
	
	//  Enum in Java are type-safe, can't specify other than in enum. 
	Student st = Student.JACK; // Student.Jack will retrun obj of type Student.
	
		if (st.name() == "JACK"){
			System.out.println("The student name is jack");
		}
		
	Employee[] emp = Employee.values(); // will return singleton obj.
	  for (Employee e: emp){
	System.out.println("emp id: " + e.i + " emp name: " + e.name() + " ordinal:" + e.ordinal());
	  }
	  
	  System.out.println(new EnumDemo().printStudentName(Student.JIM));
	  
	  // when enum inside class, then implicity static
	  System.out.println(EnumDemo.Teacher.JILL);
 }
 
 String printStudentName(Student student){
	 // type saftey enum
	  switch(student){
	  case JIM:
		  return ("JIM");
	  case JACK:
		  return ("Jack");
	  default:
		  return ("default");
	  }
	  }
 	
 enum Teacher {
	 JILL;
 }
}
