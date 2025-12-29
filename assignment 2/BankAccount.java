import java.util.Scanner;

// Interface for banking operations
interface Bank {
    void deposit(double amount);
    void withdraw(double amount);
    void checkBalance();
}

// Interface for customer operations
interface Customer {
    void showDetails();
}

// BankAccount class implementing multiple interfaces
class BankAccount implements Bank, Customer {

    int accountNumber;
    String customerName;
    double balance;

    // Constructor
    BankAccount(int accNo, String name, double bal) {
        accountNumber = accNo;
        customerName = name;
        balance = bal;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
        } else {
            balance = balance + amount;
            System.out.println("Amount deposited successfully");
        }
    }

    // Withdraw method with exception handling
    public void withdraw(double amount) {
        try {
            if (amount > balance) {
                throw new Exception("Insufficient balance");
            }
            balance = balance - amount;
            System.out.println("Amount withdrawn successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Display customer details
    public void showDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Customer Name: " + customerName);
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount acc = new BankAccount(101, "Saurabh", 5000);

        acc.showDetails();
        acc.checkBalance();

        System.out.print("Enter deposit amount: ");
        acc.deposit(sc.nextDouble());

        System.out.print("Enter withdrawal amount: ");
        acc.withdraw(sc.nextDouble());

        acc.checkBalance();

        sc.close();
    }
}
