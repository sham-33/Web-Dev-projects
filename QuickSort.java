import java.util.Scanner;

public class Main {
    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;
    }
    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pivotId = partition(arr, low, high);

            quickSort(arr, low, pivotId - 1);
            quickSort(arr, pivotId + 1, high);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.printf("Enter %d elements (unsorted)\n", n);
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("\n" + "Elements before sorting");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        quickSort(arr, 0, n - 1);
        System.out.println("\n" + "Elements after sorting");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
