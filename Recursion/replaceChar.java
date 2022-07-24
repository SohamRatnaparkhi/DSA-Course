package Recursion;

public class replaceChar {
    public static void main(String[] args) {
        char a = 'a';
        char b = 'b';
        String s = "aaaaccssfsa";
        int startIndex = 0;
        
        System.out.println(replace(a, b, s, startIndex));
    }
    static String replacedStr = "";
    private static String replace(char a, char b, String s, int i) {
        if(i == s.length()) {
            return replacedStr;
        }
        char c = s.charAt(i);
        if(c == a){
            c = b;
        }
        replacedStr += c;
        return replace(a, b, s, i + 1);
    }    
}

