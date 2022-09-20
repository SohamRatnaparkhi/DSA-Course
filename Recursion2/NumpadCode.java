package Recursion2;

import java.util.Scanner;

public class NumpadCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        String num = Integer.toString(input);
        numpadValues(num, "");
    }

    private static void numpadValues(String num, String currPerm) {
        if (num.isEmpty()) {
            System.out.println(currPerm);
            return;
        }
        String temp = lettersIn(num.charAt(0));
        for (int i = 0; i < temp.length(); i++) {
            numpadValues(num.substring(1), currPerm + temp.charAt(i));
        }
    }

    private static String lettersIn(char c) {
        String ans = "";
        if (c == '2')
            ans = "abc";
        else if (c == '3')
            ans = "def";
        else if (c == '4')
            ans = "ghi";
        else if (c == '5')
            ans = "jkl";
        else if (c == '6')
            ans = "mno";
        else if (c == '7')
            ans = "pqrs";
        else if (c == '8')
            ans = "tuv";
        else
            ans = "wxyz";

        return ans;
    }
}
