package Recursion;

public class skipChar {
    public static void main(String[] args) {
        System.out.println(removeX("abcbdfvsbb", 'b'));
    }

    private static String removeX(String s, char x) {
        if(s.length() == 0){
            return s;
        }
        char c = s.charAt(0);
        String nextStr = removeX(s.substring(1), x);
        if(c != x){
            return c + nextStr;
        }
        else{
            return nextStr;
        }
        // return null;
    }
}
