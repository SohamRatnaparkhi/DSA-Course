package generics;

public class Number<T> {
    /*
     * Generic class for getting and setting numbers of Object type
    */
    private T num1, num2;
    Number(T num1, T num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    public T getNum1() {
        return this.num1;
    }

    public T getNum2() {
        return this.num2;
    }

    public void setNum1(T num1){
        this.num1 = num1;
    }
    public void setNum2(T num2) {
        this.num2 = num2;
    }
}
