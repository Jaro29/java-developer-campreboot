package pl.coderslab.advanced.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main01 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<String> strings = new ArrayList<>();
            System.out.println("Wpisuj dane, 'quit' kończy wprowadzanie:");
            while (true) {
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("quit")) {
                    break;
                }

                strings.add(input);
            }
            strings.sort(String::compareTo);
            System.out.println(strings);
        }
    }
}
