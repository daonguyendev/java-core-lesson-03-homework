package com.daonguyen.model;

public class Manager extends Employee {
    private int numberOfSubordinates; //number of staffs need to manage

    private final int SALARY_PER_DAY = 200;

    public Manager(int numberOfSubordinates) {
        this.numberOfSubordinates = numberOfSubordinates;
    }

    public Manager(int code, String fullName, String mobile, int workingDays, int employeeType, int numberOfSubordinates) {
        super(code, fullName, mobile, workingDays, employeeType);
        this.numberOfSubordinates = numberOfSubordinates;
    }

    public int getNumberOfSubordinates() {
        return numberOfSubordinates;
    }

    public void setNumberOfSubordinates(int numberOfSubordinates) {
        this.numberOfSubordinates = numberOfSubordinates;
    }

    public float calculateMonthlySalary() {
        return SALARY_PER_DAY * getWorkingDays() + 100 * numberOfSubordinates;
    }

    public void printEmployee() {
        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s %-20s \n",
                getCode(), getFullName(), getMobile(), getWorkingDays(), getEmployeeType(), "N/A", numberOfSubordinates, "N/A");
    }
}
