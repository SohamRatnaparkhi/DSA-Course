package Recursion2;

public class PermutationsStr {
    public static void main(String[] args) {
        String s = "abc";
        permutations(s, "");
    }

    private static void permutations(String s, String currAns) {
        if (s.isEmpty()) {
            System.out.println(currAns);
            return;
        }
        char c = s.charAt(0);
        for (int i = 0; i < currAns.length() + 1; i++) {
            String temp = currAns.substring(0, i) + c + currAns.substring(i);
            permutations(s.substring(1), temp);
        }
    }
}
