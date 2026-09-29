import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public void mergeSort(int[] a) {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of integers to be sorted: ");
        int input_size = scanner.nextInt();

        // declare the array and populate the array
        int[] input = new int[input_size];
        System.out.println("Enter " + input_size + " integers:");
        for (int i = 0; i < input_size; i++) {
            input[i] = scanner.nextInt();
        }

        int low = 0;
        int high = input.length - 1;
        scanner.close();
        mergeSort(input, low, high);
        System.out.println(Arrays.toString(input));
    }

    public static void mergeSort(int[] A, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(A, low, mid);
            mergeSort(A, mid + 1, high);
            Merge(A, low, mid, high);
        }
    }
    public static void Merge(int[] A, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = A[low + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = A[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = low;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                A[k] = left[i];
                i++;
            } else {
                A[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            A[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            A[k] = right[j];
            j++;
            k++;
        }
    }
}