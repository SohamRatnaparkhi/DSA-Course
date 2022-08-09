package TimeAndSpace;

import java.util.Arrays;

class TripletSum{
    public static void main(String[] args) {
        int[] arr = {6, 1, 6, 5, 3 ,2, 5, 0, 5, 6, 0 }; 
        System.out.println(tripletSum(arr, 5));
    }
    public static int tripletSum(int[] arr, int num) {
		//Your code goes here
        Arrays.sort(arr);

        int c = 0;
        for(int k = 0; k < arr.length; k++){
            int i = k + 1, j = arr.length - 1;
        	while (i <= j){
            	int sum = arr[i] + arr[j] + arr[k];
            	if(sum == num){
                    System.out.println(arr[k] + " " + arr[i] + " " + arr[j]);
                	c ++;
                	i ++;
                	j --;
            	}
            	else if(sum < num){
                	i ++;
           		}
            	else{
                	j --;
            	}
        	}
        }
        return c;
	}
}
