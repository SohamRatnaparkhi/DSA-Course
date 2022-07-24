package Recursion;

import java.util.ArrayList;

public class Subsets {
    public static void main(String[] args) {
        strSubsets("", "abc");
        System.out.println(ans);
    }
    static ArrayList<String> ans = new ArrayList<String>();
    private static String strSubsets(String p, String up) {
        if(up.length() == 0){
            ans.add(p);
            return p;
        }
        char c = up.charAt(0);
        strSubsets(p + c, up.substring(1));
        strSubsets(p, up.substring(1));
        return null;
    }
}
