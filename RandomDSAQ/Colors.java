import java.util.*;

public class Colors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int r = sc.nextInt(), b = sc.nextInt(), g = sc.nextInt();
            int ans = colorsOf(r, b, g);
            System.out.println(ans);
        }
    }

    private static int colorsOf(int r, int b, int g) {
        int ans = 0, minans = 0;
        if (r > 0) {
            minans++;
        }
        if (b > 0) {
            minans++;
        }
        if (g > 0) {
            minans++;
        }
        r = r > 0 ? r - 1 : r;
        b = b > 0 ? b - 1 : b;
        g = g > 0 ? g - 1 : g;

        if (r > 0 && b > 0) {
            ans++;
        }
        if (b > 0 && g > 0) {
            ans++;
        }
        if (g > 0 && r > 0) {
            ans++;
        }
        return Math.max(minans, minans+ans);
    }
}
