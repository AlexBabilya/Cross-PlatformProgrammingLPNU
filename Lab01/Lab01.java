import java.math.BigInteger;
import java.util.Scanner;

public class Lab01 {
    public static SimpleFraction calculateSeriesSum(int n) {
        SimpleFraction sum = new SimpleFraction(0, 1);

        for (int i = 1; i <= n; i++) {
            SimpleFraction term = new SimpleFraction(1, i);
            sum = sum.add(term);
        }

        sum.simplify(); 
        return sum;
    }

    public static BigFraction calculateSeriesSum(BigInteger n) {
        BigFraction sum = new BigFraction(BigInteger.ZERO, BigInteger.ONE);

        for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            BigFraction term = new BigFraction(BigInteger.ONE, i);
            sum = sum.add(term);
        }

        sum.simplify();
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();
        
        if (n > 15) {
            BigFraction bigSum;
            bigSum = calculateSeriesSum(BigInteger.valueOf(n));
            bigSum.simplify();
            System.out.println("Sum of the series for n=" + n);
            System.out.println("Result as a fraction: " + bigSum);
            System.out.println("Result as a decimal: " + bigSum.toDouble());
        } else {
            SimpleFraction simpleSum;
            simpleSum = calculateSeriesSum(n);
            simpleSum.simplify();
            System.out.println("Sum of the series for n=" + n);
            System.out.println("Result as a fraction: " + simpleSum);
            System.out.println("Result as a decimal: " + simpleSum.toDouble());
        }
    }
}

