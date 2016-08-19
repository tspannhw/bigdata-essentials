package com.needforcode.corejava.comparator;

import java.util.Arrays;
import java.util.Comparator;

class ArrayComparator implements Comparator<ComparatorDemo> {

	public int compare(ComparatorDemo o1, ComparatorDemo o2) {
		return o1.i-o2.i;
	}
	
}


public class ComparatorDemo {

	public ComparatorDemo(int i) {
		this.i=i;
	}
	
	int i;
	public static void main(String []args){
		
		ComparatorDemo[] arrayObj = new ComparatorDemo[3]; // try to increase length & run
		
		ComparatorDemo obj1 = new ComparatorDemo(2);
		ComparatorDemo obj2 = new ComparatorDemo(1);
		ComparatorDemo obj3 = new ComparatorDemo(3);
		arrayObj[0]=obj1;
		arrayObj[1]=obj2;
		arrayObj[2]=obj3;
		
		for (int i=0;i< arrayObj.length; i++) {
			System.out.println(arrayObj[i]+ " " + arrayObj[i].i);
		}
		
		Arrays.sort(arrayObj, new ArrayComparator());
		
		System.out.println("After Sorting");
		for (int i=0;i< arrayObj.length; i++) {
			System.out.println(arrayObj[i]+ " " + arrayObj[i].i);
		}
}
}
