package pl.coderslab.advanced.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;

public class Main01 {
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>(List.of(
                0, 1, 1, 2, 2, 2, 2, 3, 6, 6,
                8, 22, 22, 22, 1, 4, 6, 8, 9, 23
        ));

        // 1. obiekt klasy IntegerFilter
        printList(integerList,new IntegerFilter());


        // 2. klasa anonimowa
        printList(integerList, new Filter<Integer>() {
            @Override
            public boolean check(Integer v) {
                return v < 20;
            }
        });

        // 3. wyrażenie lambda
        printList(integerList, v -> v < 20);
    }

    static <T> void printList(List<T> src, Filter<T> f) {
        for (T s : src) {
            if (f.check(s)) {
                System.out.println(s);
            }
        }
        System.out.println();
    }
}
