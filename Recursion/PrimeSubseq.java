package Recursion;

/*
 * Given a string consist of only 0 and 1 representing a decimal number in binary form. Find the largest prime number which is subsequence of this string.

Input: 1010
Output: 5
Input: 1011
Output: 11
 */
public class PrimeSubseq {
    public static void main(String[] args) {
        int largestPrime = subseq("", "1011");
        System.out.println(largestPrime);
    }
    static int max = -1;
    private static int subseq(String p, String up) {
        if(up.length() == 0) {
            // System.out.print(p);
            // System.out.println(p + " - " + decimal(p));
            int dec = decimal(p);
            if (isPrime(dec)) {
                max = Math.max(max, dec);
                // System.out.println(dec);
            }
            return 0;
        }
        subseq(p + up.charAt(0), up.substring(1));
        subseq(p , up.substring(1));

        return max;
    }

    private static boolean isPrime(int dec) {
        for (int i = 2; i <= (int)Math.pow(dec, 0.5); i++) {
            if (dec % i == 0) {
                return false;
            } 
        }
        return true;
    }

    private static int decimal(String p) {
        int power = p.length() - 1;
        int num = 0;
        for (int i = 0; i < p.length(); i++, power--) {
            int n = (int)(p.charAt(i) - '0');
            num = num + (int)(n * Math.pow(2, power));
        }
        return num;
    }
}
