package pl.coderslab.datainput;

import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main03b {

    public static void main(String[] args) {
        // Wymuszamy polską lokalizację dla spójności komunikatów
        Locale.setDefault(Locale.of("pl", "PL"));

        // Uruchomienie metody zadania
        getData();
    }

    /**
     * Główna metoda biznesowa. Realizuje algorytm wczytywania liczb i sumowania.
     */
    public static void getData() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Sumowanie liczb całkowitych (wprowadź 0, aby zakończyć) ===");

            int sum = 0;   // Przechowuje sumę wartości liczb
            int count = 0; // Przechowuje ilość podanych liczb (bez zera)

            while (true) {
                // Pobieramy liczbę za pomocą wydzielonej, bezpiecznej metody
                int number = readInt(scanner, "Wprowadź liczbę całkowitą: ");

                // Warunek zakończenia: jeśli użytkownik wpisał 0, przerywamy pętlę
                if (number == 0) {
                    break;
                }

                // Aktualizacja statystyk (wykona się tylko dla liczb różnych od zera)
                sum += number;
                count++;
            }

            // Wyświetlenie wyników po wyjściu z pętli
            System.out.println("\n=== Podsumowanie ===");
            System.out.printf("Suma wprowadzonych liczb wynosi: %d%n", sum);
            System.out.printf("Ilość wprowadzonych liczb wynosi: %d%n", count);
        }
    }

    /**
     * Wydzielona metoda pomocnicza.
     * Bezpiecznie pobiera jedną liczbę całkowitą z konsoli, obsługując błędy i Entery.
     */
    @SuppressWarnings("SameParameterValue") // Ucisza ostrzeżenie IDE o stałej wartości parametru
    private static int readInt(Scanner scanner, String message) {
        int consecutiveEnters = 0;

        while (true) {
            System.out.print(message);
            try {
                String input = scanner.nextLine().trim();

                // 1. Obsługa wielokrotnego naciśnięcia klawisza Enter
                if (input.isEmpty()) {
                    consecutiveEnters++;
                    if (consecutiveEnters >= 2) {
                        System.out.println("-> Wskazówka: Musisz wpisać liczbę całkowitą lub 0, aby zakończyć.");
                        consecutiveEnters = 0;
                    }
                    continue;
                }

                consecutiveEnters = 0; // Reset licznika po udanym wpisaniu znaków

                // 2. Parsowanie linii za pomocą pod-skanera
                try (Scanner lineScanner = new Scanner(input).useLocale(Locale.getDefault())) {
                    if (lineScanner.hasNextInt()) {
                        int value = lineScanner.nextInt();

                        // Zabezpieczenie przed "śmieciami" w tekście (np. "5abc" lub "5.5")
                        if (!lineScanner.hasNext()) {
                            return value; // Dane poprawne, zwracamy liczbę
                        }
                    }
                }

                System.out.println("Błąd: Wprowadzona wartość nie jest poprawną liczbą całkowitą.");

            } catch (NoSuchElementException | IllegalStateException e) {
                // Pancerna ochrona przed przypadkowym Ctrl+D
                System.out.println("\n[Krytyczny błąd] Strumień konsoli został zamknięty (Ctrl+D). Zamykanie programu...");
                System.exit(1);
            }
        }
    }
}
