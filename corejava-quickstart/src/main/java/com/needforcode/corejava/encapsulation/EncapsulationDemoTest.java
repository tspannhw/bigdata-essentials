package com.needforcode.corejava.encapsulation;

 class EncapsulationDemo{
    private int ssn;
    private String empName;

    //Getter and Setter methods
    public int getEmpSSN(){
        return ssn;
    }

    public void setEmpSSN(int newValue){
        ssn = newValue;
    }
    
    public String getEmpName(){
        return empName;
    }

    public boolean setEmpName(String newValue){
        if (newValue.trim().isEmpty()){
        	return false;
        }
    	empName = newValue;
		return true;
    }

}


public class EncapsulationDemoTest{
    public static void main(String args[]){
         EncapsulationDemo obj = new EncapsulationDemo();
         boolean emp_name = obj.setEmpName(" ");
         if (!emp_name){
        	 System.out.println("you passed wrong employee name");
         }
         obj.setEmpSSN(112233);
         System.out.println("Name of the employee: " + obj.getEmpName());
         System.out.println("SSN of the employee: " + obj.getEmpSSN());
    } 
}
