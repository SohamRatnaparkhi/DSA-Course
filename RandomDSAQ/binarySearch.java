

// import java.lang.reflect.Array;

public class binarySearch{
    public static void main(String[] args) {
        /* 
         * 1 2 3
         * 4 5 6
         * 7 8 9
        */
        int[][] arr =   {{1, 2, 3}, 
                        {4, 5, 6}, 
                        {7, 8, 9}};
        int target = 4;

        binaryS2d(arr, 3, target);
    }

    private static void binaryS2d(int[][] arr, int n, int target) {
        
        int row = 0;
        int col = n - 1;
        while(row < n && col >= 0) {
            if(target == arr[row][col]) {
                row++;
                col++;
                System.out.println(row + " " + col + " ");
                return ;
            }
            else if(target > arr[row][col] ) {
                row++;
            }
            else if(target < arr[row][col]){
                col--;
            }
        }
        System.out.println(-1);
        return ;
    }

    
}