package pl.coderslab.advanced.lambda;

import java.math.BigInteger;

public class Main04 {
    public static void main(String[] args) {

        Calculate<BigInteger> factorial = x -> {
            if (x.compareTo(BigInteger.ZERO) < 0) {
                throw new IllegalArgumentException("n musi być >= 0");
            }

            BigInteger result = BigInteger.ONE;

            for (BigInteger i = BigInteger.TWO;
                 i.compareTo(x) <= 0;
                 i = i.add(BigInteger.ONE)) {

                result = result.multiply(i);
            }

            return result;
        };

        Calculate<Double> square = x -> x * x;

        Calculate<Double> squareRoot = Math::sqrt;

        System.out.println(factorial.calculate(BigInteger.valueOf(35)));
        System.out.println(square.calculate(23.4));
        System.out.println(squareRoot.calculate(843756.4));

    }
}
