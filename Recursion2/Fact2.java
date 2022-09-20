package Recursion2;

public class Fact2 {
    public static void main(String[] args) {
        int n = 5+5;
        factorial(1, n);
    }

    private static void factorial(int currFact, int n) {
        if (n == 0) {
            System.out.println(currFact);
            return;
        }
        currFact *= n;
        factorial(currFact, n - 1);
    }
}
