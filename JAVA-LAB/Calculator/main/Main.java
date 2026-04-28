package main;

import java.util.*;
import arithmetic.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Calculator Menu ---");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter first number: ");
                double a = sc.nextDouble();

                System.out.print("Enter second number: ");
                double b = sc.nextDouble();

                switch (choice) {
                    case 1:
                        Add add = new Add();
                        System.out.println("Result: " + add.calculate(a, b));
                        break;
                    case 2:
                        Subtract sub = new Subtract();
                        System.out.println("Result: " + sub.calculate(a, b));
                        break;
                    case 3:
                        Multiply mul = new Multiply();
                        System.out.println("Result: " + mul.calculate(a, b));
                        break;
                    case 4:
                        Divide div = new Divide();
                        double res = div.calculate(a, b);
                        if (!Double.isNaN(res)) {
                            System.out.println("Result: " + res);
                        }
                        break;
                }
            } else if (choice == 5) {
                System.out.println("Exiting...");
            } else {
                System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}