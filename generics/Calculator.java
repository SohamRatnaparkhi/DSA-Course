package generics;

public class Calculator {
    public static void main(String[] args) {
        
        Number<Integer> x = new Number<Integer>(1, 2);
        int result = x.getNum1() + x.getNum2();
        System.out.println(result);

        Number<Double> y = new Number<Double>(1.0, 2.0);
        double result2 = x.getNum1() + x.getNum2();
        System.out.println(result2);
        
    }
}
