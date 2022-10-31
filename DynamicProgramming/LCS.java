public class LCS {
    public static void main(String[] args) {
        String s = "abcde";
        String t = "ace";
        int ans = lcsTabular(s, t);
        System.out.println(ans);

        String lcs = printLCS(s, t);
        System.out.println(lcs);
    }

    private static String printLCS(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = s.length(), j = t.length();
        String lcs = "";
        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                lcs = s.charAt(i - 1) + lcs;
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        return lcs;

    }

    private static int lcsTabular(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s.length()][t.length()];

    }

    private static int lcs(String s, String t, int i, int j, Integer dp[][]) {
        if (i < 0 || j < 0)
            return 0;

        return (dp[i][j] != null) ? dp[i][j]
                : (dp[i][j] = s.charAt(i) == t.charAt(j) ? 1 + lcs(s, t, i - 1, j - 1, dp)
                        : (Math.max(lcs(s, t, i, j - 1, dp), lcs(s, t, i - 1, j, dp))));
    }
}
