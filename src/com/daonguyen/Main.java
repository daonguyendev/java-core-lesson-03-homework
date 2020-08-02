package com.daonguyen;

import com.daonguyen.model.*;

import java.util.*;

/**
 * Employee Manager
 * Author: Dao Nguyen
 * Date: 02/08/2020
 * Version: 1.0
 */
public class Main {
    private static List<Employee> employees;
    private static Company company;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        employees = new ArrayList<>();

        int feature;
        boolean flag = true;

        do {
            System.out.println("Which feature do you want you to do: ");
            System.out.println("1. Enter company info\n"
                    + "2. Add a new employee\n"
                    + "3. Remove an existing employee by code\n"
                    + "4. Print all of employees in company\n"
                    + "5. Calculate and print total salary of our company\n"
                    + "6. Find the manager with the most salary in our company\n"
                    + "7. Find the manager with the most subordinates in our company\n"
                    + "8. Find the director with the most stock in our company\n"
                    + "9. Calculate and print the total income of each director in our company\n"
                    + "Choose feature you want or press any another number to exit");
            feature = scanner.nextInt();

            switch (feature) {
                case 1:
                    enterCompanyInfo();
                    break;
                case 2:
                    addNewEmployee();
                    break;
                case 3:
                    removeEmployeeByCode();
                    break;
                case 4:
                    printAllOfEmployees();
                    break;
                case 5:
                    calculateAndPrintTotalSalary();
                    break;
                case 6:
                    findManagerWithTheMostSalary();
                    break;
                case 7:
                    findManagerWithTheMostSubordinates();
                    break;
                case 8:
                    findDirectorWithTheMostStock();
                    break;
                case 9:
                    calculateTotalIncomeEachDirector();
                    break;
                default:
                    System.out.println("We don't have this feature!");
                    flag = false;
                    break;
            }
        } while (flag);
    }

    private static void calculateTotalIncomeEachDirector() {
        List<Employee> directors = getAllOfDirectors();
        List<Director> directorList = new ArrayList<>();

        for (Employee employee : directors) {
            directorList.add((Director) employee);
        }

        float companyRevenue = company.getMonthlyRevenue() - calculateAndPrintTotalSalary();

        System.out.println("Total income of each director in our company is:");
        System.out.printf("%-10s %-20s %-20s \n", "Code", "Full Name", "Total Income");
        for (int i = 0; i < directorList.size(); i++) {
            float totalIncome = directorList.get(i).calculateMonthlySalary()
                    + ((float) directorList.get(i).getStockInCompany() / 100) * companyRevenue;
            System.out.printf("%-10s %-20s %-20s \n", directorList.get(i).getCode(), directorList.get(i).getFullName(), totalIncome);
        }
        System.out.println();
    }

    private static List<Employee> getAllOfDirectors() {
        List<Employee> directors = new ArrayList<>();

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeType() == 3) {
                directors.add(employees.get(i));
            }
        }

        return directors;
    }

    private static void findDirectorWithTheMostStock() {
        int directorPosition = 0;
        List<Employee> directors = getAllOfDirectors();
        List<Director> directorList = new ArrayList<>();

        for (Employee employee : directors) {
            directorList.add((Director) employee);
        }

        for (int i = 0; i < directorList.size() - 1; i++) {
            if (directorList.get(i).getStockInCompany() < directorList.get(i + 1).getStockInCompany()) {
                directorPosition = i + 1;
            }
        }

        System.out.print("\nThe director with the most stock in our company is:\n");
        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s %-20s \n",
                "Code", "Full Name", "Mobile", "Working Days", "Employee Type",
                "Staff Manager Code", "Number Of Subordinates", "Stock In Company");
        employees.get(directorPosition).printEmployee();
        System.out.println();
    }

    private static void findManagerWithTheMostSubordinates() {
        int managerPosition = 0;
        List<Employee> managers = getAllOfManagers();
        List<Manager> managerList = new ArrayList<>();

        for (Employee employee : managers) {
            managerList.add((Manager) employee);
        }

        for (int i = 0; i < managerList.size() - 1; i++) {
            if (managerList.get(i).getNumberOfSubordinates() < managerList.get(i + 1).getNumberOfSubordinates()) {
                managerPosition = i + 1;
            }
        }

        System.out.print("\nThe manager with the most subordinates in our company is:\n");
        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s %-20s \n",
                "Code", "Full Name", "Mobile", "Working Days", "Employee Type",
                "Staff Manager Code", "Number Of Subordinates", "Stock In Company");
        employees.get(managerPosition).printEmployee();
        System.out.println();
    }

    private static List<Employee> getAllOfManagers() {
        List<Employee> managers = new ArrayList<>();

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeType() == 2) {
                managers.add(employees.get(i));
            }
        }

        return managers;
    }

    private static void findManagerWithTheMostSalary() {
        int managerPosition = 0;
        List<Employee> managers = getAllOfManagers();

        for (int i = 0; i < managers.size() - 1; i++) {
            if (managers.get(i).calculateMonthlySalary() < managers.get(i + 1).calculateMonthlySalary()) {
                managerPosition = i + 1;
            }
        }

        System.out.print("\nThe manager with the most salary in our company is:\n");
        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s %-20s \n",
                "Code", "Full Name", "Mobile", "Working Days", "Employee Type",
                "Staff Manager Code", "Number Of Subordinates", "Stock In Company");
        employees.get(managerPosition).printEmployee();
        System.out.println();
    }

    private static float calculateAndPrintTotalSalary() {
        float totalSalary = 0;

        for (int i = 0; i < employees.size(); i++) {
            totalSalary += employees.get(i).calculateMonthlySalary();
        }

        System.out.print("\nTotal salary of our company is: " + totalSalary);
        System.out.println();

        return totalSalary;
    }

    private static void printAllOfEmployees() {
        System.out.print("\nAll of employees in our company is: \n");
        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s %-20s \n",
                "Code", "Full Name", "Mobile", "Working Days", "Employee Type",
                "Staff Manager Code", "Number Of Subordinates", "Stock In Company");
        for (int i = 0; i < employees.size(); i++) {
            employees.get(i).printEmployee();
        }
        System.out.println();
    }

    private static void removeEmployeeByCode() {
        System.out.print("Enter employee code you want to remove: ");
        int code = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getCode() == code) {
                employees.remove(i);
            }
        }

        System.out.print("\nAll of employees after removing is: \n");
        printAllOfEmployees();

        System.out.println();
    }

    private static void inputEmployee(Employee employee) {
        System.out.print("Enter employee code: "); // should not enter duplicate code
        int code = scanner.nextInt();
        employee.setCode(code);
        scanner.nextLine();

        System.out.print("Enter employee full name: ");
        String fullName = scanner.nextLine();
        employee.setFullName(fullName);

        System.out.print("Enter employee mobile number: ");
        String mobile = scanner.nextLine();
        employee.setMobile(mobile);

        System.out.print("Enter employee working days: ");
        int workingDays = scanner.nextInt();
        employee.setWorkingDays(workingDays);
        scanner.nextLine();

        System.out.print("Enter employee type (1. Staff - 2. Manager - 3. Director): ");
        int employeeType = scanner.nextInt();
        employee.setEmployeeType(employeeType);
        scanner.nextLine();

        switch (employeeType) {
            case 1:
                System.out.print("Enter staff manager code: ");
                int staffManagerCode = Integer.parseInt(scanner.nextLine());
                employee = new Staff(code, fullName, mobile, workingDays, employeeType, staffManagerCode);
                ((Staff) employee).setStaffManagerCode(staffManagerCode);
                System.out.println();
                break;
            case 2:
                System.out.print("Enter number of subordinates: ");
                int numberOfSubordinates = Integer.parseInt(scanner.nextLine());
                employee = new Manager(code, fullName, mobile, workingDays, employeeType, numberOfSubordinates);
                ((Manager) employee).setNumberOfSubordinates(numberOfSubordinates);
                System.out.println();
                break;
            case 3:
                System.out.print("Enter stock in company: ");
                int stockInCompany = Integer.parseInt(scanner.nextLine());
                employee = new Director(code, fullName, mobile, workingDays, employeeType, stockInCompany);
                ((Director) employee).setStockInCompany(stockInCompany);
                System.out.println();
                break;
            default:
                break;
        }

        employees.add(employee);
    }

    private static void addNewEmployee() {
        System.out.print("\nEnter number of employees you want to put to our company: ");
        int employeesNumber = scanner.nextInt();
        Employee employeesArray[] = new Employee[employeesNumber];

        for (int i = 0; i < employeesNumber; i++) {
            System.out.println("Employee number[" + (i + 1) + "] is: ");
            employeesArray[i] = new Employee();
            inputEmployee(employeesArray[i]);
        }

        System.out.print("\nNew employees after adding is: \n");
        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s %-20s \n",
                "Code", "Full Name", "Mobile", "Working Days", "Employee Type",
                "Staff Manager Code", "Number Of Subordinates", "Stock In Company");
        for (int i = 0; i < employees.size(); i++) {
            employees.get(i).printEmployee();
        }

        System.out.println();
    }

    private static void enterCompanyInfo() {
        System.out.println("Please enter company info below");
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Tax Code: ");
        String taxCode = scanner.nextLine();

        System.out.print("Monthly Revenue: ");
        float monthlyRevenue = scanner.nextFloat();

        company = new Company(name, taxCode, monthlyRevenue);
        company.displayCompanyInfo();
    }
}
