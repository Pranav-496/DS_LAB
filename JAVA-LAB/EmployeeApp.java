/*
Write a Java program to create a class Employee with a method called
calculateSalary(). Create two subclasses Manager and Programmer. In each
subclass, override the calculateSalary() method to calculate and return the
salary based on their specific roles.
*/

import java.util.*;

class Employee {

    String name;
    double basicSalary;

    Employee(String name, double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
    }

    double calculateSalary() {
        return basicSalary;
    }
}

class Manager extends Employee {

    double bonus;

    Manager(String name, double basicSalary, double bonus) {
        super(name, basicSalary);
        this.bonus = bonus;
    }

    @Override
    double calculateSalary() {
        return basicSalary + bonus;
    }
}

class Programmer extends Employee {

    double overtime;

    Programmer(String name, double basicSalary, double overtime) {
        super(name, basicSalary);
        this.overtime = overtime;
    }

    @Override
    double calculateSalary() {
        return basicSalary + overtime;
    }
}

public class EmployeeApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Manager Name: ");
        String mName = sc.nextLine();

        System.out.print("Enter Manager Basic Salary: ");
        double mSalary = sc.nextDouble();

        System.out.print("Enter Manager Bonus: ");
        double bonus = sc.nextDouble();
        sc.nextLine();

        Manager m = new Manager(mName, mSalary, bonus);

        System.out.print("\nEnter Programmer Name: ");
        String pName = sc.nextLine();

        System.out.print("Enter Programmer Basic Salary: ");
        double pSalary = sc.nextDouble();

        System.out.print("Enter Programmer Overtime Amount: ");
        double overtime = sc.nextDouble();

        Programmer p = new Programmer(pName, pSalary, overtime);

        System.out.println("\nManager Salary: " + m.calculateSalary());

        System.out.println("Programmer Salary: " + p.calculateSalary());
        sc.close();
    }
}