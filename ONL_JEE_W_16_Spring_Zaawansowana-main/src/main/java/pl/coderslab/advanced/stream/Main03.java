package pl.coderslab.advanced.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main03 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> result = numbers.stream().map(n -> n * n - 5)
                .filter(n -> n < 20)
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
