package Recursion2;

public class SubsetSumK {
    public static void main(String[] args) {
        int sum = 6;
        int[] arr = { 5, 12, 3, 17, 1, 18, 15, 3, 17 };
        subsetSum("", arr, sum, 0, 0);
    }

    private static void subsetSum(String possibleAns, int[] arr, int sum, int i, int currSum) {
        if (i >= arr.length) {
            if (currSum == sum) {
                System.out.println(possibleAns);
            }
            return;
        }

        int num = arr[i];
        currSum += num;
        subsetSum(possibleAns + " " + Integer.toString(num), arr, sum, i + 1, currSum);
        currSum -= num;
        subsetSum(possibleAns, arr, sum, i + 1, currSum);

    }
}
