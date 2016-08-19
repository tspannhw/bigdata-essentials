package com.needforcode.corejava.enumDemo;

/*
 * 1) By default extends java.lang.Enum, so can't extend remaining.
 * 2) Can be declared as class or interface.
 * 3) Can't subclass enum since enum(Student) already extend java.lang.Enum
 * 4) Enum can implement interface
 * 5) obj returned by enums are singletons
 * 6) can implement EnumSet & EnumMap
 * 7) if an enum is a member of a class, it's implicitly static
 * 8) new can never be used with an enum, coz singleton
 * 9) enum constants are implicitly public static final
 * 10) enums are implicitly final subclasses of java.lang.Enum
 */
public enum Student {
	  JIM, // static (can be called as Student.JIM (same for all obj)).
	  JACK, 
	  JERRY, 
	  JHON
}


enum Employee {
	KIM(10),
	KATE(20),
	KALE(30);
	int i;
	 Employee(int i) {
		this.i=i;	
		}
}
