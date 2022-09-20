package Recursion2;

public class Subseqences {
    public static void main(String[] args) {
        String s = "abc";
        subseq(s, "");
    }

    private static void subseq(String s, String possAns) {
        if (s.isEmpty()) {
            System.out.println(possAns);
            return;
        }
        char c = s.charAt(0);
        subseq(s.substring(1), possAns + c);
        subseq(s.substring(1), possAns);
    }
}
