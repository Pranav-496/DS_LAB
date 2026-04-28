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

        int arr1[] = {5, 3, 8, 1, 2};
        int arr2[] = {5, 3, 8, 1, 2};

        Sortable s1 = new BubbleSort();
        Sortable s2 = new SelectionSort();

        s1.sort(arr1);
        s2.sort(arr2);

        System.out.println("Bubble Sort Result:");
        printArray(arr1);

        System.out.println("Selection Sort Result:");
        printArray(arr2);
    }
}

/*
Testcase:
Bubble Sort Result:
1 2 3 5 8
Selection Sort Result:
1 2 3 5 8
*/