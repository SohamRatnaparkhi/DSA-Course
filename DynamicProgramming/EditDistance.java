import java.util.Scanner;

public class EditDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        // System.out.println(iterativeDp(s, t, new int[s.length() + 1][t.length() + 1]));
        System.out.println(distBtwn(s, t, 0, 0));
    }

    private static int distBtwn(String s, String t, int i, int j) {
        if (i >= s.length() || j >= t.length()) {
            return i == s.length() ? t.length() - j : s.length() - i;
        }
        int currAns;
        if (s.charAt(i) == t.charAt(j)) {
            currAns = distBtwn(s, t, i + 1, j + 1);
        } else {
            int x = 0, y = 0, z = 0;
            x = 1 + distBtwn(s, t, i + 1, j);
            y = 1 + distBtwn(s, t, i + 1, j + 1);
            z = 1 + distBtwn(s, t, i, j + 1);
            currAns = (Math.min(x, Math.min(y, z)));
        }
        return currAns;
    }
}

    // private static int iterativeDp(String s, String t, int[][] dp) {

    //     for (int i = s.length() - 1; i >= 0; i--) {
    //         for (int j = t.length() - 1; j >= 0; j--) {
    //             if (s.charAt(i) == t.charAt(j)) {
    //                 dp[i][j] = dp[i + 1][j + 1];
    //             } else {
    //                 dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
    //             }
    //         }
    //     }

    //     return dp[0][0];
    // }

// }
