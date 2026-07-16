package pl.coderslab.advanced.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;

public class Main03 {
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>(List.of(
                0, 1, 1, 2, 2, 2, 2, 3, 6, 6,
                8, 22, 22, 22, 1, 4, 6, 8, 9, 23
        ));
        List<Integer> transformedList = create(integerList, s -> s < 20, s -> s - 1);
        System.out.println(transformedList);
    }
    static <T, S> List<T> create(List<S> src, Filter<S> f, Transform<T, S> t){
        ArrayList<T> list = new ArrayList<>();
        for (S s : src) {
            if (f.check(s)) {
                list.add(t.transform(s));
            }
        }
        return list;
    }
}
