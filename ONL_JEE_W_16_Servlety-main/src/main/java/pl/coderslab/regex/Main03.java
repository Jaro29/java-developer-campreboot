package pl.coderslab.regex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main03 {

    private static final String REGEX = "[0-9]+([-+*/][0-9]+)*=[0-9]+";
    public static final Pattern PATTERN = Pattern.compile(REGEX);

    public static void main(String[] args) {
        Path file = Path.of("operations.txt");
        List<String> operations = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Wpisz działanie matematyczne. " +
                    "'Quit' kończy wpisywanie.");
            while (true) {
                String input = readString(scanner, "-> ");
                if (input.equalsIgnoreCase("quit")) {
                    break;
                }
                input = input.replaceAll("\\s", "");
                Matcher matcher = PATTERN.matcher(input);
                if (matcher.matches()) {
                    operations.add(input);
                }
            }
            try {
                Files.write(file, operations);
            } catch (IOException ex) {
                System.out.println("Nie można zapisać pliku.");
            }
        }
    }

    public static String readString(Scanner scanner, String message) {
        int consecutiveEnters = 0;

        while (true) {
            System.out.print(message);
            try {
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    consecutiveEnters++;
                    if (consecutiveEnters >= 2) {
                        System.out.println("-> Wskazówka: Pole nie może być puste.");
                        consecutiveEnters = 0;
                    }
                    continue;
                }
                return input; // sukces

            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("\n[Krytyczny błąd] Strumień konsoli został zamknięty (Ctrl+D). Zamykanie programu...");
                System.exit(1);
                return ""; // wymagane przez kompilator, nigdy się nie wykona
            }
        }
    }
}
