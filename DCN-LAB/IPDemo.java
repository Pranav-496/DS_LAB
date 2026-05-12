/*
    Write a program for DNS lookup. Given an IP address as input, it should 
    return URL and vice-versa.    
*/

import java.net.*;
import java.util.*;

public class IPDemo {
    public static void main(String[] args) {
        String host;
        Scanner ch = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Enter the Host Name \n2. Enter IP address \n3. EXIT\nChoice:");
            choice = ch.nextInt();
            ch.nextLine(); // Consume newline after int input
            switch (choice) {
                case 1: {
                    System.out.println("\nEnter the Host Name:");
                    host = ch.nextLine();
                    try {
                        InetAddress address = InetAddress.getByName(host);
                        System.out.println("IP Address: " + address.getHostAddress());
                        System.out.println("Host Name: " + address.getHostName());
                        System.out.println("Host Name and IP Address: " + address.toString());
                    } catch (UnknownHostException ex) {
                        System.out.println("Could not find: " + host);
                    }
                    break;
                }

                case 2: {
                    System.out.println("Enter IP Address:");
                    host = ch.nextLine();
                    try {
                        InetAddress address = InetAddress.getByName(host);
                        System.out.println("Host Name: " + address.getHostName());
                        System.out.println("IP Address: " + address.getHostAddress());
                        System.out.println("Host Name and IP Address: " + address.toString());
                    } catch (UnknownHostException ex) {
                        System.out.println("Could not find: " + host);
                    }
                    break;
                }
                case 3: {
                    System.out.println("Exiting...");
                    break;
                }
                default: {
                    System.out.println("Invalid choice");
                }
            }

        } while (choice != 3);
        ch.close();
    }
}