package pl.coderslab.advanced.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main03 {
    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>(List.of(
                0, "1", 1, "2", "asjkhdfasdf", 2, 2.45,
                new int[]{2, 5, 6, 8, 9}, 6,
                new String[]{"sadf", "rty", "ertgyu"}
        ));

        Predicate<Object> isNumber = o -> o instanceof Number;

        for (Object o : objects) {
            if (isNumber.test(o)) {
                System.out.println(o);
            }
        }
    }
}