package com.employee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empid;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "emp_salary")
    private Float empSalary;

    @Column(name = "emp_age")
    private int empAge;

    @Column(name = "emp_city")
    private String empCity;

    public Long getEmpid() {
        return empid;
    }

    public void setEmpid(Long empid) {
        this.empid = empid;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Float getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Float empSalary) {
        this.empSalary = empSalary;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public String getEmpCity() {
        return empCity;
    }

    public void setEmpCity(String empCity) {
        this.empCity = empCity;
    }

    public Employee() {
    }

    public Employee(Long empid, String empName, Float empSalary, int empAge, String empCity) {
        this.empid = empid;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empAge = empAge;
        this.empCity = empCity;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", emp_name='" + empName + '\'' +
                ", emp_salary=" + empSalary +
                ", emp_age=" + empAge +
                ", emp_city='" + empCity + '\'' +
                '}';
    }
}

