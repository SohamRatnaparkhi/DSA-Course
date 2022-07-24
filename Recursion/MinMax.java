package Recursion;

import java.util.Arrays;

public class MinMax {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 6, 5};
        
        System.out.println(maxOf(a, a[0]));
    }

    private static int maxOf(int[] a, int max) {
        if(a.length == 0){
            return max;
        }
        if(a[0] >= max){
            max = a[0];
        }
        return maxOf(Arrays.copyOfRange(a, 1, a.length), max);
    }
}
