package Recursion;

public class replaceStr {
    public static void main(String[] args) {
        String a = "pi";
        String b = "3.14";
        String s = "ppiipiccssfspiipi";
        
        System.out.println(replacePi(s));
    }
    // static String replacedStr = "";
    private static String replacePi(String s) {
        if(s.length() <= 1){
            return s;
        }

        if(s.charAt(0) == 'p' && s.charAt(1) == 'i'){
            String temp = replacePi(s.substring(2));
            return ("3.14" + temp);
        }
        else{
            String temp = replacePi(s.substring(1));
            return s.charAt(0) + temp;
        }
    }
}
