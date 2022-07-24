package Recursion;
import java.util.*;
public class SplitArray {
    static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = s.nextInt();
		int input[] = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		System.out.println(splitArray(input));
	}
    public static boolean splitArray(int input[]) {
		/* Your class should be named solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
        // Arrays.sort(input);
		int sumThree = 0, sumFive = 0;
        ArrayList<Integer> others = new ArrayList<Integer>();
        for(int i : input){
            if(i % 3 == 0) sumThree += i;
            else if(i % 5 == 0) sumFive += i;
            else{
                if(i < 0) i *= -1;
                others.add(i);
            }
        }
        // if(sumThree == 0 && sumFive == 0){
        //     return others.size() == 0;
        // }
        // else{
            Collections.sort(others);   
            for(int i = others.size() - 1; i > -1; i --){
                if(others.get(i) > 0){
                    if(sumThree <= sumFive){
                    	sumThree += others.get(i);
                	}  
                	else{
                    	sumFive += others.get(i);
                	}
                }
                // else{
                //     if(sumThree <= sumFive){
                //     	sumFive += others.get(i);
                // 	}  
                // 	else{
                //     	sumThree += others.get(i);
                // 	}
                // }
              	
            }
        // }
        return sumThree == sumFive;
	}
	
}
