package pl.coderslab.filesnio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AiTask04a {

    public static void main(String[] args) {
        Locale.setDefault(Locale.of("pl", "PL"));

        try (Scanner mainScanner = new Scanner(System.in)) {
            String pathToAnalyze;

            // Główna pętla sterująca: kręci się w main, dopóki użytkownik nie poda dobrej ścieżki
            while (true) {
                // 1. Pobieramy czysty tekst (Metoda 1)
                pathToAnalyze = getString(mainScanner);

                // 2. Sprawdzamy, czy ścieżka istnieje (Metoda 2)
                if (isPathValid(pathToAnalyze)) {
                    break; // Ścieżka jest poprawna, przerywamy pętlę i idziemy dalej!
                }

                // Jeśli nie jest poprawna, pętla leci od nowa, wyświetlając komunikat z metody getString
                System.out.println("Proszę spróbować ponownie.\n");
            }

            // 3. Wywołujemy analizę dla sprawdzonej ścieżki (Metoda 3)
            pathAnalyzer(pathToAnalyze);
        }
    }

    /**
     * METODA 1: Odpowiada wyłącznie za pobranie niepustego Stringa z konsoli.
     */
    private static String getString(Scanner scanner) {
        int consecutiveEnters = 0;
        while (true) {
            System.out.printf("Podaj ścieżkę do pliku lub folderu:%n > ");
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    consecutiveEnters++;
                    if (consecutiveEnters >= 2) {
                        System.out.println("-> Wskazówka: Pole nie może być puste. Wpisz ścieżkę.");
                        consecutiveEnters = 0;
                    }
                    continue;
                }
                return input;
            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("\n[Krytyczny błąd] Strumień konsoli został zamknięty (Ctrl+D). Zamykanie programu...");
                System.exit(1);
                return "";
            }
        }
    }

    /**
     * METODA 2: Odpowiada wyłącznie za sprawdzenie, czy ścieżka istnieje na dysku.
     * Zwraca true (jeśli istnieje) lub false (jeśli nie istnieje).
     */
    private static boolean isPathValid(String pathToCheck) {
        Path path = Path.of(pathToCheck);

        if (!Files.exists(path)) {
            System.out.printf("Błąd! Ścieżka '%s' nie istnieje na dysku.%n", pathToCheck);
            return false; // Ścieżka zła
        }

        return true; // Ścieżka dobra
    }

    /**
     * METODA 3: Odpowiada wyłącznie za analizę poprawnej ścieżki.
     */
    public static void pathAnalyzer(String pathToAnalyze) {
        Path path = Path.of(pathToAnalyze);
        System.out.println("\n=== Wynik analizy ścieżki ===");

        if (Files.isRegularFile(path)) {
            System.out.printf("Typ: Zwykły plik o nazwie '%s'.%n", path.getFileName());
        } else if (Files.isDirectory(path)) {
            System.out.printf("Typ: Katalog (folder) o nazwie '%s'.%n", path.getFileName());
        }

        System.out.printf("Katalog nadrzędny: '%s'%n", path.getParent());
        System.out.printf("Liczba segmentów w ścieżce: %d%n", path.getNameCount());
    }
}
