package Recursion;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {1,44,32,56,31231,32,4,65};
        
        System.out.println(Arrays.toString(divide(arr)));
    }

    private static int[] divide(int[] arr) {
        if(arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = divide(Arrays.copyOfRange(arr, 0, mid));
        int[] right = divide(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);

    }

    private static int[] merge(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int[] sortedArray = new int[left.length + right.length];
        while(i < left.length && j < right.length) {
            if(left[i] <= right[j]) {
                sortedArray[k++] = left[i];
                i++;
            }
            else if(left[i] > right[j]) {
                sortedArray[k++] = right[j];
                j++;
            }
        }
        while(i < left.length){
            sortedArray[k++] = left[i++];
        }
        while(j < right.length){
            sortedArray[k++] = right[j++];
        }
        return sortedArray;
    }
}
