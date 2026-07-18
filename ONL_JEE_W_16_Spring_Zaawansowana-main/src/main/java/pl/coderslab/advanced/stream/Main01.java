package pl.coderslab.advanced.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Main01 {
    public static void main(String[] args) {
        List<String> words = List.of(
                "kot", "to", "książka", "latarka", "ręka", "jabłko", "drzewo", "armia", "asfalt", "ser", "sejf", "miasto", "okno",
                "pyż", "balon", "piosenka", "samochód", "krzesło", "kot", "książka"
        );

        words.stream()
                .filter(w -> w.startsWith("a") || w.startsWith("s"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);


        List<String> fiveLetterWords = words.stream()
                .filter(w -> w.length() == 5)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(fiveLetterWords);

        String result = words.stream()
                .sorted()
                .map(w -> w.substring(0, Math.min(3, w.length())))
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }
}
