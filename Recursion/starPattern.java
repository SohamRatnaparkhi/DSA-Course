package Recursion;

public class starPattern {
    public static void main(String[] args) {
        int n = 5;
        Pattern1(n, 0);
    }

    private static void Pattern1(int r, int c) {
        if(r == 0) return;
        if(r > c){
            System.out.print("* ");
            Pattern1(r, c + 1);
        }
        else{
            System.out.println();
            Pattern1(r - 1, 0);
        }

    }
}
