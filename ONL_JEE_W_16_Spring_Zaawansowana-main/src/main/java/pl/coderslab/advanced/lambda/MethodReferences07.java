package pl.coderslab.advanced.lambda;

import java.util.function.Function;

public class MethodReferences07 {
    public static void main(String[] args) {
        Function<String, String> byLambda = s -> s.toUpperCase();
        Function<String, String> byReference = String::toUpperCase;

        System.out.println(byLambda.apply("hello"));
        System.out.println(byReference.apply("hello"));
    }
}
