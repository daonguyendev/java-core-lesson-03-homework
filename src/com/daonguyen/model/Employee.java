package com.daonguyen.model;

public class Employee {
    private int code;
    private String fullName;
    private String mobile;
    private int workingDays;
    private int employeeType;

    public Employee() {
    }

    public Employee(int code, String fullName, String mobile, int workingDays, int employeeType) {
        this.code = code;
        this.fullName = fullName;
        this.mobile = mobile;
        this.workingDays = workingDays;
        this.employeeType = employeeType;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    public int getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(int employeeType) {
        this.employeeType = employeeType;
    }

    public void printEmployee() {
        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s %-20s \n",
                code, fullName, mobile, workingDays, employeeType, "N/A", "N/A", "N/A");
    }

    public float calculateMonthlySalary() {
        int defaultSalaryPerDay = 50;
        return defaultSalaryPerDay * getWorkingDays();
    }
}
