/*
Name: Pranav Shailesh Landge
Class: SY-A
Roll_no: 41
Subject: JPL
Assignment-07-Write a Java program to create an interface named as“Sortable” with a
method sort() that sorts an array of integers in ascending order. Create two
classes BubbleSort and SelectionSort that implement the “Sortable” interface
and provide their own implementations of the sort() method
*/

import java.util.*;

interface Sortable {
    void sort(int arr[]);
}

class BubbleSort implements Sortable {

    public void sort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

class SelectionSort implements Sortable {

    public void sort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}

public class Sort {

    static void printArray(int arr[]) {

        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int arr1[] = new int[n];
        int arr2[] = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {

            arr1[i] = sc.nextInt();
            arr2[i] = arr1[i];
        }

        Sortable s1 = new BubbleSort();
        Sortable s2 = new SelectionSort();

        s1.sort(arr1);
        s2.sort(arr2);

        System.out.println("\nBubble Sort Result:");
        printArray(arr1);

        System.out.println("\nSelection Sort Result:");
        printArray(arr2);
    }
}