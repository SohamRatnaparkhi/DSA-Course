public class LC2435 {
    public static void main(String[] args) {

        int[][] arr = { { 5, 2, 4 }, { 3, 0, 5 }, { 0, 7, 2 } };
        Integer[][] dp = new Integer[arr.length][arr[0].length];
        int[] ans = new int[1];
        int k = 3;

        numberOfPaths(dp, arr, k, ans, 0, 0, 0, arr.length, arr[0].length, "");
        System.out.println(ans[0]);

    }

    private static int numberOfPaths(Integer[][] dp, int[][] arr, int k, int[] ans, int i, int j, int sum, int m,
            int n, String s) {
        if (i == m && j == n) {
            if (sum % k == 0) {
                ans[0]++;
                System.out.println(s);
            }
            return 0;
        }

        // int sum;
        // int down;

        if (i == m - 1) {
            for (int x = j + 1; x < n; x++) {
                sum += arr[i][x];
                s += arr[i][x];
            }
            if (sum % k == 0) {
                ans[0]++;
                System.out.println(s);
            }
            return 0;
        }

        if (j == n - 1) {
            for (int x = i + 1; x < m; x++) {
                s += arr[j][x];
                sum += arr[j][x];
            }
            if (sum % k == 0) {
                ans[0]++;
                System.out.println(s);
            }
            return 0;
        }

        s += arr[i][j] + " ";

        if (dp[i + 1][j] != null)
            sum = arr[i][j] + dp[i + 1][j];
        else {
            sum = arr[i][j] + numberOfPaths(dp, arr, k, ans, i + 1, j, sum, m, n, s);
        }

        if (dp[i][j + 1] != null)
            sum = arr[i][j] + dp[i][j + 1];
        else {
            sum = arr[i][j] + numberOfPaths(dp, arr, k, ans, i, j + 1, sum, m, n, s);
        }

        // int temp = sum;
        sum -= arr[i][j];

        return sum;

    }
}
