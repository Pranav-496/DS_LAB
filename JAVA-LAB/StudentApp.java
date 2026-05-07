/*
Name: Pranav Shailesh Landge
Class: SY-A
Roll_no: 41
Subject: JPL
Assignment-02-Write a Java program to initialize and refer instance of class having
parameterized constructor using this keyword. Make use of static keyword.
*/

import java.util.*;

class Student {
    String name;
    int roll;
    static int count = 0;

    Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
        count++;
    }

    void display() {
        System.out.println("\nName: " + name);
        System.out.println("Roll: " + roll);
    }

    static void showCount() {
        System.out.println("\nTotal Students: " + count);
    }
}

public class StudentApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student students[] = new Student[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details of Student " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter roll number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            students[i] = new Student(name, roll);
        }

        System.out.println("\n--- Student Details ---");

        for (int i = 0; i < n; i++) {
            students[i].display();
        }

        Student.showCount();
    }
}
