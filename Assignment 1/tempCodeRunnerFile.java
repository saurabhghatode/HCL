public class que1 {

    // Addition
    static int add(int a, int b) {
        return a + b;
    }

    // Subtraction
    static int subtract(int a, int b) {
        return a - b;
    }

    // Multiplication
    static int multiply(int a, int b) {
        return a * b;
    }

    // Division
    static int divide(int a, int b) {
        return a / b;   // assume b is not zero
    }

    // Remainder
    static int remainder(int a, int b) {
        return a % b;
    }

    // Square
    static int square(int a) {
        return a * a;
    }

    // Cube
    static int cube(int a) {
        return a * a * a;
    }

    // Absolute value
    static int absolute(int a) {
        return (a < 0) ? -a : a;
    }

    public static void main(String[] args) {

        int x = 10;
        int y = 3;

        System.out.println("Addition: " + add(x, y));
        System.out.println("Subtraction: " + subtract(x, y));
        System.out.println("Multiplication: " + multiply(x, y));
        System.out.println("Division: " + divide(x, y));
        System.out.println("Remainder: " + remainder(x, y));
        System.out.println("Square of x: " + square(x));
        System.out.println("Cube of x: " + cube(x));
        System.out.println("Absolute value of -20: " + absolute(-20));
    }
}
