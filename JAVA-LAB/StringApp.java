/*
Name: Pranav Shailesh Landge
Class: SY-A
Roll_no: 41
Subject: JPL
Assignment-03-Write a Java program to perform different operations on String.
i. charAt()
ii. compareTo()
iii. concat()
iv. equals()
v. replace()
vi. split()
vii. trim()
*/

import java.util.*;

class StringOperations {
    String str1;
    String str2;
    String str3;

    Scanner sc = new Scanner(System.in);

    void getInput() {
        System.out.print("Enter first string: ");
        str1 = sc.nextLine();

        System.out.print("Enter second string: ");
        str2 = sc.nextLine();

        System.out.print("Enter third string: ");
        str3 = sc.nextLine();
    }

    void displayStrings() {
        System.out.println("\nOriginal Strings:");
        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
        System.out.println("str3 = '" + str3 + "'");
    }

    void charOperation() {
        System.out.println("\ncharAt(1) in str1: " + str1.charAt(1));
    }

    void compareOperation() {
        System.out.println("\ncompareTo(str2): " + str1.compareTo(str2));
    }

    void concatOperation() {
        System.out.println("\nconcat: " + str1.concat(str2));
    }

    void equalsOperation() {
        System.out.println("\nequals(str2): " + str1.equals(str2));
    }

    void replaceOperation() {
        System.out.println("\nreplace 'a' with 'x': " + str1.replace('a', 'x'));
    }

    void splitOperation() {
        System.out.println("\nsplit:");

        String[] words = str3.split(" ");

        for (String w : words) {
            System.out.println(w);
        }
    }

    void trimOperation() {
        System.out.println("\ntrim: '" + str3.trim() + "'");
    }
}

public class StringApp {
    public static void main(String[] args) {

        StringOperations obj = new StringOperations();

        obj.getInput();

        obj.displayStrings();

        obj.charOperation();

        obj.compareOperation();

        obj.concatOperation();

        obj.equalsOperation();

        obj.replaceOperation();

        obj.splitOperation();

        obj.trimOperation();
    }
}
