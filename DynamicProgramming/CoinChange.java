import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CoinChange {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int numDenominations = Integer.parseInt(br.readLine().trim());

        int denominations[] = new int[numDenominations];
        String[] strNums;
        strNums = br.readLine().split("\\s");

        for (int i = 0; i < numDenominations; ++i) {
            denominations[i] = Integer.parseInt(strNums[i]);
        }
        int value = Integer.parseInt(br.readLine().trim());

        System.out.println(countWaysToMakeChange(denominations, value));

    }

    public static int countWaysToMakeChange(int denominations[], int value) {
        // Write your code here
        int ans = helper(denominations, 0, 0, denominations.length, value, new HashMap<Tuple, Integer>());
        return ans;
    }

    static int c = 0;

    private static int helper(int[] nums, int sum, int i, int n, int key, HashMap<Tuple, Integer> dp) {
        if (i >= n) {
            return 0;
        }
        if (sum == key) {
            return 1;
        }
        if (sum > key) {
            return 0;
        }

        Tuple temp = new Tuple(i, sum);

        if (dp.get((temp)) != null) {
            return dp.get(temp);
        }

        sum += nums[i];
        int x = helper(nums, sum, i, n, key, dp);
        sum -= nums[i];
        int y = helper(nums, sum, i + 1, n, key, dp);

        dp.put(temp, x + y);

        return x + y;

    }
}

class Tuple {
    int x;
    int y;

    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }

}