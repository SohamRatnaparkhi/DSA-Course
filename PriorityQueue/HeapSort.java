package PriorityQueue;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = { 2, 6, 5, 4, 3, 8 };
        heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr, int n) {
        upHeapify(arr, n);
        downHeapify(arr, n);
    }

    private static void downHeapify(int[] arr, int n) {
        int x = n - 1;
        for (int i = 0; i < n - 1; i++) {
            swap(arr, 0, x);
            int parentIndex = 0;
            int childIndex1 = (2 * parentIndex) + 1;
            int childIndex2 = (2 * parentIndex) + 2;
            while (childIndex1 < x && childIndex2 < x) {
                int swappedIndex = -1;
                if (arr[childIndex1] < arr[parentIndex]) {
                    swap(arr, childIndex1, parentIndex);
                    swappedIndex = childIndex1;
                }
                if (arr[childIndex2] < arr[parentIndex]) {
                    swap(arr, childIndex2, parentIndex);
                    swappedIndex = childIndex2;
                }
                if (swappedIndex == -1)
                    break;
                parentIndex = swappedIndex;
                childIndex1 = (2 * parentIndex) + 1;
                childIndex2 = (2 * parentIndex) + 2;
            }
            x--;
        }
    }

    private static void upHeapify(int[] arr, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            int parentIndex = i;
            int childIndex1 = (2 * i) + 1;
            int childIndex2 = (2 * i) + 2;
            makeSwaps(childIndex1, parentIndex, arr, n);
            makeSwaps(childIndex2, parentIndex, arr, n);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void makeSwaps(int childIndex, int parentIndex, int[] arr, int n) {
        if (childIndex < n && arr[childIndex] < arr[parentIndex]) {
            swap(arr, childIndex, parentIndex);
        }
    }
}
