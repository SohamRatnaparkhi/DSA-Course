public class FallingSum {
    public static void main(String[] args) {
        int[][] grid = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        Integer[][] dp = new Integer[grid.length + 1][grid[0].length];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++)
            ans = Math.min(ans, (minFallingPathSum(grid, dp, 0, i, grid.length)));
        // System.out.println(minFallingPathSum(grid, dp, 0, i, grid.length));
        System.out.println(ans);
        System.out.println(table(grid, new int[grid.length][grid[0].length + 2], grid.length));
    }

    private static int minFallingPathSum(int[][] grid, Integer[][] dp, int i, int j, int n) {
        if (j >= n || j < 0)
            return (int) Math.pow(10, 7);

        // int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE, z = Integer.MAX_VALUE;

        if (dp[i][j] != null)
            return dp[i][j];

        if (i == n - 1)
            return grid[i][j];

        int x = grid[i][j] + minFallingPathSum(grid, dp, i + 1, j, n);
        int y = grid[i][j] + minFallingPathSum(grid, dp, i + 1, j + 1, n);
        int z = grid[i][j] + minFallingPathSum(grid, dp, i + 1, j - 1, n);

        int ans = Math.min(y, Math.min(x, z));
        dp[i][j] = ans;

        return ans;

    }

    private static int table(int[][] grid, int[][] dp, int n) {
        for (int i = 0; i < n; i++) {
            dp[i][0] = (int) Math.pow(10, 3);
        }
        for (int i = 0; i < n; i++) {
            dp[i][n + 1] = (int) Math.pow(10, 3);
        }
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= n; j++) {
                if (i == n - 1) {
                    dp[i][j] = grid[i][j - 1];
                } else {
                    int x = grid[i][j - 1] + dp[i + 1][j];
                    int y = grid[i][j - 1] + dp[i + 1][j - 1];
                    int z = grid[i][j - 1] + dp[i + 1][j + 1];

                    dp[i][j] = Math.min(z, Math.min(y, x));
                    min = Math.min(min, dp[i][j]);
                }
            }
            ans = min;
        }
        return ans;
    }
}
