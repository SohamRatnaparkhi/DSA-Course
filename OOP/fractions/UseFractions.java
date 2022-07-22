package OOP.fractions;

// import java.util.Scanner;

public class UseFractions {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter numerator - ");
        // int numerator = sc.nextInt();
        // System.out.print("Enter denominator - ");
        // int denominator = sc.nextInt();
        // System.out.println(numerator + " / " + denominator);
        Fraction f1 = new Fraction(4, 6);
        f1.print();
        // f.increment();
        Fraction f2 = new Fraction(4, 8);
        f2.print();
        Fraction addition = Fraction.add(f1, f2);
        addition.print();
        f1.add(f2);
        f1.print();
    }
}
