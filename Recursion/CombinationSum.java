package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 */

public class CombinationSum {
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        combinationSum(new ArrayList<Integer>(), candidates, target, 0);
        for (List<Integer> a : ans) {
            System.out.println(a.toString());
        }
    }
    public static List<List<Integer>> combinationSum(List<Integer> p, int[] candidates, int target, int s) {
        if(target < 0){
            return new ArrayList<List<Integer>>();
        }
        if(target == 0){
            ans.add(p);
            return ans;
        }

        for (int i = s; i < candidates.length; i++) {
            p.add(candidates[i]);
            combinationSum(p, candidates, target - candidates[i], i);
            p.remove(p.size() - 1);
        }
        return ans;
    }
}
