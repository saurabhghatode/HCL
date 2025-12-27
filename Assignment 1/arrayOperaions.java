import java.util.Scanner;

public class arrayOperaions {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input array
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n + 1];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // Insertion
        System.out.print("Enter position and value to insert: ");
        int pos = sc.nextInt();
        int val = sc.nextInt();
        for (int i = n; i >= pos; i--)
            arr[i] = arr[i - 1];
        arr[pos - 1] = val;
        n++;

        // Deletion
        System.out.print("Enter position to delete: ");
        pos = sc.nextInt();
        for (int i = pos - 1; i < n - 1; i++)
            arr[i] = arr[i + 1];
        n--;

        // Linear Search
        System.out.print("Enter element for linear search: ");
        val = sc.nextInt();
        for (int i = 0; i < n; i++)
            if (arr[i] == val)
                System.out.println("Found at position " + (i + 1));

        // Binary Search (assuming sorted array)
        System.out.print("Enter element for binary search: ");
        val = sc.nextInt();
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == val) {
                System.out.println("Found at position " + (mid + 1));
                break;
            } else if (arr[mid] < val)
                low = mid + 1;
            else
                high = mid - 1;
        }

        // Maximum value
        int max = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > max) max = arr[i];
        System.out.println("Maximum value: " + max);

        // Count even and odd
        int even = 0, odd = 0;
        for (int i = 0; i < n; i++)
            if (arr[i] % 2 == 0) even++;
            else odd++;
        System.out.println("Even count: " + even);
        System.out.println("Odd count: " + odd);

        // Insertion Sort
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        // Display final array
        System.out.print("Sorted array: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        sc.close();
    }
}
