import java.util.Scanner;

public class matrixSimple {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of matrix: ");
        int n = sc.nextInt();

        int[][] a = new int[n][n];
        int[][] b = new int[n][n];

        System.out.println("Enter matrix A:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();

        System.out.println("Enter matrix B:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                b[i][j] = sc.nextInt();

        // Addition
        System.out.println("Addition:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(a[i][j] + b[i][j] + " ");
            System.out.println();
        }

        // Subtraction
        System.out.println("Subtraction:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(a[i][j] - b[i][j] + " ");
            System.out.println();
        }

        // Multiplication
        System.out.println("Multiplication:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++)
                    sum += a[i][k] * b[k][j];
                System.out.print(sum + " ");
            }
            System.out.println();
        }

        // Transpose
        System.out.println("Transpose of Matrix A:");
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }

        // Square, Diagonal, Identity
        boolean diagonal = true, identity = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && a[i][j] != 0)
                    diagonal = false;
                if ((i == j && a[i][j] != 1) || (i != j && a[i][j] != 0))
                    identity = false;
            }
        }

        System.out.println("Square Matrix: Yes");
        System.out.println(diagonal ? "Diagonal Matrix: Yes" : "Diagonal Matrix: No");
        System.out.println(identity ? "Identity Matrix: Yes" : "Identity Matrix: No");

        sc.close();
    }
}
