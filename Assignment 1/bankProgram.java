import java.util.Scanner;

class Bank {
    String name;
    int accNo;
    double balance;

    Bank(String n, int a, double b) {
        name = n;
        accNo = a;
        balance = b;
    }

    void deposit(double amt) {
        if (amt <= 0) {
            System.out.println("Invalid deposit amount");
        } else {
            balance = balance + amt;
        }
    }

    void withdraw(double amt) {
        if (amt > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance = balance - amt;
        }
    }

    void showBalance() {
        System.out.println("Current Balance: " + balance);
    }

    void showDetails() {
        System.out.println("Account Holder Name: " + name);
        System.out.println("Account Number: " + accNo);
    }
}

public class bankProgram {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        int acc = sc.nextInt();

        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        Bank b = new Bank(name, acc, bal);

        System.out.print("Enter Deposit Amount: ");
        b.deposit(sc.nextDouble());

        System.out.print("Enter Withdraw Amount: ");
        b.withdraw(sc.nextDouble());

        b.showBalance();
        b.showDetails();

        sc.close();
    }
}
