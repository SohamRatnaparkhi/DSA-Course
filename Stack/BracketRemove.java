package Stack;

import java.util.Stack;

/*
 * Leetcode 1249 
 * Given a string s of '(' , ')' and lowercase English characters. Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
 */
public class BracketRemove {
    public static void main(String[] args) {
        String s = "";
        String ans = minRemoveToMakeValid(s);
        System.out.println(ans);
    }

    private static String minRemoveToMakeValid(String s) {
        Stack<Character> t = new Stack<>();
        String ans = "";
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c != '(' || c != ')') {
                ans += c;
            } else {
                if (c == '(') {
                    t.push(c);
                } else {
                    
                }
            }
            i++;
        }
        return ans;
    }
}
