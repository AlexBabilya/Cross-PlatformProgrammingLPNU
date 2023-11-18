public class SimpleFraction {
    private int numerator;
    private int denominator;

    public SimpleFraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator != 0) {
            this.denominator = denominator;
        } else {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
    }

    public SimpleFraction add(SimpleFraction other) {
        int newNumerator = numerator * other.denominator + other.numerator * denominator;
        int newDenominator = denominator * other.denominator;
        return new SimpleFraction(newNumerator, newDenominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void simplify() {
        int gcd = calculateGCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    private int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}

