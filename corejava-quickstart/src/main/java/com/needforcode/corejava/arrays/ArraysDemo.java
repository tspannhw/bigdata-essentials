package com.needforcode.corejava.arrays;

public class ArraysDemo {

	  public static void main(String[] argvs) {
	    int[] arrayName; // declaring to the compiler
	    arrayName = new int[4]; // specifying the size, can't resize unless creating new
	    
        String[] studentName []; // array of arrays
        
        String[] multi1[]; // multi dinmensional
        String[][] multi2;

        for (int i = 0; i < arrayName.length; i++) {
	      arrayName[i] = i;
	      System.out.println(arrayName[i]); //assignment
	    }
        
        System.out.println(new ArraysDemo().arraymethod1()[0]);
//        System.out.println(new ArraysDemo().anotherMethod1()[1]); //array index out of bounds excepttion.
	  }
	  
	  private double[] arraymethod1(){
		  double[] arrDouble = {1.1}; // combined declaration
          return arrDouble;
       }
	  
	  private double arraymethod2()[]{
		  double[] arrDouble = {1.2};
		     return arrDouble;
		  }
	}

