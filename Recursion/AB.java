package Recursion;

public class AB {
    public static void main(String[] args) {
        System.out.println(checkAB("abbaabb"));
    }

    public static boolean checkAB(String input) {
        // Write your code here
        if (input.charAt(0) == 'a') {
            String ans = checker(input);
            if (ans == "true") {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    static int flag = 0;
    public static String checker(String s) {
        if (s.length() == 0) {
            return "true";
        }
        char currChar = s.charAt(0);
        String nextStr = checker(s.substring(1));
        if (s.length() > 2) {
            char nextChar = s.charAt(1);
            char nnextChar = s.charAt(2);
            if(flag == 1) {
                if (currChar == 'b' && nextChar == 'b' && nnextChar == 'a') {
                    flag = 0;
                    return nextStr;
                } else {
                    return "false";
                }
            }
            
            if((currChar == 'a' && nextChar == 'b' && nnextChar == 'b') || (currChar == 'a' && nextChar == 'a')){
                return nextStr;
            } else if (currChar == 'b' && nextChar == 'b' && nnextChar == 'a') {
                return nextStr;
            } else {
                flag = 1;
                return nextStr;
            }
        }
        return nextStr;
    }
}
