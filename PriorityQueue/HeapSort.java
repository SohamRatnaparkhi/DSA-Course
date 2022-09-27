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
                    // swap(arr, childIndex1, parentIndex);
                    swappedIndex = childIndex1;
                }
                if (arr[childIndex2] < arr[parentIndex]) {
                    // swap(arr, childIndex2, parentIndex);
                    swappedIndex = childIndex2;
                }
                if (swappedIndex == -1)
                    break;
                swap(arr, swappedIndex, parentIndex);
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

class Solution {

    public static void inplaceHeapSort(int arr[]) {
        /*
         * Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Change in the given input itself.
         * Taking input and printing output is handled automatically.
         */
        // Find length of arr
        int n = arr.length;
        // Step 1 - Build heap using optimized method with time complexity O(n)
        for (int i = (n / 2) - 1; i >= 0; i--) {
            // Perform down-heapfiy operation for node at index i, starting at index i and
            // going to down to the last node (end of arr)
            downHeapify(arr, i, n);
        }

        // Step 2 - Perform remove minimum element, put them at respective last position
        // in the heap and heap re-balancing until all the elements are out of the heap
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            // Apply down-heapify from index 0 to index i
            downHeapify(arr, 0, i);
        }
    }

    // Down-heapify for min. heap order property
    private static void downHeapify(int[] arr, int i, int n) {
        int parentIndex = i;
        int leftChildIndex = 2 * parentIndex + 1, rightChildIndex = 2 * parentIndex + 2;

        while (leftChildIndex < n) {
            int minIndex = parentIndex;
            if (arr[minIndex] > arr[leftChildIndex])
                minIndex = leftChildIndex;

            if (rightChildIndex < n && arr[minIndex] > arr[rightChildIndex])
                minIndex = rightChildIndex;

            if (minIndex == parentIndex)
                return;

            int temp = arr[parentIndex];
            arr[parentIndex] = arr[minIndex];
            arr[minIndex] = temp;

            parentIndex = minIndex;
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;

        }
    }

}
