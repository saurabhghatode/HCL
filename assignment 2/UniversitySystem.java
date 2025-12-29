import java.util.*;
import java.util.regex.Pattern;

// Interface
interface University {
    void add();
    void display();
    void search(int id);
    void remove(int id);
}

// Student class
class Student {
    int id, marks;
    String name, course;

    Student(int i, String n, String c, int m) {
        id = i;
        name = n;
        course = c;
        marks = m;
    }
}

// Main class
public class UniversitySystem implements University {

    ArrayList<Student> list = new ArrayList<>();
    HashMap<Integer, Student> map = new HashMap<>();
    Set<String> courses = new HashSet<>();
    Scanner sc = new Scanner(System.in);

    public void add() {
        try {
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            if (map.containsKey(id)) {
                System.out.println("Duplicate ID not allowed");
                return;
            }

            System.out.print("Name: ");
            String name = sc.nextLine();
            if (!Pattern.matches("[a-zA-Z ]+", name)) {
                System.out.println("Invalid Name");
                return;
            }

            System.out.print("Course: ");
            String course = sc.nextLine();
            System.out.print("Marks: ");
            int marks = sc.nextInt();

            Student s = new Student(id, name, course, marks);

            list.add(s);
            map.put(id, s);
            courses.add(course);

            System.out.println("Student Added");

        } catch (Exception e) {
            System.out.println("Wrong Input");
            sc.nextLine();
        }
    }

    public void display() {
        for (Student s : list)
            System.out.println(s.id + " " + s.name + " " + s.course + " " + s.marks);
    }

    public void search(int id) {
        Student s = map.get(id);
        if (s != null)
            System.out.println("Found: " + s.name);
        else
            System.out.println("Student Not Found");
    }

    public void remove(int id) {
        Student s = map.remove(id);
        if (s != null) {
            list.remove(s);
            System.out.println("Student Removed");
        } else
            System.out.println("Student Not Found");
    }

    public void sortByMarks() {
        list.sort((a, b) -> a.marks - b.marks);
        System.out.println("Sorted By Marks");
    }

    public void showCourses() {
        System.out.println("Courses:");
        for (String c : courses)
            System.out.println(c);
    }

    public void convertMap() {
        TreeMap<Integer, Student> tmap = new TreeMap<>(map);
        System.out.println("TreeMap Data:");
        for (Student s : tmap.values())
            System.out.println(s.id + " " + s.name);
    }

    public void countCourse() {
        HashMap<String, Integer> count = new HashMap<>();
        for (Student s : list)
            count.put(s.course, count.getOrDefault(s.course, 0) + 1);
        System.out.println("Course Count: " + count);
    }

    // Main
    public static void main(String[] args) {

        UniversitySystem u = new UniversitySystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add 2.Display 3.Search 4.Remove 5.Sort 6.Courses 7.Count 8.Convert 9.Exit");
            System.out.print("Choice: ");

            try {
                int ch = sc.nextInt();
                switch (ch) {
                    case 1: u.add(); break;
                    case 2: u.display(); break;
                    case 3:
                        System.out.print("ID: ");
                        u.search(sc.nextInt()); break;
                    case 4:
                        System.out.print("ID: ");
                        u.remove(sc.nextInt()); break;
                    case 5: u.sortByMarks(); break;
                    case 6: u.showCourses(); break;
                    case 7: u.countCourse(); break;
                    case 8: u.convertMap(); break;
                    case 9:
                        System.out.println("Program End");
                        return;
                    default:
                        System.out.println("Wrong Choice");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input");
                sc.nextLine();
            }
        }
    }
}
