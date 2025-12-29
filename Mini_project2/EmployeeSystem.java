import java.io.*;
import java.util.*;

class Employee {
    int id;
    String dept;
    double salary;

    Employee(int id, String dept, double salary) {
        this.id = id;
        this.dept = dept;
        this.salary = salary;
    }

    public String toString() {
        return id + "," + dept + "," + salary;
    }
}

public class EmployeeSystem {

    static ArrayList<Employee> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static String file = "emp.txt";

    // Login
    static void login() {
        System.out.print("Username: ");
        String u = sc.nextLine();
        System.out.print("Password: ");
        String p = sc.nextLine();

        if (!u.equals("admin") || !p.equals("123")) {
            System.out.println("Invalid Login");
            System.exit(0);
        }
    }

    // Save file
    static void save() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (Employee e : list)
            bw.write(e + "\n");
        bw.close();
    }

    // Add employee
    static void add() throws Exception {
        System.out.print("ID: ");
        int id = sc.nextInt();

        for (Employee e : list)
            if (e.id == id) {
                System.out.println("ID must be unique");
                return;
            }

        sc.nextLine();
        System.out.print("Department: ");
        String d = sc.nextLine();
        if (d.isEmpty()) {
            System.out.println("Department cannot be empty");
            return;
        }

        System.out.print("Salary: ");
        double s = sc.nextDouble();
        if (s <= 0) {
            System.out.println("Salary must be positive");
            return;
        }

        list.add(new Employee(id, d, s));
        save();
        System.out.println("Employee Added");
    }

    // Display
    static void display() {
        for (Employee e : list)
            System.out.println(e.id + " " + e.dept + " " + e.salary);
    }

    // Update salary
    static void update() throws Exception {
        System.out.print("ID: ");
        int id = sc.nextInt();

        for (Employee e : list) {
            if (e.id == id) {
                System.out.print("New Salary: ");
                double s = sc.nextDouble();
                if (s <= 0) {
                    System.out.println("Invalid Salary");
                    return;
                }
                e.salary = s;
                save();
                System.out.println("Salary Updated");
                return;
            }
        }
        System.out.println("Employee Not Found");
    }

    // Delete
    static void delete() throws Exception {
        System.out.print("ID: ");
        int id = sc.nextInt();

        Iterator<Employee> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().id == id) {
                it.remove();
                save();
                System.out.println("Employee Deleted");
                return;
            }
        }
        System.out.println("Employee Not Found");
    }

    public static void main(String[] args) throws Exception {

        login();

        while (true) {
            System.out.println("\n1.Add 2.Display 3.Update 4.Delete 5.Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1: add(); break;
                case 2: display(); break;
                case 3: update(); break;
                case 4: delete(); break;
                case 5: System.exit(0);
                default: System.out.println("Wrong Choice");
            }
        }
    }
}
