package pl.coderslab.mysql.javamysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main05 {

    public static void main(String[] args) {
        try (Connection conn = DbUtil.connect(); Scanner scanner = new Scanner(System.in)) {
            int id = readPositiveInt(scanner, "Podaj identyfikator klienta: ");
            DbUtil.remove(conn, "customers", "customer_id", id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metoda pomocnicza: pobiera liczbę całkowitą i sprawdza, czy nie jest ujemna.
     */
    @SuppressWarnings("SameParameterValue") // Ucisza żółte ostrzeżenie w edytorze kodu
    private static int readPositiveInt(Scanner scanner, String message) {
        int consecutiveEnters = 0;

        while (true) {
            System.out.print(message);
            try {
                String input = scanner.nextLine().trim();

                // Podobnie jak przy imieniu, obsługujemy sytuację naciśnięcia samego Entera
                if (input.isEmpty()) {
                    consecutiveEnters++;
                    if (consecutiveEnters >= 2) {
                        System.out.println("-> Wskazówka: Pole nie może być puste.");
                        consecutiveEnters = 0;
                    }
                    continue;
                }

                consecutiveEnters = 0; // Użytkownik coś wpisał, więc resetujemy licznik pustych enterów

                // Tworzymy "mini-skaner" (pod-skaner), który przeanalizuje wyłącznie wpisany tekst (zmienną input).
                // .useLocale(Locale.getDefault()) wymusza na nim przestrzeganie polskiego formatu liczb.
                try (Scanner lineScanner = new Scanner(input).useLocale(Locale.getDefault())) {

                    // hasNextInt() pyta Javę: "Czy ten wpisany tekst zaczyna się od poprawnej liczby całkowitej?"
                    if (lineScanner.hasNextInt()) {
                        int value = lineScanner.nextInt(); // Wyciągamy tę liczbę do zmiennej "value"

                        // !lineScanner.hasNext() sprawdza, czy za tą liczbą NIE MA już żadnych innych znaków.
                        // Chroni to nas przed błędami typu "23lata" czy "23.5" (program odrzuci takie wpisy).
                        if (!lineScanner.hasNext()) {

                            // Warunek biznesowy: wiek człowieka nie może być liczbą ujemną (np. -5 lat)
                            if (value >= 0) {
                                return value; // Dane idealne! Zwracamy wiek i kończymy metodę
                            }
                            System.out.println("Błąd: Identyfikator nie jest liczbą ujemną.");
                            continue; // Wraca na początek pętli po nową liczbę
                        }
                    }
                }

                // Ten komunikat wyświetli się, jeśli hasNextInt() dało false (np. ktoś wpisał słowo "dwadzieścia")
                System.out.println("Błąd: Wprowadzona wartość nie jest poprawną liczbą całkowitą.");

            } catch (NoSuchElementException | IllegalStateException e) {
                // Bezpieczne zamknięcie w przypadku awarii strumienia (Ctrl+D)
                System.out.println("\n[Krytyczny błąd] Strumień konsoli został zamknięty (Ctrl+D). Zamykanie programu...");
                System.exit(1);
            }
        }
    }

}
