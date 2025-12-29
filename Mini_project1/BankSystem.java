import java.io.*;
import java.util.Scanner;

//ABSTRACT CLASS
abstract class BankAccount {

    protected int accNo;
    protected String name;
    protected double balance;

    // Constructor
    BankAccount(int a, String n, double b) {
        accNo = a;
        name = n;
        balance = b;
    }

    // Abstract methods
    abstract void deposit(double amt);
    abstract void withdraw(double amt);

    // Concrete method
    void showDetails() {
        System.out.println("Account No: " + accNo);
        System.out.println("Name      : " + name);
        System.out.println("Balance   : " + balance);
    }

    // Save data to file
    void saveToFile() {
        try {
            FileWriter fw = new FileWriter("bankdata.txt", true);
            fw.write(accNo + "," + name + "," + balance + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("File Error");
        }
    }
}

//INHERITANCE (HIERARCHICAL)
class SavingsAccount extends BankAccount {

    SavingsAccount(int a, String n, double b) {
        super(a, n, b);
    }

    // Method overriding
    public void deposit(double amt) {
        balance += amt;
        System.out.println("Amount Deposited");
    }

    public void withdraw(double amt) {
        if (amt > balance)
            System.out.println("Insufficient Balance");
        else {
            balance -= amt;
            System.out.println("Amount Withdrawn");
        }
    }
}

class CurrentAccount extends BankAccount {

    CurrentAccount(int a, String n, double b) {
        super(a, n, b);
    }

    public void deposit(double amt) {
        balance += amt;
        System.out.println("Deposit Successful");
    }

    public void withdraw(double amt) {
        balance -= amt;
        System.out.println("Withdrawal Successful");
    }
}

//MAIN CLASS
public class BankSystem {

    // Method Overloading
    static void balanceEnquiry(BankAccount acc) {
        System.out.println("Current Balance: " + acc.balance);
    }

    static void balanceEnquiry(BankAccount acc, String msg) {
        System.out.println(msg + acc.balance);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account; // Runtime polymorphism

        System.out.println("1.Savings Account  2.Current Account");
        System.out.print("Choose Account Type: ");
        int type = sc.nextInt();

        System.out.print("Enter Account No: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        if (type == 1)
            account = new SavingsAccount(accNo, name, bal);
        else
            account = new CurrentAccount(accNo, name, bal);

        account.saveToFile();

        while (true) {
            System.out.println("\n1.Deposit 2.Withdraw 3.Balance 4.Details 5.Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Amount: ");
                    account.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter Amount: ");
                    account.withdraw(sc.nextDouble());
                    break;

                case 3:
                    balanceEnquiry(account, "Available Balance: ");
                    break;

                case 4:
                    account.showDetails();
                    break;

                case 5:
                    account.saveToFile();
                    System.out.println("Thank You!");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
