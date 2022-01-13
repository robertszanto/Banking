import java.util.Scanner;

public class Account {
    //Class Variables
    int balance;
    int previousTranzaction;
    String costumerName;
    String costumerID;

    //Class constructor
    Account(String cname, String cid) {
        costumerName = cname;
        costumerID = cid;
    }

    //Function for Depositing money
    void depozit(int amount) {
        if (amount != 0) {
            balance += amount;
            previousTranzaction = amount;
        }
    }

    //Function for Withdrawing money
    void withdraw(int amount) {
        if (amount != 0) {
            balance -= amount;
            previousTranzaction = -amount;
        }
    }

    //Function showing the previous tranzaction
    void getPreviousTranzaction() {
        if (previousTranzaction > 0) {
            System.out.println("Depozited: " + previousTranzaction);
        } else if (previousTranzaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTranzaction));
        } else {
            System.out.println("No tranzaction occured");
        }
    }

    //Function calculating interest of current funds after a number of years
    void calculateInterest(int years) {
        double interestRate = .0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is: " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
    }

    //Function showing the main menu
    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + costumerName + "!");
        System.out.println("Your ID is: " + costumerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. View previous tranzaction");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous tranzaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            option = scanner.next().charAt(0);
            System.out.println();

            switch (option) {
                //Case 'A' allows the user to check their account balance
                case 'A':
                    System.out.println("========================================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("========================================");
                    System.out.println();
                    break;
                //Case 'B' allows the user to deposit money into their account
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    depozit(amount);
                    System.out.println();
                    break;
                //Case 'C' allows the user to withdraw money from their account
                case 'C' :
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                //Case 'D'  allows the user to view their most recent tranzactioin
                case 'D':
                    System.out.println("========================================");
                    getPreviousTranzaction();
                    System.out.println("========================================");
                    System.out.println();
                    break;
                //Case 'E' calculates the accrued interest
                case 'E':
                    System.out.println("Enter how many years of accrued interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;
                //Case 'F' exits the user from banking app
                case 'F':
                    System.out.println("========================================");
                    break;
                //The default case let's the user know that they entered an invalid key
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, E or F");
                    break;
            }
        } while (option != 'F');
        System.out.println("Thank you for banking with us!");
    }
}

