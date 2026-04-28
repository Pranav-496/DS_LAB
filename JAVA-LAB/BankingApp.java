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
  static Account acc = null;

  static void createAccount() {
    System.out.print("Enter Name: ");
    String name = sc.nextLine();

    System.out.print("Enter Account Number: ");
    long accNo = sc.nextLong();

    System.out.print("Enter Initial Balance: ");
    double bal = sc.nextDouble();

    System.out.print("Enter Rate of Interest: ");
    double roi = sc.nextDouble();
    sc.nextLine();

    System.out.print("Enter Contact: ");
    String contact = sc.nextLine();

    System.out.print("Enter Address: ");
    String address = sc.nextLine();

    acc = new Account(name, accNo, bal, roi, contact, address);
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

        case 2:
          if (acc == null) {
            System.out.println("Create account first");
            break;
          }
          System.out.print("Enter amount: ");
          acc.deposit(sc.nextDouble());
          break;

        case 3:
          if (acc == null) {
            System.out.println("Create account first");
            break;
          }
          System.out.print("Enter amount: ");
          acc.withdraw(sc.nextDouble());
          break;

        case 4:
          if (acc == null) {
            System.out.println("Create account first");
            break;
          }
          acc.computeInterest();
          break;

        case 5:
          if (acc == null) {
            System.out.println("Create account first");
            break;
          }
          acc.displayBalance();
          break;

        case 6:
          if (acc == null) {
            System.out.println("Create account first");
            break;
          }
          acc.displayDetails();
          break;

        case 7:
          System.out.println("Exiting...");
          break;

        default:
          System.out.println("Invalid choice");
      }

    } while (choice != 7);
  }
}

/*
 * Testcase:
 * --- Banking Menu ---
 * 1. Create Account
 * 2. Deposit
 * 3. Withdraw
 * 4. Compute Interest
 * 5. Display Balance
 * 6. Display Details
 * 7. Exit
 * Enter choice: 1
 * Enter Name: Pranav Landge
 * Enter Account Number: 101
 * Enter Initial Balance: 9999
 * Enter Rate of Interest: 9
 * Enter Contact: 9999999999
 * Enter Address: Mars
 * Account created successfully
 * 
 * --- Banking Menu ---
 * 1. Create Account
 * 2. Deposit
 * 3. Withdraw
 * 4. Compute Interest
 * 5. Display Balance
 * 6. Display Details
 * 7. Exit
 * Enter choice: 2
 * Enter amount: 1000
 * Deposit successful
 * 
 * --- Banking Menu ---
 * 1. Create Account
 * 2. Deposit
 * 3. Withdraw
 * 4. Compute Interest
 * 5. Display Balance
 * 6. Display Details
 * 7. Exit
 * Enter choice: 3
 * Enter amount: 125
 * Withdrawal successful
 * 
 * --- Banking Menu ---
 * 1. Create Account
 * 2. Deposit
 * 3. Withdraw
 * 4. Compute Interest
 * 5. Display Balance
 * 6. Display Details
 * 7. Exit
 * Enter choice: 4
 * Interest: 978.66
 * 
 * --- Banking Menu ---
 * 1. Create Account
 * 2. Deposit
 * 3. Withdraw
 * 4. Compute Interest
 * 5. Display Balance
 * 6. Display Details
 * 7. Exit
 * Enter choice: 5
 * Current Balance: 10874.0
 * 
 * --- Banking Menu ---
 * 1. Create Account
 * 2. Deposit
 * 3. Withdraw
 * 4. Compute Interest
 * 5. Display Balance
 * 6. Display Details
 * 7. Exit
 * Enter choice: 6
 * Name: Pranav Landge
 * Account No: 101
 * Balance: 10874.0
 * Rate of Interest: 9.0
 * Contact: 9999999999
 * Address: Mars
 * 
 * --- Banking Menu ---
 * 1. Create Account
 * 2. Deposit
 * 3. Withdraw
 * 4. Compute Interest
 * 5. Display Balance
 * 6. Display Details
 * 7. Exit
 * Enter choice: 7
 * Exiting...
 */