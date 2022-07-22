package OOP.DynamicArray;

import java.util.Arrays;

class dynamicArray {
    private int size = 5;
    private int arr[] = new int[size];
    int length = 0;

    public void add(int i) {
        // int this.length = this.length;
        if (this.length == size - 1) {
            doubleSize(arr);
        }
        arr[this.length++] = i;

    }

    public void pop(int index) {
        // index -= 1;
        for (int i = index; i < this.length; i++) {
            this.arr[i - 1] = this.arr[i];
        }
        this.length -= 1;
    }

    public int get(int index) {
        if (index >= this.length) {
            return 0;
        }
        return this.arr[index];
    }

    public void set(int index, int value) {
        if (index >= this.length) {
            System.out.println("Cannot set!");
        }
        this.arr[index] = value;
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
        // this.arr = Arrays.copyOfRange(arr2, 0, arr2.length);
    }

    public int[] getArray() {
        return this.arr;
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < this.length; i++) {
            System.out.print(this.arr[i]);
            if (i != this.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

}