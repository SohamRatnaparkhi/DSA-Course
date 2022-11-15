public class FallingSum2 {
    public static void main(String[] args) {
        int[][] grid = { { -73, 61, 43, -48, -36 }, { 3, 30, 27, 57, 10 }, { 96, -76, 84, 59, -15 },
                { 5, -49, 76, 31, -7 }, { 97, 91, 61, -46, 67 } };
        Integer[][] dp = new Integer[grid.length + 1][grid[0].length + 1];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++)
            ans = Math.min(ans, (minFallingPathSum(grid, dp, 0, i, grid.length)));
        // System.out.println(minFallingPathSum(grid, dp, 0, i, grid.length));
        System.out.println(ans);
    }

    private static int minFallingPathSum(int[][] grid, Integer[][] dp, int i, int j, int n) {
        if (j >= n || j < 0)
            return Integer.MAX_VALUE;

        // int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE, z = Integer.MAX_VALUE;
        if (i == n - 1)
            return grid[i][j];

        if (dp[i][j] != null)
            return dp[i][j];

        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            if (k == j)
                continue;
            ans = Math.min(ans, grid[i][j] + minFallingPathSum(grid, dp, i + 1, k, n));
        }

        dp[i][j] = ans;
        return ans;

    }
}
