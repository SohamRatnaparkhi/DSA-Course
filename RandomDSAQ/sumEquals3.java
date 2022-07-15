package RandomDSAQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class sumEquals3 {
    static ArrayList<Integer> index = new ArrayList<Integer>();
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3,1, 2, 3 ,4, 5, 6, 7, 8, 9 };
        int sum = 6;
        System.out.println((pairSum(sum, arr)));
        System.out.println(index);
    }

    private static HashSet<ArrayList<Integer>> pairSum(int sum, int[] arr) {
        Arrays.sort(arr);
        HashSet<ArrayList<Integer>> ans = new HashSet<ArrayList<Integer>>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> result = new ArrayList<Integer>(3);
            int a = arr[i];
            int l = i + 1;
            int r = arr.length - 1;
            while (l < r) {
                if (arr[l] + arr[r] + a == sum) {
                    
                    result.add(sum - arr[l] - arr[r]);
                    result.add(arr[l]);
                    result.add(arr[r]);
                    // result.sort(null);
                    ans.add(result);
                    result = new ArrayList<Integer>(3);

                    index.add(i);

                    l++;
                    r--;
                } else if (arr[l] + arr[r] + a > sum) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }

    private static boolean binarySearch(int[] arr, int i, int j, int sum) {
        int s = i;
        int e = j;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] > sum) {
                e = mid - 1;
            } else if (arr[mid] < sum) {
                s = mid + 1;
            } else if (arr[mid] == sum) {
                return true;
            }
        }
        return false;
    }
}
