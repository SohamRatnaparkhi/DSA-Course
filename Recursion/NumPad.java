package Recursion;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class NumPad {
    public static void main(String[] args) {
        System.out.println(letterCombinations("234").toString());
    }   
    public static List<String> letterCombinations(String digits) {
        return combinationGenerator("", digits);
    }
    static List<String> ans = new ArrayList<String>();
    
    public static List<String> combinationGenerator(String p, String up){
        // System.out.println("processes - " + p + " \n" + "un-processed - " + up + " \n");
        if(up.isEmpty()){
            ans.add(p);
            return ans;
        }
        int currentDigit = up.charAt(0) - '0';
        String letters = charsOf(currentDigit);
        for (int i = 0; i < letters.length(); i++) {
            char c = letters.charAt(i);
            combinationGenerator(p + c, up.substring(1));
        }
        return ans;
    }
    public static String charsOf(int num){
        if(num <= 1){
            return "";
        }
        String ans = "";
        int firstCharAscii = num * 3 + 91;  
        if(num >= 8){
            firstCharAscii ++;
        }
        int i = firstCharAscii;
        for(; i < firstCharAscii + 3; i++){
            ans += (char)i;
        }
        if(num == 7 || num == 9){
            ans += (char)(i);
        }
        return ans;
    }
}
