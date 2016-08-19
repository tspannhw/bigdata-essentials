package com.needforcode.corejava.inheritance;

class IPhone extends AbstractPhone {
	@Override
	public void display() {
		System.out.println("Retina Display");	
		}
}


class IPhone6 extends IPhone {
	public void processer(){
		System.out.println("A8 chip processor");
	}
}


public class AbstractDemo {
public static void main(String[] args) {
	IPhone6 i6 = new IPhone6();
	IPhone iphone = new IPhone6(); // upcasting done implicitly
	IPhone6 iph6 = (IPhone6)iphone; // downcasting done manually
	AbstractPhone phone = new IPhone6();
	IPhone ph = new IPhone();
//	IPhone i = (IPhone6)ph; // run time error thrown, no compile time as compiler trust you
	if (i6 instanceof AbstractPhone){
		System.out.println("true");
	}
}

}
