import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n1. Validate Mobile Number");
            System.out.println("2. Validate Email ID");
            System.out.println("3. Validate Username");
            System.out.println("4. Validate Password");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine();   // clear buffer

                if (choice == 5) {
                    System.out.println("Program Ended");
                    break;
                }

                System.out.print("Enter Input: ");
                String input = sc.nextLine();
                boolean result = false;

                switch (choice) {
                    case 1:
                        result = Pattern.matches("[0-9]{10}", input);
                        break;

                    case 2:
                        result = Pattern.matches(".+@.+\\..+", input);
                        break;

                    case 3:
                        result = Pattern.matches("[a-zA-Z0-9]{5,}", input);
                        break;

                    case 4:
                        result = Pattern.matches(".{6,}", input);
                        break;

                    default:
                        System.out.println("Invalid Choice");
                        continue;
                }

                if (result)
                    System.out.println("Welcome! Valid Input");
                else
                    System.out.println("Invalid Input");

            } catch (Exception e) {
                System.out.println("Wrong Input!");
                sc.nextLine();
            }
        }
        sc.close();
    }
}
