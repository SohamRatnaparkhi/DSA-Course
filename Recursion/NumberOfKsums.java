package Recursion;

public class NumberOfKsums {
    public static void main(String[] args) {
        int[] nums = {3,5,6,7};
        int target = 9;
        int ans = numSubseq(nums, target);
        System.out.println(ans);
    }


    private static int numSubseq(int[] nums, int target) {
        int ans = generateSubsets(0, target, nums, 0);
        return ans;
    }
    static int c = 0;
    private static int generateSubsets(int i, int target, int[] nums, int sum) {
        if (nums.length <= i) {
            // System.out.println(sum);
            if(sum <= target && sum != 0) {
                System.out.println(sum + " " + c);
                c+=1;
            }
            return c;
        }
        int num = nums[i];
        sum += num;
        generateSubsets(i + 1, target, nums, sum);
        sum -= num;
        generateSubsets(i + 1, target, nums, sum);

        return c;
    }
    
}
