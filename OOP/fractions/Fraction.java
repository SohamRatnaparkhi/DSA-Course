package OOP.fractions;

class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        simplify(numerator, denominator);
    }

    public Fraction() {
        this.numerator = 1;
        this.denominator = 1;
    }

    private void simplify(int numerator, int denominator) {
        int gcd = gcd(numerator, denominator);
        setNumerator(numerator / gcd);
        setDenominator(denominator / gcd);
    }

    private static int gcd(int a, int b) {
        int g = 1, i = 1;
        while (i <= Math.min(a, b)) {
            if (a % i == 0 && b % i == 0) {
                g = i;
            }
            i++;
        }
        return g;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator != 0) {
            this.denominator = denominator;
        } else {
            this.denominator = 1;
            System.out.println("Cannot set dnomenator as zero so setting to 1");
            return;
        }
    }

    public void print() {
        System.out.println("Reduced fraction: " + this.numerator + " / " + this.denominator);
    }

    public void increment() {
        numerator = (numerator + denominator);
        simplify(numerator, denominator);
    }

    public static Fraction add(Fraction f1, Fraction f2) {
        Fraction ans =  new Fraction();
        int n1 = f1.getNumerator();
        int d1 = f1.getDenominator();

        int n2 = f2.getNumerator();
        int d2 = f2.getDenominator();

        // todo: Addition
        //? 1 - LCM of d1 and d2
        int lcm = lcm(d1, d2);

        //? 2 - Multiply n1, d1, n2 , d2 by lcm/d
        n1 *= lcm/d1;
        n2 *= lcm/d2;
        d1 *= lcm/d1;
        d2 *= lcm/d2;

        //? 3 - add new n1 and n2
        int num = n1 + n2;
        int den = d1;

        //? 4 - simplify
        int gcd = gcd(num, den);        

        ans.setNumerator(num / gcd);
        ans.setDenominator(den / gcd);

        return ans;
    }

    private static int lcm(int d1, int d2) {
        return (d1 * d2) / gcd(d1, d2);
    }

    public void add(Fraction f2) {
        int n1 = this.getNumerator();
        int d1 = this.getDenominator();

        int n2 = f2.getNumerator();
        int d2 = f2.getDenominator();

        // todo: Addition
        //? 1 - LCM of d1 and d2
        int lcm = lcm(d1, d2);

        //? 2 - Multiply n1, d1, n2 , d2 by lcm/d
        n1 *= lcm/d1;
        n2 *= lcm/d2;
        d1 *= lcm/d1;
        d2 *= lcm/d2;

        //? 3 - add new n1 and n2
        int num = n1 + n2;
        int den = d1;

        //? 4 - simplify
        int gcd = gcd(num, den);        

        this.setNumerator(num / gcd);
        this.setDenominator(den / gcd);
    }
}