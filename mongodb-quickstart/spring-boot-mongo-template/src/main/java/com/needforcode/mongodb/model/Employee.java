package com.needforcode.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employee {

    @Id
    private String empId;

    private String empName;

    private String empEmail;

    private String empPhone;

    public Employee() {
        // default constructor
    }

    public Employee(String empId, String empName, String empEmail, String empPhone) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;
        this.empPhone = empPhone;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    @Override public String toString() {
        return "Employee{" +
            "empId='" + empId + '\'' +
            ", empName='" + empName + '\'' +
            ", empEmail='" + empEmail + '\'' +
            ", empPhone='" + empPhone + '\'' +
            '}';
    }
}
