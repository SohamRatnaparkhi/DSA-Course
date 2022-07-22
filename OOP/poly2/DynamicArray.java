package OOP.poly2;

public class DynamicArray {
    int size = 5;
    private int arr[] = new int[size];
    int length = 0;

    public void add(int i) {

        if (this.length == size - 1) {
            doubleSize(arr);
        }
        arr[this.length++] = i;

    }

    public void pop(int degree) {

        for (int i = degree; i < this.length; i++) {
            this.arr[i - 1] = this.arr[i];
        }
        this.length -= 1;
    }

    public int get(int degree) {
        if (degree >= this.size) {
            doubleSize(this.arr);
        }
        return this.arr[degree];
    }

    public void set(int degree, int coeff) {
        while(degree >= this.size) {
            doubleSize(this.arr);
        }
        this.arr[degree] = coeff;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public int pop() {
        this.length -= 1;
        return this.arr[this.length - 1];
    }

    private void doubleSize(int[] arr2) {
        this.size *= 2;
        this.arr = new int[this.size];
        for (int i = 0; i < arr2.length; i++) {
            this.arr[i] = arr2[i];
        }
    }

    public int[] getArray() {
        return this.arr;
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            if(this.arr[i] == 0) continue;
            System.out.print(this.arr[i] + "x^" + i + " ");
        }
    }
}
