package TimeAndSpace;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1,3,6,11,12,17};
        int d = 4;
        rotate(arr, d);
        System.out.println(java.util.Arrays.toString(arr));
    }
    public static void rotate(int[] arr, int d) {
    	//Your code goes here
        arr = rotated(arr, d);
    }
    public static int[] rotated(int[] arr, int d){
        int[] ans = new int[arr.length];
        int x = d;
        for(int i = 0; i < x; i ++){
            ans[arr.length - d] = arr[i];
            d --;
        }
        // d --;
        for(int i = x; i < arr.length; i ++){
            ans[d ++] = arr[i];
        }
        return ans;
    }
}
