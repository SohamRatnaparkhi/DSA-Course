import java.util.HashMap;

public class LC403 {
    public static void main(String[] args) {
        int[] stones = { 0, 1, 3, 5, 6, 8, 12, 17 };
        System.out.println(canCross(stones));
    }

    public static boolean canCross(int[] stones) {
        // // Boolean[][] dp = new Boolean[2 * stones.length + 2][2 * stones.length +
        // 2];
        // HashMap<Tuple, Boolean> dp = new HashMap<>();
        // dp.put(new Tuple(0, 1), false);
        // boolean ans1 = helper(stones, 1, dp, 0, stones.length);
        // System.out.println(ans1);
        HashMap<Tuple, Boolean> dp2 = new HashMap<>();
        boolean ans2 = helper2(stones, 1, dp2, 0, stones.length);
        System.out.println(dp2);
        return ans2;
    }

    private static boolean helper2(int[] stones, int k, HashMap<Tuple, Boolean> dp, int pos, int n) {
        if (pos == stones[n - 1])
            return true;

        if (pos > stones[n - 1]) {
            return false;
        }

        if (!search(stones, pos, 0, n - 1))
            return false;
        Tuple t = new Tuple(pos, k);
        if (dp.get(t) != null) {
            return dp.get(t);
        }
        boolean x = false, y, z = false;
        if (pos == 0) {
            y = helper2(stones, k, dp, pos + k, n);
        } else {
            if (k != 1)
                x = helper2(stones, k - 1, dp, pos + k - 1, n);
            y = helper2(stones, k, dp, pos + k, n);
            z = helper2(stones, k + 1, dp, pos + k + 1, n);
        }

        dp.put(t, x || y || z);

        return x || y || z;

    }

    private static boolean helper(int[] stones, int k, HashMap<Tuple, Boolean> dp, int pos, int n) {
        if (pos == stones[n - 1])
            return true;

        if (pos > stones[n - 1]) {
            return false;
        }

        if (!search(stones, pos, 0, n - 1))
            return false;

        boolean x = false, y, z = false;
        if (k != 1 && pos != 0) {
            Tuple temp = new Tuple(pos + k - 1, k - 1);
            if (dp.get(temp) == null) {
                x = helper(stones, k - 1, dp, pos + k - 1, n);
                dp.put(temp, x);
            } else {
                x = dp.get(temp);
            }
        }

        Tuple temp2 = new Tuple(pos + k, k);
        if (dp.get(temp2) == null) {
            y = helper(stones, k, dp, pos + k, n);
            dp.put(temp2, y);
        } else {
            y = dp.get(temp2);
        }
        if (pos != 0) {
            Tuple temp3 = new Tuple(pos + k + 1, k + 1);
            if (dp.get(temp3) == null) {
                z = helper(stones, k + 1, dp, pos + k + 1, n);
                dp.put(temp3, z);
            } else {
                z = dp.get(temp3);
            }
        }
        return x || y || z;
    }

    private static boolean search(int[] arr, int key, int lb, int rb) {
        int mid = 0;
        while (lb <= rb) {
            mid = lb + (rb - lb) / 2;
            if (key > arr[mid])
                lb = mid + 1;
            else if (arr[mid] > key)
                rb = mid - 1;
            else if (arr[mid] == key)
                return true;
        }
        return false;
    }
}

class Tuple {
    int x, y;

    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }
}