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

public class StringOperations {
    public static void main(String[] args) {

        String str1 = "Hello";
        String str2 = "World";
        String str3 = "  Java Programming  ";
        String str4 = "Hello";

        System.out.println("Original Strings:");
        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
        System.out.println("str3 = '" + str3 + "'");
        System.out.println();

        System.out.println("charAt(1) in str1: " + str1.charAt(1));

        System.out.println("compareTo(str2): " + str1.compareTo(str2));

        System.out.println("concat: " + str1.concat(str2));

        System.out.println("equals(str4): " + str1.equals(str4));

        System.out.println("replace 'l' with 'x': " + str1.replace('l', 'x'));

        String sentence = "Java is fun";
        String[] words = sentence.split(" ");
        System.out.println("split:");
        for (String w : words) {
            System.out.println(w);
        }

        System.out.println("trim: '" + str3.trim() + "'");
    }
}

/*
Testcase:
Original Strings:
str1 = Hello
str2 = World
str3 = '  Java Programming  '

charAt(1) in str1: e
compareTo(str2): -16
concat: HelloWorld
equals(str4): true
replace 'l' with 'x': Hexxo
split:
Java
is
fun
trim: 'Java Programming'
*/
