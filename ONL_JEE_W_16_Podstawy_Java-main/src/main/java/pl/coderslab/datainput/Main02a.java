package pl.coderslab.datainput;

import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main02a {
    public static void main(String[] args) {
        operations();
    }

    public static void operations() {
        try (Scanner scanner = new Scanner(System.in)) {

            int a = readInt(scanner, "Podaj pierwszą liczbę całkowitą: ");
            int b = readInt(scanner, "Podaj drugą liczbę całkowitą: ");
            System.out.println(a+b);
        }
/*
        catch (NoSuchElementException | IllegalStateException e) {
            // Bezpieczne zamknięcie w przypadku awarii strumienia (Ctrl+D)
            System.out.println("\n[Krytyczny błąd] Strumień konsoli został zamknięty (Ctrl+D). Zamykanie programu...");
            System.exit(1);
        }
        */


    }

    private static int readInt(Scanner scanner, String message) {
        while (true) {
            System.out.println(message);
            try {
                String input = scanner.nextLine().trim();
                try (Scanner lineScanner = new Scanner(input).useLocale(Locale.getDefault())) {
                    if (lineScanner.hasNextInt()) {
                        int value = lineScanner.nextInt();
                        if (!lineScanner.hasNext()) {
                            return value;
                        }
                    }
                }
                System.out.println("Błąd: Wprowadzona wartość nie jest poprawną liczbą całkowitą.");
            } catch (NoSuchElementException | IllegalStateException e) {
                // Bezpieczne zamknięcie w przypadku awarii strumienia (Ctrl+D)
                System.out.println("\n[Krytyczny błąd] Strumień konsoli został zamknięty (Ctrl+D). Zamykanie programu...");
                System.exit(1);
            }
        }
    }
}
