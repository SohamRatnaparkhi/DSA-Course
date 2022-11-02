public class Knapsack01 {
    public static void main(String[] args) {
        int[] weights = { 1, 2, 4, 5 };
        int[] values = { 5, 4, 8, 6 };
        int k = 5;
        Integer[][] dp = new Integer[weights.length + 1][k + 1];
        int max = 0;
        max = table(weights, values, weights.length, k);
        System.out.println(max);
    }

    private static int table(int[] weights, int[] values, int n, int k) {
        int[][] dp = new int[n][k + 1];
        // base case
        for (int j = 0; j < k + 1; j++) {
            if (weights[0] <= j)
                dp[0][j] = values[0];
        }
		
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                int notTake = dp[i - 1][j];
                int take = 0;
                if (weights[i] <= j)
                    take = dp[i - 1][j - weights[i]] + values[i];

                dp[i][j] = Math.max(take, notTake);
            }
        }
        
        return dp[n - 1][k];
        
    }

    private static int maxWeight(int[] weights, int[] values, int i, Integer[][] dp, int k) {
        if (i >= weights.length) {
            return 0;
        }

        int w = weights[i];

        int ans = 0, ans1 = 0, ans2 = 0, ans3 = 0;
        if (w > k) {
            if (dp[i + 1][k] != null)
                ans = dp[i + 1][k];
            else {
                ans = maxWeight(weights, values, i + 1, dp, k);
                // dp[i + 1] = ans;
            }
        } else {
            if (dp[i+1][k] == null) {
                ans1 = values[i] + maxWeight(weights, values, i + 1, dp, k - w);
                ans2 = maxWeight(weights, values, i + 1, dp, k);
                // dp[i + 1] = Math.max(ans1, ans2);
                ans3 = Math.max(ans1, ans2);
            } else {
                ans3 = dp[i + 1][k];
            }
        }
        dp[i + 1][k] = Math.max(ans, ans3);
        return Math.max(ans, ans3);
    }
}