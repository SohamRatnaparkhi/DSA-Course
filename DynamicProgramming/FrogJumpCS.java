public class FrogJumpCS {
    public static void main(String[] args) {
        int n = 4;
        int[] height = {10, 20, 30, 10};
        System.out.println(frogJump(n, height));
    }
    
    public static int frogJump(int n, int height[]) {

        // Write your code here..
        Integer[] dp = new Integer[n + 2];
        return helper(0, n, height, dp);
    }

    public static int helper(int i, int n, int[] height, Integer[] dp) {
        if (i >= n)
            return -1;
        int t1 = i + 1 > n - 1 ? 0 : i + 1;
        int t2 = i + 2 > n - 1 ? 0 : i + 2;

        int x = Math.abs(height[i] - height[t1]) + helper(i + 1, n, height, dp);
        if(x == -1)
            return 0;
        int y = Math.abs(height[i] - height[t2]) + helper(i + 2, n, height, dp);
        if(y == -1)
            return Integer.MAX_VALUE;

        return Math.min(x, y);
    }
}
