/*
Name: Pranav Shailesh Landge
Class: SY-A
Roll_no: 41
Subject: JPL
Assignment-06-Write a Java program to accept a file name and display number of
characters,words and lines in the files
*/

import java.io.*;
import java.util.*;

class FileCount {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();

        int charCount = 0;
        int wordCount = 0;
        int lineCount = 0;

        try {
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                lineCount++;

                charCount += line.length();

                String words[] = line.split(" ");
                for (int i = 0; i < words.length; i++) {
                    if (!words[i].equals("")) {
                        wordCount++;
                    }
                }
            }

            fileReader.close();

            System.out.println("Lines: " + lineCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Characters: " + charCount);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        sc.close();
    }
}