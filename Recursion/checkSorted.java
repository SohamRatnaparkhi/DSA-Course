package Recursion;

public class checkSorted {
    public static void main(String[] args) {
       int arr[] = {1, 2, 3, 4, 8, 6};
       System.out.println(check(arr, 0)); 
    }

    private static boolean check(int[] arr, int i) {
        if(i + 1 == arr.length){
            return true;
        }
        if(arr[i] <= arr[i + 1]){
            return check(arr, i + 1);
        }
        else{
            return false;
        }
    }
}
