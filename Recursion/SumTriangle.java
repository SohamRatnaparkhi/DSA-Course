package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class SumTriangle {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 1; i <= 5; i++) {
            a.add(i);
        }
        triangleSum(a, 0, new ArrayList<Integer>());    
        System.out.println(a.toString());
        printTriangle(a);
    }

    private static ArrayList<Integer> triangleSum(ArrayList<Integer> a, int i, ArrayList<Integer> nextList) {
        if (a.size() == 1) {
            // System.out.println(a.toString());
            return a;
        }
        if(a.size() - 1 == i) {
            a = nextList;
            nextList = new ArrayList<Integer>();
            triangleSum(a, 0, nextList);
            System.out.println(a.toString());
            return a;
        }
        
        int sum = a.get(i) + a.get(i + 1);
        nextList.add(sum);
        return triangleSum(a, i + 1, nextList);
        
    }

    private static void printTriangle(ArrayList<Integer> a){
        if(a.size() < 1){
            return;
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < a.size() - 1; i++) {
            arr.add(a.get(i) + a.get(i + 1));            
        }
        printTriangle(arr);
        System.out.println(arr.toString());
    }

}
