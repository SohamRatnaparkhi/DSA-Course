package Stack;

import java.util.Stack;

/*
 * For a given expression in the form of a string, find if there exist any redundant brackets or not. It is given that the expression contains only rounded brackets or parenthesis and the input expression will always be balanced.
A pair of the bracket is said to be redundant when a sub-expression is surrounded by unnecessary or needless brackets.
Example:
Expression: (a+b)+c
Since there are no needless brackets, hence, the output must be 'false'.

Expression: ((a+b))
The expression can be reduced to (a+b). Hence the expression has redundant brackets and the output will be 'true'.
Note:
You will not get a partial score for this problem. You will get marks only if all the test cases are passed.
Input Format :
The first and the only line of input contains a string expression, without any spaces in between.
Output Format :
The first and the only line of output will print either 'true' or 'false'(without the quotes) denoting whether the input expression contains redundant brackets or not.
 */

 
public class RedundantBracketes {
    public static void main(String[] args) {
        String s = "((x*y))";
        boolean ans = checkRedundantBrackets(s);
        System.out.println(ans);
    }

    private static boolean checkRedundantBrackets(String s) {
        /*
         * opening followed by closing without sign in btwn - true
         */

        Stack<Character> brackets = new Stack<>();
        int sign = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                sign = 0;
                brackets.push(c);
            }
            while (i < s.length() && s.charAt(i) != ')') {
                if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                    sign++;
                    i++;
                    break;
                } else if (s.charAt(i) == '(') {
                    sign = 0;
                    brackets.push(s.charAt(i));
                }
                i++;
            }
            if (s.charAt(i) == ')') {
                if (brackets.size() != 0) {
                    brackets.pop();
                } else {
                    return false;
                }

                if (sign == 0) {
                    return true;
                } else {
                    // i++;
                    sign -= 1;
                    continue;
                }
            }
        }
        return false;
    }
}
