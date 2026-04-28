/*
Name: Pranav Shailesh Landge
Class: SY-A
Roll_no: 41
Subject: JPL
Assignment-09-Write a JAVA program to create User defined exception to check the
following conditions and throw the exception if the criterion does not met.
i. User has age between 18 and 55
ii. User has income between Rs. 50,000 –Rs. 1,00,000 per month
iii. User stays in Pune / Mumbai/ Bangalore / Chennai
iv. User has 4-wheeler
Accept age, Income, City, Vehicle from the user and check for the conditions
mentioned above.If any of the condition not met then throw the exception
*/

import java.util.*;

class EligibilityException extends Exception {
    EligibilityException(String message) {
        super(message);
    }
}

public class Excep {

    static void checkEligibility(int age, double income, String city, String vehicle)
            throws EligibilityException {

        if (age < 18 || age > 55) {
            throw new EligibilityException("Invalid Age: Must be between 18 and 55");
        }

        if (income < 50000 || income > 100000) {
            throw new EligibilityException("Invalid Income: Must be between 50,000 and 1,00,000");
        }

        if (!(city.equalsIgnoreCase("Pune") ||
              city.equalsIgnoreCase("Mumbai") ||
              city.equalsIgnoreCase("Bangalore") ||
              city.equalsIgnoreCase("Chennai"))) {
            throw new EligibilityException("Invalid City: Must be Pune/Mumbai/Bangalore/Chennai");
        }

        if (!vehicle.equalsIgnoreCase("yes")) {
            throw new EligibilityException("User must have a 4-wheeler");
        }

        System.out.println("User is eligible");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            System.out.print("Enter Income: ");
            double income = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter City: ");
            String city = sc.nextLine();

            System.out.print("Do you have 4-wheeler (yes/no): ");
            String vehicle = sc.nextLine();

            checkEligibility(age, income, city, vehicle);

        } catch (EligibilityException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input");
        }

        sc.close();
    }
}

/*
Testcase 1:
Enter Age: 25
Enter Income: 60000
Enter City: Pune
Do you have 4-wheeler (yes/no): yes
User is eligible

Testcase 2:
Enter Age: 17
Enter Income: 60000
Enter City: Pune
Do you have 4-wheeler (yes/no): yes
Exception: Invalid Age: Must be between 18 and 55

Testcase 3:
Enter Age: 25
Enter Income: 40000
Enter City: Pune
Do you have 4-wheeler (yes/no): yes
Exception: Invalid Income: Must be between 50,000 and 1,00,000

Testcase 4:
Enter Age: 25
Enter Income: 60000
Enter City: Delhi
Do you have 4-wheeler (yes/no): yes
Exception: Invalid City: Must be Pune/Mumbai/Bangalore/Chennai

Testcase 5:
Enter Age: 25
Enter Income: 60000
Enter City: Pune
Do you have 4-wheeler (yes/no): no
Exception: User must have a 4-wheeler
*/