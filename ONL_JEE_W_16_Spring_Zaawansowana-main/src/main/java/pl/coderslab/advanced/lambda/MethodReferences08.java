package pl.coderslab.advanced.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MethodReferences08 {
    public static void main(String[] args) {
        Supplier<List<String>> byLambda = () -> new ArrayList<>();
        Supplier<List<String>> byReference = ArrayList::new;

        List<String> list1 = byLambda.get();
        List<String> list2 = byReference.get();

        list1.add("fortepian");
        list1.add("pianino");
        list2.add("fortepian");
        list2.add("pianino");

        System.out.println(list1);
        System.out.println(list2);
    }
}
