package OOP.polynimials;

public class poluser {
    public static void main(String[] args) {

        Polynomial p1 = new Polynomial();
        p1.setCoefficients(2, 1);
        p1.setCoefficients(3, 2);
        p1.setCoefficients(6,4);
        // p1.setCoefficients(23, 5);
        p1.print();
        
        Polynomial p2 = new Polynomial();
        p2.setCoefficients(4, 3);
        p2.setCoefficients(2, 1);
        // p2.setCoefficients(1, 4);
        // p2.setCoefficients(2, 5);
        p2.print();

        System.out.println("addition");
        p1.add(p2);
        p1.print();

        System.out.println("subtraction");
        p1.subtract(p2);
        p1.subtract(p2);
        p1.print();

        p1.add(p2);
        System.out.println("multiplication");
        p1.multiply(p2);
        p1.print();
    }
}
