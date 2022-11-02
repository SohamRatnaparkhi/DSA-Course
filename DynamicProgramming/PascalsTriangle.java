// package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> dp = new ArrayList<>();
        triangle(n, dp);
        System.out.println(dp);
    }

    private static void triangle(int n, List<List<Integer>> dp) {
        if (n == 1) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            dp.add(temp);
            return;
        }
        if (n > dp.size()) {
            triangle(n - 1, dp);
        } else {
            return;
        }
        
        List<Integer> temp = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                temp.add(1);
            } else {
                List<Integer> x = dp.get(n - 1 - 1);
                temp.add((x.get(i - 1)) + x.get(i));
            }
        }
        dp.add(temp);
    }
}
