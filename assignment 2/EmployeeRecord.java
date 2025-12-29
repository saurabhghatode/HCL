import java.util.*;
import java.util.regex.Pattern;

// Interface
interface EmployeeOps {
    void addEmployee();
    void displayEmployees();
    void searchEmployee(int id);
    void removeEmployee(int id);
}

// Employee class
class Employee {
    int empId;
    String name;

    Employee(int i, String n) {
        empId = i;
        name = n;
    }

    public String toString() {
        return empId + " : " + name;
    }
}

// Main class
public class EmployeeRecord implements EmployeeOps {

    HashMap<Integer, Employee> hashMap = new HashMap<>();
    Hashtable<Integer, Employee> hashtable = new Hashtable<>();
    TreeMap<Integer, Employee> treeMap = new TreeMap<>();

    Scanner sc = new Scanner(System.in);

    // Add employee
    public void addEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            // REGEX validation
            if (!Pattern.matches("[a-zA-Z ]+", name)) {
                System.out.println("Invalid Name");
                return;
            }

            Employee e = new Employee(id, name);

            hashMap.put(id, e);
            hashtable.put(id, e);
            treeMap.put(id, e);

            System.out.println("Employee Added");

        } catch (Exception e) {
            System.out.println("Invalid Input");
            sc.nextLine();
        }
    }

    // Display employees
    public void displayEmployees() {
        if (hashMap.isEmpty()) {
            System.out.println("No Records");
            return;
        }

        System.out.println("Employees:");
        for (Employee e : hashMap.values()) {
            System.out.println(e);
        }
    }

    // Search employee
    public void searchEmployee(int id) {
        Employee e = hashMap.get(id);
        if (e != null)
            System.out.println("Employee Found: " + e);
        else
            System.out.println("Employee Not Found");
    }

    // Remove employee
    public void removeEmployee(int id) {
        if (hashMap.remove(id) != null) {
            hashtable.remove(id);
            treeMap.remove(id);
            System.out.println("Employee Removed");
        } else {
            System.out.println("Employee Not Found");
        }
    }

    // Main method
    public static void main(String[] args) {

        EmployeeRecord er = new EmployeeRecord();
        Scanner sc = new Scanner(System.in);

        // Demonstrating null support
        er.hashMap.put(null, null);   // Allowed
        System.out.println("HashMap allows null key & value");

        while (true) {
            System.out.println("\n1.Add 2.Display 3.Search 4.Remove 5.Exit");
            System.out.print("Choice: ");

            try {
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        er.addEmployee();
                        break;
                    case 2:
                        er.displayEmployees();
                        break;
                    case 3:
                        System.out.print("Enter Employee ID: ");
                        er.searchEmployee(sc.nextInt());
                        break;
                    case 4:
                        System.out.print("Enter Employee ID: ");
                        er.removeEmployee(sc.nextInt());
                        break;
                    case 5:
                        System.out.println("Program End");
                        return;
                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input");
                sc.nextLine();
            }
        }
    }
}
