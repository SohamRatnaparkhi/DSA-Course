package Recursion;

public class Permutation {
    public static void main(String[] args) {
        permutations("", "abcdef");
        System.out.println();

    }

    private static String permutations(String p, String up) {
        if(up.length() == 0){
            // if(p.length() == 2)
                System.out.println(p);
            return p;
        }

        char c = up.charAt(0);
        for(int i = 0; i < p.length() + 1; i++){
            permutations(p.substring(0, i) + c + p.substring(i), up.substring(1));
        }
        return null;
    }
}
