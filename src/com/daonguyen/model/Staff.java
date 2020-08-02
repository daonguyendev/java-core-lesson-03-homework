package com.daonguyen.model;

public class Staff extends Employee {
    private int staffManagerCode;

    private final int SALARY_PER_DAY = 100;

    public Staff(int staffManagerCode) {
        this.staffManagerCode = staffManagerCode;
    }

    public Staff(int code, String fullName, String mobile, int workingDays, int employeeType, int staffManagerCode) {
        super(code, fullName, mobile, workingDays, employeeType);
        this.staffManagerCode = staffManagerCode;
    }

    public int getStaffManagerCode() {
        return (staffManagerCode != -1) ? staffManagerCode : null;
    }

    public void setStaffManagerCode(int staffManagerCode) {
        this.staffManagerCode = staffManagerCode;
    }

    public float calculateMonthlySalary() {
        return SALARY_PER_DAY * getWorkingDays();
    }

    public void printEmployee() {
        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s %-20s \n",
                getCode(), getFullName(), getMobile(), getWorkingDays(), getEmployeeType(), staffManagerCode, "N/A", "N/A");
    }
}
