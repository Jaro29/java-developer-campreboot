package pl.coderslab.advanced.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;

public class Main02 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(List.of(
                0, 1, 1, 2, 2, 2, 2, 3, 6, 6,
                8, 22, 22, 22, 1, 4, 6, 8, 9, 23
        ));

        printList(integerList,s -> s < 20,new IntegerTransform());
        System.out.println();
        printList(integerList, new Filter<Integer>() {
            @Override
            public boolean check(Integer integer) {
                return integer < 20;
            }
        }, new Transform<Integer, Integer>() {
            @Override
            public Integer transform(Integer integer) {
                return integer-1;
            }
        });
        System.out.println();
        printList(integerList, s -> s < 20, s -> s - 1);
    }

    static <T, S> void printList(List<S> src, Filter<S> f, Transform<T, S> t) {
        for (S s : src) {
            if (f.check(s)) {
                System.out.println(t.transform(s));
            }
        }
    }
}
