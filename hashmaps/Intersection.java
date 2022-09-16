package hashmaps;

// import java.util.ArrayList;
import java.util.Arrays;

public class Intersection {
    public static void main(String[] args) {
        int arr1[] = { 2, 6, 1, 2 };
        int arr2[] = { 1, 2, 3, 4, 2 };
        printIntersection(arr1, arr2);
    }

    private static void printIntersection(int[] arr1, int[] arr2) {
        // ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                System.out.println(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }

        }
    }
}
