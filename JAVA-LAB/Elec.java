/*
Name: Pranav Shailesh Landge
Class: SY-A
Roll_no: 41
Subject: JPL
Assignment-05-Write a Java program to calculate electricity bill for commercial and domestic
plan using abstract class
*/

import java.util.*;

abstract class Electricity {
    String name;
    int units;
    double bill;

    Electricity(String name, int units) {
        this.name = name;
        this.units = units;
    }

    abstract void calculateBill();

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Units Consumed: " + units);
        System.out.println("Bill Amount: " + bill);
    }
}

class Domestic extends Electricity {

    Domestic(String name, int units) {
        super(name, units);
    }

    void calculateBill() {
        if (units <= 100)
            bill = units * 2;
        else if (units <= 300)
            bill = 100 * 2 + (units - 100) * 3;
        else
            bill = 100 * 2 + 200 * 3 + (units - 300) * 5;
    }
}

class Commercial extends Electricity {

    Commercial(String name, int units) {
        super(name, units);
    }

    void calculateBill() {
        if (units <= 100)
            bill = units * 5;
        else if (units <= 300)
            bill = 100 * 5 + (units - 100) * 7;
        else
            bill = 100 * 5 + 200 * 7 + (units - 300) * 10;
    }
}

public class Elec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Domestic\n2. Commercial");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Units: ");
        int units = sc.nextInt();

        Electricity obj;

        if (choice == 1)
            obj = new Domestic(name, units);
        else
            obj = new Commercial(name, units);

        obj.calculateBill();
        obj.display();

        sc.close();
    }
}

/*
Testcase:
1. Domestic
Enter Name: Narendra Modi 
Enter Units: 350
Name: Narendra Modi
Units Consumed: 350
Bill Amount: 1100.0
*/