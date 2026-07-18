package pl.coderslab.advanced.lambda;

public class MethodRefereces05 {
    public static void main(String[] args) {
        Converter<String,Integer> toIntegerByLambda = s -> Integer.parseInt(s);
        Converter<String,Integer> toIntegerByReference = Integer::parseInt;

        System.out.println(toIntegerByLambda.convert("1969"));
        System.out.println(toIntegerByReference.convert("1969"));

    }
}
