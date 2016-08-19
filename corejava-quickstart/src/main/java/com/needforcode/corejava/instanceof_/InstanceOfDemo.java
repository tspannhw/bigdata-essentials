package com.needforcode.corejava.instanceof_;

public class InstanceOfDemo {
	
	public static void main(String[] a) {

	    String s = "HI";
	    if (s instanceof String) {
	      System.out.println("true");
	    }
	    
	    String s1 = null;
	    if (s1 instanceof String){
	    	System.out.println("true");
	    } else {
	    	System.out.println("false");
	    }
	    
	  }

}
