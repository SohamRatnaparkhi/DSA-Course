package Recursion;

public class removeSuccesive {
    public static void main(String[] args) {
            
        System.out.println(removeConsecutiveDuplicates("xxxyyzwwwwzzz"));
    }
    static String ans = "";
	public static String removeConsecutiveDuplicates(String s) {
		// Write your code here
		if(s.length() == 0){
            return s;
        }
        char c = s.charAt(0);
        // System.out.println(c);
        // System.out.println(s);
        String nextStr = removeConsecutiveDuplicates(s.substring(1));
        if(s.length() == 1){
            return c + nextStr;
        }
        if(s.length() > 1){
            char k = s.charAt(1);
            // System.out.println(c);
            // System.out.println(k);
            if(c != k){
                // ans += c;
                return c + nextStr;
                // System.out.println(ans);
            }
        }
        
        
        
        return nextStr;
    }
}
