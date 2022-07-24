package Recursion;

public class Dice {
    public static void main(String[] args) {
        possibleComb("", 5);
    }

    private static void possibleComb(String p, int up) {
        if(up == 0){
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= up; i++) {
            // p += Integer.toString(i);
            possibleComb(p + Integer.toString(i), up - i);
        }
    }
}
