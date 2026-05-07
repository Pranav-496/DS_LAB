/*
Name: Pranav Shailesh Landge
Class: SY-A
Roll_no: 41
Subject: JPL
Assignment-04-Write Java program to create a super class called “Shape” that receives the
dimensions of objects. It also defines a method called area that computes the
area of an object. The program derives two subclasses from “Shape”. Each of
the sub class overrides area() so that it returns the area of a rectangle and a
triangle respectively
*/

import java.util.*;

class Shape {
    double dim1;
    double dim2;

    Shape(double a, double b) {
        dim1 = a;
        dim2 = b;
    }

    double area() {
        System.out.println("Area for Shape is undefined.");
        return 0;
    }
}

class Rectangle extends Shape {

    Rectangle(double a, double b) {
        super(a, b);
    }

    @Override
    double area() {
        return dim1 * dim2;
    }
}

class Triangle extends Shape {

    Triangle(double a, double b) {
        super(a, b);
    }

    @Override
    double area() {
        return (dim1 * dim2) / 2;
    }
}

public class ShapeApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length and breadth of rectangle: ");
        double r1 = sc.nextDouble();
        double r2 = sc.nextDouble();

        System.out.print("Enter base and height of triangle: ");
        double t1 = sc.nextDouble();
        double t2 = sc.nextDouble();

        Rectangle rect = new Rectangle(r1, r2);

        Triangle tri = new Triangle(t1, t2);

        System.out.println("\nArea of Rectangle: " + rect.area());

        System.out.println("Area of Triangle: " + tri.area());
    }
}