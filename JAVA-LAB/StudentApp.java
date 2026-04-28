/*
Name: Pranav Shailesh Landge
Class: SY-A
Roll_no: 41
Subject: JPL
Assignment-02-Write a Java program to initialize and refer instance of class having
parameterized constructor using this keyword. Make use of static keyword.
*/

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
        System.out.println("Name: " + this.name);
        System.out.println("Roll: " + this.roll);
    }

    static void showCount() {
        System.out.println("Total Students: " + count);
    }
}

public class StudentApp {
    public static void main(String[] args) {
        Student s1 = new Student("Narendra Modi", 41);
        Student s2 = new Student("Amit Shah", 42);

        s1.display();
        s2.display();

        Student.showCount();
    }
}

/*
Testcase:
Name: Narendra Modi
Roll: 41
Name: Amit Shah
Roll: 42
Total Students: 2
*/