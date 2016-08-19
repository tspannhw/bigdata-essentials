package com.needforcode.corejava.equals;

class Students {
	Students(int id, String name){
		this.id=id;
		this.name=name;
	}
	int id;
	String name;
	
	@Override
	public boolean equals(Object obj) {
		boolean flag = false;
		// should check if obj is not null & instance of Students
		if(obj != null || (obj instanceof Students)){
			// casting obj to Students (down casting)
		Students st = (Students) obj;
		if ((this.id == st.id) || (this.name == st.name)){
			flag = true;
		}
	}
		return flag;
}
}


public class EqualsDemo {
	
	public static void main(String args[]){
		
		Students s1= new Students(1, "jack");
		Students s2= new Students(1, "jack");
		System.out.println(s1.equals(s2));
	}

}
