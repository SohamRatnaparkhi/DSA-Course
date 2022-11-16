public class CoinTower {
    public static void main(String[] args) {
        int n = 4, x = 2, y = 3;
        String a = "b";
        String b = "w";
        System.out.println(winner(n, x, y, 0, a, b));
        System.out.println(ans);
    }

    static String ans = "";

    private static String winner(int n, int x, int y, int i, String a, String b) {
        if (n < 0) {
            return b;
        }
        if(n == 1 || n == x || n == y)
            return a;
        
        String w;
        w = winner(n - 1, x, y, i, a, b);
        w = winner(n - x, x, y, i, a, b);
        w = winner(n - y, x, y, i, a, b);

        w = winner(n - 1, x, y, i, b, a);
        w = winner(n - x, x, y, i, b, a);
        w = winner(n - y, x, y, i, b, a);

        return w;
    } 
}
