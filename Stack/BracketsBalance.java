package Stack;

import java.util.Stack;

public class BracketsBalance {
    public static void main(String[] args) {
        String s = "()()(()";
        boolean balance = isBalanced(s);
        System.out.println(balance);
    }

    private static boolean isBalanced(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> openBr = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' && openBr.empty()) {
                return false;
            } else {
                if (c == ')') {
                    if(openBr.size() == 0){
                        return false;
                    }
                    openBr.pop();
                } else {
                    openBr.add('(');
                }
            } 
        }

        return openBr.size() == 0;
    }

}
