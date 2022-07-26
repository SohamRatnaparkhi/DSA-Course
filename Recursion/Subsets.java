package Recursion;

import java.util.ArrayList;

public class Subsets {
    public static void main(String[] args) {
        strSubsets("", "abc");
        System.out.println(ans);
        ArrayList<Integer> up = new ArrayList<Integer>();
        up.add(1);
        up.add(2);
        up.add(3);
        intSubsetes(new ArrayList<Integer>(), up, 0);
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
    private static void intSubsetes(ArrayList<Integer> p, ArrayList<Integer> up, int i) {
        if(up.size() <= i){
            System.out.println(p.toString());
            return;
        }
        int num = up.get(i);
        p.add(num);
        intSubsetes(p, up, i + 1);
        p.remove(p.size() - 1);
        intSubsetes(p, up, i + 1);
    }
}
