package com.daonguyen.model;

public class Director extends Employee {
    private int stockInCompany;

    private final int SALARY_PER_DAY = 300;

    public Director(int stockInCompany) {
        this.stockInCompany = stockInCompany;
    }

    public Director(int code, String fullName, String mobile, int workingDays, int employeeType, int stockInCompany) {
        super(code, fullName, mobile, workingDays, employeeType);
        this.stockInCompany = stockInCompany;
    }

    public int getStockInCompany() {
        return stockInCompany;
    }

    public void setStockInCompany(int stockInCompany) {
        this.stockInCompany = stockInCompany;
    }

    public float calculateMonthlySalary() {
        return SALARY_PER_DAY * getWorkingDays();
    }

    public void printEmployee() {
        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s %-20s \n",
                getCode(), getFullName(), getMobile(), getWorkingDays(), getEmployeeType(), "N/A", "N/A", stockInCompany);
    }
}
