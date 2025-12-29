import java.util.*;
import java.util.regex.Pattern;

// Interface
interface StudentOperations {
    void addStudent();
    void displayStudents();
    void removeStudent(int roll);
    void searchStudent(int roll);
}

// Student class
class Student {
    int rollNo;
    String name;

    Student(int r, String n) {
        rollNo = r;
        name = n;
    }
}

// Main class
public class StudentRecordSystem implements StudentOperations {

    // Using different collections
    ArrayList<Student> arrayList = new ArrayList<Student>();
    Vector<Student> vector = new Vector<Student>();
    List<Student> list = new ArrayList<Student>();

    Scanner sc = new Scanner(System.in);

    // Add student
    public void addStudent() {
        try {
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            // REGEX for name validation
            if (!Pattern.matches("[a-zA-Z ]+", name)) {
                System.out.println("Invalid Name!");
                return;
            }

            Student s = new Student(roll, name);

            arrayList.add(s);
            vector.add(s);
            list.add(s);

            System.out.println("Student Added Successfully");

        } catch (Exception e) {
            System.out.println("Invalid Input");
            sc.nextLine();
        }
    }

    // Display students
    public void displayStudents() {
        if (arrayList.isEmpty()) {
            System.out.println("No Student Records Found");
            return;
        }

        for (Student s : arrayList) {
            System.out.println("Roll No: " + s.rollNo + ", Name: " + s.name);
        }
    }

    // Remove student
    public void removeStudent(int roll) {
        boolean found = false;

        Iterator<Student> it = arrayList.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.rollNo == roll) {
                it.remove();
                vector.remove(s);
                list.remove(s);
                found = true;
                System.out.println("Student Removed Successfully");
                break;
            }
        }

        if (!found)
            System.out.println("Student Not Found");
    }

    // Search student
    public void searchStudent(int roll) {
        for (Student s : arrayList) {
            if (s.rollNo == roll) {
                System.out.println("Student Found");
                System.out.println("Roll No: " + s.rollNo);
                System.out.println("Name: " + s.name);
                return;
            }
        }
        System.out.println("Student Not Found");
    }

    // Main method
    public static void main(String[] args) {

        StudentRecordSystem srs = new StudentRecordSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- STUDENT RECORD MENU ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Remove Student");
            System.out.println("4. Search Student");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            try {
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        srs.addStudent();
                        break;
                    case 2:
                        srs.displayStudents();
                        break;
                    case 3:
                        System.out.print("Enter Roll No to Remove: ");
                        srs.removeStudent(sc.nextInt());
                        break;
                    case 4:
                        System.out.print("Enter Roll No to Search: ");
                        srs.searchStudent(sc.nextInt());
                        break;
                    case 5:
                        System.out.println("Program Ended");
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
