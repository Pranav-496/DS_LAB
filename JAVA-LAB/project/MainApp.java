/*
Name: Pranav Shailesh Landge
Class: SY-A
Roll_no: 41
Subject: JPL
Assignment-08-Write a Java program to create calculator for performing arithmetic
operations using packages
*/

import calculator.*;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Addition obj1 = new Addition();
        Subtraction obj2 = new Subtraction();
        Multiplication obj3 = new Multiplication();
        Division obj4 = new Division();
        Factorial obj5 = new Factorial();
        Square obj6 = new Square();
        Cube obj7 = new Cube();
        SquareRoot obj8 = new SquareRoot();
        CubeRoot obj9 = new CubeRoot();

        int choice;
        double a, b;

        do {
            System.out.println("\n--- Calculator Menu ---");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Factorial");
            System.out.println("6. Square");
            System.out.println("7. Cube");
            System.out.println("8. Square Root");
            System.out.println("9. Cube Root");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

           

            switch (choice) {
                case 1:
                    System.out.print("Enter first number: ");
                    a = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    b = sc.nextDouble();
                    System.out.println("Result = " + obj1.add(a, b));
                    break;

                case 2:
                    System.out.print("Enter first number: ");
                    a = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    b = sc.nextDouble();
                    System.out.println("Result = " + obj2.subtract(a, b));
                    break;

                case 3:
                    System.out.print("Enter first number: ");
                    a = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    b = sc.nextDouble();
                    System.out.println("Result = " + obj3.multiply(a, b));
                    break;

                case 4:
                    System.out.print("Enter first number: ");
                    a = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    b = sc.nextDouble();
                    System.out.println("Result = " + obj4.divide(a, b));
                    break;

                case 5:
                    System.out.println("Enter number: ");
                    int n = sc.nextInt();
                    System.out.println("Result = " + obj5.fact(n));
                    break;

                case 6:
                    System.out.println("Enter number: ");
                    a = sc.nextDouble();
                    System.out.println("Result = " + obj6.square(a));
                    break;

                case 7:
                    System.out.println("Enter number: ");
                    a = sc.nextDouble();
                    System.out.println("Result = " + obj7.cube(a));
                    break;

                case 8:
                    System.out.println("Enter number: ");
                    a = sc.nextDouble();
                    System.out.println("Result = " + obj8.sqrt(a));
                    break;

                case 9:
                
                    System.out.println("Enter number: ");
                    a = sc.nextDouble();
                    System.out.println("Result = " + obj9.cbrt(a));
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}