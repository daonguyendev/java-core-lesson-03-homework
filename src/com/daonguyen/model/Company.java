package com.daonguyen.model;

public class Company {
    private String name;
    private String taxCode;
    private float monthlyRevenue; // should input larger than total salary of company. Maybe > 100000

    public Company () {

    }

    public Company(String name, String taxCode, float monthlyRevenue) {
        this.name = name;
        this.taxCode = taxCode;
        this.monthlyRevenue = monthlyRevenue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public float getMonthlyRevenue() {
        return monthlyRevenue;
    }

    public void setMonthlyRevenue(float monthlyRevenue) {
        this.monthlyRevenue = monthlyRevenue;
    }

    public void displayCompanyInfo() {
        System.out.println("\nOur company information is: ");
        System.out.printf("%-10s %-20s %-20s \n", "Name", "Tax Code", "Monthly Revenue");
        System.out.printf("%-10s %-20s %-20s \n", name, taxCode, monthlyRevenue);
        System.out.println();
    }
}
