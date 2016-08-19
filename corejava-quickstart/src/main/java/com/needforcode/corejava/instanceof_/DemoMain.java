package com.needforcode.corejava.instanceof_;

class ParentClass {
	  public ParentClass() {

	  }
	}


class ChildClass extends ParentClass {
	  public ChildClass() {
	    super();
	  }
	  void childClassMethod(){
		  System.out.println("child");
	  }
	}


class ChildClass2 extends ParentClass {
		  public ChildClass2() {
		    super();
		  }
		  void childClassMethod2(){
			  System.out.println("child 2");
		  }
		}


public class DemoMain {
	  public static void main(String[] a) {

	    ChildClass childclass = new ChildClass();
	    ParentClass par = new ChildClass();
	    ParentClass par2 = new ChildClass2();
	    System.out.println(childclass instanceof ParentClass);
	    System.out.println(par instanceof ChildClass);
	    System.out.println(par2 instanceof ChildClass2);
	  }

	}
