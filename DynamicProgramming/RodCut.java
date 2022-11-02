public class RodCut {
    public static void main(String[] args) {
        int[] price = {};
        int n = price.length;
        System.out.println(cutRod(price, n));
    }
    
    public static int cutRod(int price[], int n) {
        // Write your code here.
        return helper(price, n, n);
    }

    private static int helper(int price[], int n, int k) {

        // if (i == 0)

        // if (k == 0 || i == 0)
        // return 0;

        // int notTake = helper(price, i - 1, k);
        // int take = i <= k ? price[i - 1] + helper(price, i, k - i) : 0;

        int[][] dp = new int[n][k + 1];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                int notTake = dp[i - 1][j];
                int take = i <= j ? price[i - 1] + dp[i][j - i] : 0;
                dp[i][j] = Math.max(take, notTake);
            }
        }

        return dp[n - 1][k];
    }

}
