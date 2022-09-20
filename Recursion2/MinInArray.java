package Recursion2;

public class MinInArray {
    public static void main(String[] args) {
        int[] arr = {2,4,1,5,7};
        minArray(Integer.MAX_VALUE, arr, 0);
    }

    private static void minArray(int minValue, int[] arr, int k) {
        if (k == arr.length) {
            System.out.println("Min = " + minValue);
            return;
        }
        minArray(Math.min(minValue, arr[k]), arr, k + 1);
    }
}
