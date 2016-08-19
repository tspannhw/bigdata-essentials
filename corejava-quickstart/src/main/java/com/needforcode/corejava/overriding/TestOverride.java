package com.needforcode.corejava.overriding;

	class Person{
	       double height;
		   public void canDo(){
		      System.out.println("can eat");
		   }
		}


class Sachin extends Person{
	     double height =5.5; // hide inheritted variable
	     @Override
	     /*
	      * @Override asks compiler to check whether there is such a method in the superclass to be overridden
	      */
	     public void canDo(){
	    	 System.out.println("Bats well");
//	    	 super.canDo();
	   }
	     
	     // over riding methods can't be less accessible
//	     private void canDo(){
//	    	 System.out.println("Bats well");
//	   }
	     
	}


public class TestOverride{

	   public static void main(String args[]){
//	      Person a = new Person(); // Person reference and person object
	      Person b = new Sachin(); // Person reference but Sachin object
	      
//	      Sachin sachin = new Sachin(); // sachin reference and sachin object

//	      a.canDo();// method in person class executed
	      System.out.println(b.height);
	      b.canDo();// method in Sachin class executed
	      System.out.println(b.height);
//	      sachin.canDo(); // method in sachin class executed
//	      System.out.println(sachin.height);
	   }
	}
