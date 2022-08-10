package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * You are given an array of integers nums and an integer target. Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target. Since the answer may be too large, return it modulo 109 + 7.

 
Example 1:

Input: nums = [3,5,6,7], target = 9
Output: 4
Explanation: There are 4 subsequences that satisfy the condition.
[3] -> Min value + max value <= target (3 + 3 <= 9)
[3,5] -> (3 + 5 <= 9)
[3,5,6] -> (3 + 6 <= 9)
[3,6] -> (3 + 6 <= 9)
Example 2:

Input: nums = [3,3,6,8], target = 10
Output: 6
Explanation: There are 6 subsequences that satisfy the condition. (nums can have repeated numbers).
[3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
Example 3:

Input: nums = [2,3,3,4,6,7], target = 12
Output: 61
Explanation: There are 63 non-empty subsequences, two of them do not satisfy the condition ([6,7], [7]).
Number of valid subsequences (63 - 2 = 61).
 
 */
public class LC1498 {
    public static void main(String[] args) {
        int[] nums = {7,10,7,3,7,5,4,12};
        int target = 12;
        int ans = numSubseq(nums, target);
        System.out.println(ans);
    }


    private static int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = generateSubsets(0, target, nums, new ArrayList<Integer>());
        return ans;
    }
    static int c = 0;
    private static int generateSubsets(int i, int target, int[] nums, ArrayList<Integer> p) {
        if (nums.length <= i) {
            // System.out.println(ans.toString());
            if(! p.isEmpty()) {
                int sum = p.get(0) + p.get(p.size() - 1);
                if(sum <= target) {
                    System.out.println(p.toString());
                    System.out.println(sum + " " + c);
                    System.out.println();
                    c += 1;
                }
            }
            return c;
        }
        int num = nums[i];
        // sum += num;
        p.add(num);
        generateSubsets(i + 1, target, nums, p);

        // sum -= num;
        p.remove(p.size() - 1);
        generateSubsets(i + 1, target, nums, p);
        
        return c;
    }
}
