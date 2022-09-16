package hashmaps;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class LongestSeq {
    public static void main(String[] args) {
        int arr[] = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
        ArrayList<Integer> ans = longestSeq(arr);
        System.out.println(ans);
    }

    private static ArrayList<Integer> longestSeq(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                continue;
            } else if (map.containsKey(i - 1) && map.containsKey(i + 1)) {
                map.put(i - 1, map.get(i - 1) + 1);
                map.put(i, 1);
            } else if (map.containsKey(i - 1)) {
                map.put(i - 1, map.get(i - 1) + 1);
                map.put(i, 0);
            } else if (map.containsKey(i + 1)) {
                map.put(i, 1);
            } else {
                map.put(i, 0);
            }
        }
        for (int key : map.keySet()) {
            System.out.println(key + " - " + map.get(key));
        }
        int max = 0;
        int start = 0;
        int temp = 0;
        for (int i : arr) {
            // System.out.println(i);
            Integer x = map.get(i);
            temp = 0;
            if (x != null) {
                int y = 0;
                temp = x == 0 ? 1 : 0;
                while (x != null && x != 0) {
                    x = map.get(i + y++);
                    temp++;
                }
            }
            if (temp > max) {
                max = temp;
                start = i;
            }
        }
        System.out.println("max = " + max);
        ans.add(start);
        ans.add(start + max - 1);
        return ans;
    }
}
