import java.util.*;

class Account {
  String name;
  long accno;
  double bal;
  double roi;
  String cont;
  String address;

  Account(String name, long accno, double bal, double roi, String cont, String address) {
    this.name = name;
    this.accno = accno;
    this.bal = bal;
    this.roi = roi;
    this.cont = cont;
    this.address = address;
  }

  void deposit(double amt) {
    if (amt <= 0) {
      System.out.println("Invalid amount");
      return;
    }
    bal += amt;
    System.out.println("Deposited successfully !");
  }

  void withdraw(double amt) {
    if (amt <= 0) {
      System.out.println("Invalid amount");
      return;
    } else if (amt > bal) {
      System.out.println("Insufficient balance");
      return;
    }
    bal -= amt;
    System.out.println("Withdrawal successful !");
  }

  void computeInterest() {
    double interest = (bal * roi) / 100;
    System.out.println("Interest : " + interest);
  }

  void displayBalance() {
    System.out.println("Balance : " + bal);
  }

  void displayDetails() {
    System.out.println("Name : " + name);
    System.out.println("Account No : " + accno);
    System.out.println("Balance : " + bal);
    System.out.println("Rate of interest : " + roi);
    System.out.println("Contact : " + cont);
    System.out.println("Address : " + address);
  }
}

public class BankingApp {
  static Scanner sc = new Scanner(System.in);
  static Account accounts[] = new Account[100];
  static int count = 0;

  static Account findAccount(long accNo) {
    for (int i = 0; i < count; i++) {
      if (accounts[i].accno == accNo) {
        return accounts[i];
      }
    }
    return null;
  }

  static void createAccount() {
    System.out.println("Enter name : ");
    String name = sc.nextLine();

    System.out.println("Enter Account Number : ");
    long accno = sc.nextLong();

    if (findAccount(accno) != null) {
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

    accounts[count] = new Account(name, accno, bal, roi, contact, address);

    count++;

    System.out.println("Account created successfully");
  }

}