package TimeAndSpace;

import java.util.*;
public class Solution {
    
    public static void main(String[] args) {
        int[] arr1 = {6, 9, 8, 5};
        int[] arr2 = {9, 2, 4, 1, 8};
        intersection(arr1, arr2);
    }

	public static void intersection(int[] arr1, int[] arr2) {
	    //Your code goes here
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr = inter(arr1, arr2);
        for(int i : arr){
            System.out.print(i + " ");
        }
	}
    public static ArrayList<Integer> inter(int[] arr1, int[] arr2) {
    	// Arrays.sort(arr2);
    	Arrays.sort(arr1);
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        int i = 0, j = 0; // i -> arr2    j ->  arr1
        while(j < arr2.length){
            if(binarySearch2(arr2[j], arr1, i) != -1){
                arr.add(arr2[j]);
                i++;
            }
            j++;
        }
        // while(j < arr2.length){
        //     if(binarySearch2(j, arr1) != -1){
        //         arr.add(i);
        //     }
        //     j++;
        // }
        
        return arr;
        
    }
    
    public static int binarySearch2(int target, int[] arr, int s){
        // int s = 0;
        int e = arr.length - 1;
    	while(s <= e){
        int mid = s + (e - s) / 2;
            
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }
        return -1;
    }
}