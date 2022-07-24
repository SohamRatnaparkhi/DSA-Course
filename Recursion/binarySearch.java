package Recursion;

public class binarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,6,7};
        System.out.println(binarysearch(arr, 0, arr.length - 1, 6));
    }

    private static int binarysearch(int[] arr, int s, int e, int target) {
        if(s > e){
            return -1;
        }
        int mid = s + (e - s) / 2;
        if(arr[mid] == target){
            return mid;
        }
        else if(arr[mid] < target){
            s = mid + 1;
            return binarysearch(arr, s, e, target);
        }
        else{
            e = mid - 1;
            return binarysearch(arr, s, e, target);
        }
        // return -1;return 
    }
}
