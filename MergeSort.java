import java.util.*;

public class Main {
    public static void conquer(int arr[], int si, int mid, int ei) {
        int[] merged = new int[ei - si + 1];

        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;
        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2++];
            }
        }

        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }
        while (idx2 <= ei) {
            merged[x++] = arr[idx2++];
        }

        for (int i = 0; i < merged.length; i++) {
            arr[si + i] = merged[i];
        }
    }
    public static void divide(int arr[], int si, int ei) {
        int mid = si + (ei - si)/2;
        if (si >= ei)
            return;
        divide(arr, si, mid);
        divide(arr, mid + 1, ei);
        conquer(arr, si, mid, ei);
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
        divide(arr, 0, n - 1);
        System.out.println("\n" + "Elements after sorting");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
