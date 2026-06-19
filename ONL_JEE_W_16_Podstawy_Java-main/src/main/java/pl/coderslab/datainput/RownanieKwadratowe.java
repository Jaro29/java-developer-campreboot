package pl.coderslab.datainput;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RownanieKwadratowe {

    public static void main(String[] args) {
        // Ustawienie domyślnej lokalizacji (np. US wymusza kropkę w liczbach zmiennoprzecinkowych)
        Locale.setDefault(Locale.US);
        //Locale.setDefault(Locale.of("pl", "PL"));

        // Wywołanie głównej metody programu
        equation();
    }

    /**
     * Główna metoda zarządzająca procesem obliczania pierwiastków równania kwadratowego.
     * Zawiera pętlę pozwalającą na wielokrotne uruchomienie obliczeń.
     */
    public static void equation() {
        // Blok try-with-resources automatycznie zamknie scanner po zakończeniu działania metody
        try (Scanner scanner = new Scanner(System.in)) {
            boolean continueProgram;

            do {
                System.out.println("\n=== Obliczanie pierwiastków równania kwadratowego ax² + bx + c = 0 ===");

                // Pobranie i walidacja współczynników
                double a = readNonZeroDouble(scanner, "Wprowadź współczynnik a: ");
                double b = readDouble(scanner, "Wprowadź współczynnik b: ");
                double c = readDouble(scanner, "Wprowadź współczynnik c: ");

                System.out.printf("\nTwoje równanie: %.2fx² + %.2fx + %.2f = 0%n", a, b, c);

                // Obliczenie delty i pierwiastków
                calculateRoots(a, b, c);

                // Zapytanie o ponowne uruchomienie
                continueProgram = readYesNo(scanner, "\nCzy chcesz obliczyć kolejne równanie? (T/N): ");

            } while (continueProgram);

            System.out.println("\nDziękuję za skorzystanie z programu. Do zobaczenia!");
        }
    }

    /**
     * Bezpiecznie pobiera odpowiedź Tak/Nie (T/N) od użytkownika.
     */
    private static boolean readYesNo(Scanner scanner, String message) {
        int consecutiveEnters = 0;

        while (true) {
            System.out.print(message);
            try {
                String input = scanner.nextLine().trim().toLowerCase();

                if (input.isEmpty()) {
                    consecutiveEnters++;
                    if (consecutiveEnters >= 2) {
                        System.out.println("-> Wskazówka: Wpisz 'T' (tak) lub 'N' (nie), aby kontynuować.");
                        consecutiveEnters = 0;
                    }
                    continue;
                }

                consecutiveEnters = 0; // Reset licznika

                if (input.equals("t") || input.equals("tak")) {
                    return true;
                } else if (input.equals("n") || input.equals("nie")) {
                    return false;
                }

                System.out.println("Błąd: Niepoprawna odpowiedź. Wpisz T (Tak) lub N (Nie).");

            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("\n[Krytyczny błąd] Strumień konsoli został zamknięty. Zamykanie programu...");
                System.exit(1);
            }
        }
    }

    /**
     * Oblicza wyróżnik (deltę) oraz wyznacza pierwiastki równania.
     */
    private static void calculateRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - (4 * a * c);
        System.out.printf("Wyróżnik równania (Delta) = %.4f%n%n", delta);

        if (delta > 0) {
            double x1 = (-b - Math.sqrt(delta)) / (2 * a);
            double x2 = (-b + Math.sqrt(delta)) / (2 * a);
            System.out.println("Równanie ma dwa różne pierwiastki rzeczywiste:");
            System.out.printf("x1 = %.4f%n", x1);
            System.out.printf("x2 = %.4f%n", x2);
        } else if (delta == 0) {
            double x0 = -b / (2 * a);
            System.out.println("Równanie ma jeden pierwiastek podwójny:");
            System.out.printf("x0 = %.4f%n", x0);
        } else {
            System.out.println("Delta < 0. Równanie nie ma rozwiązań w zbiorze liczb rzeczywistych.");
        }
    }

    /**
     * Pobiera liczbę typu double dbając o to, by była ona różna od zera.
     */
    private static double readNonZeroDouble(Scanner scanner, String message) {
        while (true) {
            double value = readDouble(scanner, message);
            if (value != 0.0) {
                return value;
            }
            System.out.println("Błąd: Współczynnik 'a' nie może być równy 0 w równaniu kwadratowym!");
        }
    }

    /**
     * Bezpiecznie pobiera liczbę zmiennoprzecinkową z konsoli.
     * Reaguje na puste linie (entery) oraz błędy formatu danych.
     */
    private static double readDouble(Scanner scanner, String message) {
        int consecutiveEnters = 0;

        while (true) {
            System.out.print(message);

            try {
                String input = scanner.nextLine().trim();

                // Obsługa wielokrotnego naciśnięcia klawisza Enter
                if (input.isEmpty()) {
                    consecutiveEnters++;
                    if (consecutiveEnters >= 2) {
                        System.out.println("-> Wskazówka: Musisz wprowadzić wartość liczbową, aby przejść dalej.");
                        consecutiveEnters = 0;
                    }
                    continue;
                }

                consecutiveEnters = 0; // Reset licznika po wprowadzeniu jakichkolwiek znaków

                // Parsowanie linii za pomocą dedykowanego pod-skanera
                try (Scanner lineScanner = new Scanner(input)) {
                    if (lineScanner.hasNextDouble()) {
                        double value = lineScanner.nextDouble();
                        // Sprawdzenie czy w linii nie ma dodatkowych niepoprawnych znaków (np. "4.5abc")
                        if (!lineScanner.hasNext()) {
                            return value;
                        }
                    }
                }

                System.out.println("Błąd: Wprowadzona wartość nie jest poprawną liczbą rzeczywistą.");

            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("\n[Krytyczny błąd] Strumień konsoli został zamknięty. Zamykanie programu...");
                System.exit(1);
            }
        }
    }
}
