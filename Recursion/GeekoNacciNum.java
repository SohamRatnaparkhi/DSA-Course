package Recursion;

import java.util.Scanner;

public class GeekoNacciNum {
    public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		solver(t);
	}
	public static void solver(int t){
        while(t-- != 0){
            Scanner sc = new Scanner(System.in);
	        int a = sc.nextInt();
	        int b = sc.nextInt();
	        int c = sc.nextInt();
	        int n = sc.nextInt();
	        
	        int ans = geekoNacci(a, b, c, n, 4);
	        System.out.println(ans);
	    }
	}
	public static int geekoNacci(int a, int b, int c, int n, int i){
	    if(n == 0){
	        return c;
	    }
	    else if(n == 1){
	        return a;
	    }
	    else if(n == 2){
	        return b;
	    }
        else if(n == 3){
            return c;
        }
	    
	    int d =  geekoNacci(a, b, c, n - 1, i + 1) + geekoNacci(a, b, c, n - 2, i + 1) + geekoNacci(a, b, c, n - 3, i + 1);
        return d;
	}
    
}
