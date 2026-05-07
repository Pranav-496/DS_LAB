/*
Name: Pranav Shailesh Landge
Class: SY-A
Roll_no: 41
Subject: JPL
Assignment-01-Write a Menu driven program in Java to implement banking application.
Application should read the customer name, account number, initial balance,
rate of interest, contact number and address field etc. Application should have
following methods.
i. createAccount()
ii. deposit()
iii. withdraw()
iv. computeInterest()
v. displayBalance()
*/

import java.util.*;

class Account {
    String name;
    long accountNumber;
    double balance;
    double rateOfInterest;
    String contact;
    String address;

    Account(String name, long accountNumber, double balance,
            double rateOfInterest, String contact, String address) {

        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.rateOfInterest = rateOfInterest;
        this.contact = contact;
        this.address = address;
    }

    void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount");
            return;
        }

        balance += amount;
        System.out.println("Deposit successful");
    }

    void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawal successful");
    }

    void computeInterest() {

        double interest = (balance * rateOfInterest) / 100.0;

        System.out.println("Interest: " + interest);
    }

    void displayBalance() {

        System.out.println("Current Balance: " + balance);
    }

    void displayDetails() {

        System.out.println("Name: " + name);
        System.out.println("Account No: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Rate of Interest: " + rateOfInterest);
        System.out.println("Contact: " + contact);
        System.out.println("Address: " + address);
    }
}

public class BankingApp {

    static Scanner sc = new Scanner(System.in);

    static Account accounts[] = new Account[100];

    static int count = 0;

    static Account findAccount(long accNo) {

        for (int i = 0; i < count; i++) {

            if (accounts[i].accountNumber == accNo) {
                return accounts[i];
            }
        }

        return null;
    }

    static void createAccount() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        long accNo = sc.nextLong();

        if (findAccount(accNo) != null) {
            System.out.println("Account already exists");
            return;
        }

        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        System.out.print("Enter Rate of Interest: ");
        double roi = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Contact: ");
        String contact = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        accounts[count] = new Account(name, accNo, bal, roi, contact, address);

        count++;

        System.out.println("Account created successfully");
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Compute Interest");
            System.out.println("5. Display Balance");
            System.out.println("6. Display Details");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    sc.nextLine();

                    createAccount();

                    break;

                case 2: {

                    System.out.print("Enter Account Number: ");

                    long accNo = sc.nextLong();

                    Account acc = findAccount(accNo);

                    if (acc == null) {
                        System.out.println("Account not found");
                        break;
                    }

                    System.out.print("Enter amount: ");

                    double amount = sc.nextDouble();

                    acc.deposit(amount);

                    break;
                }

                case 3: {

                    System.out.print("Enter Account Number: ");

                    long accNo = sc.nextLong();

                    Account acc = findAccount(accNo);

                    if (acc == null) {
                        System.out.println("Account not found");
                        break;
                    }

                    System.out.print("Enter amount: ");

                    double amount = sc.nextDouble();

                    acc.withdraw(amount);

                    break;
                }

                case 4: {

                    System.out.print("Enter Account Number: ");

                    long accNo = sc.nextLong();

                    Account acc = findAccount(accNo);

                    if (acc == null) {
                        System.out.println("Account not found");
                        break;
                    }

                    acc.computeInterest();

                    break;
                }

                case 5: {

                    System.out.print("Enter Account Number: ");

                    long accNo = sc.nextLong();

                    Account acc = findAccount(accNo);

                    if (acc == null) {
                        System.out.println("Account not found");
                        break;
                    }

                    acc.displayBalance();

                    break;
                }

                case 6: {

                    System.out.print("Enter Account Number: ");

                    long accNo = sc.nextLong();

                    Account acc = findAccount(accNo);

                    if (acc == null) {
                        System.out.println("Account not found");
                        break;
                    }

                    acc.displayDetails();

                    break;
                }

                case 7:

                    System.out.println("Exiting...");

                    break;

                default:

                    System.out.println("Invalid choice");
            }

        } while (choice != 7);
    }
}