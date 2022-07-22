package OOP.complexNums;

public class ComplexNumbers {
	// Complete this class
    private int imaginary;
    private int real;

    public ComplexNumbers(int real, int imaginary) {
        this.imaginary = imaginary;
        this.real = real;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getReal() {
        return this.real;
    }

    public int getImaginary() {
        return this.imaginary;
    }

    public void print() {
        System.out.println(this.real + " +" + " i" + this.imaginary);
    }

    public void plus(ComplexNumbers c2) {
        this.real = this.real + c2.real;
        this.imaginary = this.imaginary + c2.imaginary;
    }

    public void multiply(ComplexNumbers c2) {
        int a = this.real;
        int b = this.imaginary;
        int c = c2.real;
        int d = c2.imaginary;

        setReal(a * c - b * d);
        setImaginary(a * d + b * c);
    }

    public static void print(ComplexNumbers c1) {
        System.out.println(c1.real + " +" + " i" + c1.imaginary);
    }
	
}
