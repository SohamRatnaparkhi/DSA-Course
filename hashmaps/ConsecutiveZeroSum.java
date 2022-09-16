package hashmaps;

import java.util.HashMap;

public class ConsecutiveZeroSum {
    public static void main(String[] args) {
        int[] arr = {2 ,-2, 0, -2, 2};
        System.out.println(longestZero(arr));
    }

    private static int longestZero(int[] arr) {
        int ans = 0;
        HashMap<Integer, Integer>  map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                ans = Math.max(ans, i + 1);
                continue;
            }
            if (map.containsKey(sum)) {
                ans = Math.max(ans, Math.abs(i - map.get(sum)));
            } else {
                map.put(sum, i);
            }
        }
        return ans;
    }
}
