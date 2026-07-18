package pl.coderslab.advanced.lambda;

import java.util.function.Consumer;

public class MethodReferences06 {
    public static void main(String[] args) {
        String[] strings = {"Ala", "kot", "Ola", "pies"};


        Consumer<String> printByLambda = s -> System.out.println(s);
        Consumer<String> printByReference = System.out::println;

        for (String s:strings){
            printByLambda.accept(s);
        }
        for (String s:strings){
            printByReference.accept(s);
        }

    }
}
