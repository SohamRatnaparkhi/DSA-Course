public class CherryPick {
    public static void main(String[] args) {
        int[][] grid = { { 0, 1, -1 }, { 1, -0, -1 }, { 1, 1, 1 } };
        int n = grid.length;
        System.out.println(helper(grid, 0, 0, n - 1, n - 1, n));
    }

    private static int helper(int[][] grid, int i1, int j1, int i2, int j2, int n) {

        if (j2 < 0 || i2 < 0)
            return (int) Math.pow(-10, 7);
        if (j1 >= n || i1 >= n)
            return (int) Math.pow(-10, 7);

        if (grid[i1][j1] == -1 || grid[i2][j2] == -1)
            return (int) Math.pow(-10, 7);

        if (i1 == n - 1 && j1 == n - 1)
            return grid[i1][j1];
        if (i2 == 0 && j2 == 0)
            return grid[i2][j2];

        // if (i1 == n - 1 || i2 == 0)
        // return (i1 == i2 && j1 == j2) ? grid[i1][j1] : grid[i1][j1] + grid[i2][j2];
        // System.out.println(grid[i1][j1] + " " + grid[i2][j2]);

        int val = (i1 == i2 && j1 == j2) ? grid[i1][j1] : grid[i1][j1] + grid[i2][j2];
        int ans = Integer.MIN_VALUE;

        int tempAns1 = helper(grid, i1 + 1, j1, i2 - 1, j2, n); // top -> down bottom -> up
        ans = Math.max(ans, tempAns1);

        int tempAns2 = helper(grid, i1 + 1, j1, i2, j2 - 1, n); // top -> down bottom -> left
        ans = Math.max(ans, tempAns2);

        int tempAns3 = helper(grid, i1, j1 + 1, i2 - 1, j2, n); // top -> right bottom -> up
        ans = Math.max(ans, tempAns3);

        int tempAns4 = helper(grid, i1, j1 + 1, i2, j2 - 1, n); // top -> right bottom -> left
        ans = Math.max(ans, tempAns4);

        return ans + val;
    }
}
