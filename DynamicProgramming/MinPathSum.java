public class MinPathSum {
    public static void main(String[] args) {

        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        Integer[][] dp = new Integer[grid.length + 1][grid[0].length + 1];
        return helper(dp, grid, 0, 0, grid.length, grid[0].length);
    }

    private static int helper(Integer[][] dp, int[][] grid, int i, int j, int m, int n) {
        if (i == m && j == n)
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        if (i == m - 1) {
            int sum = 0;
            for (int x = j; x < n; x++) {
                sum += grid[i][x];
            }
            return sum;
        }

        if (j == n - 1) {
            int sum = 0;
            for (int x = i; x < m; x++) {
                sum += grid[x][j];
            }
            return sum;
        }

        int x, y;
        x = grid[i][j] + helper(dp, grid, i + 1, j, m, n);
        y = grid[i][j] + helper(dp, grid, i, j + 1, m, n);

        dp[i][j] = Math.min(x, y);
        return Math.min(x, y);
    }
}
