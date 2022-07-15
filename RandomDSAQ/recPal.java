package RandomDSAQ;

public class recPal {
    public static void main(String[] args) {
        String s = "ABCDBA";
        System.out.println(isPal(s, 0 , s.length() - 1));
    }

    private static boolean isPal(String s, int i, int j) {
        // return false;
        if(i >= j){
            return true;
        }
        else if(s.charAt(i) == s.charAt(j)){
            // char x = s.charAt(j);
            // char c = s.charAt(i);
            return isPal(s, i + 1, j - 1);
        }
        // return false;dshgaj
        return false;
    }
    // public static checkPalindrome(s)
}

