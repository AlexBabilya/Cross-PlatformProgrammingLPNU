import java.math.BigInteger; 

public class BigFraction {
    private BigInteger numerator;
    private BigInteger denominator;

    public BigFraction(BigInteger numerator, BigInteger denominator) {
        this.numerator = numerator;
        if (!denominator.equals(BigInteger.ZERO)) {
           this.denominator = denominator;
        } else {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
    }

    public BigFraction add(BigFraction other) {
        BigInteger newNumerator = numerator.multiply(other.denominator)
                .add(other.numerator.multiply(denominator));
        BigInteger newDenominator = denominator.multiply(other.denominator);
        return new BigFraction(newNumerator, newDenominator);
    }

    public BigInteger getNumerator() {
        return numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    public void simplify() {
        BigInteger gcd = numerator.gcd(denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);
    }

    public double toDouble() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}

