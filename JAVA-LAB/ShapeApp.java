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
        Rectangle rect = new Rectangle(10, 5);
        Triangle tri = new Triangle(10, 8);

        System.out.println("Area of Rectangle: " + rect.area());
        System.out.println("Area of Triangle: " + tri.area());
    }
}

/*
Testcase:
Area of Rectangle: 50.0
Area of Triangle: 40.0
*/