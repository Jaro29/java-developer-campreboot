package pl.coderslab.datainput;

import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main06a {
    public static void main(String[] args) {
        equation();
    }

    public static void equation() {
        // Wymuszenie globalnej lokalizacji dla całego programu (np. format amerykański z kropką)
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nObliczanie pierwiastków równania kwadratowego ax² + bx + c = 0.\n");

        // Czytelne wywołania - intencja kodu jest jasna na pierwszy rzut oka
        double a = readNonZeroDouble(scanner, "Wprowadź a: ");
        double b = readDouble(scanner, "Wprowadź b: ");
        double c = readDouble(scanner, "Wprowadź c: ");

        // Dalsza logika obliczeń...
        double delta = Math.pow(b, 2) - (4 * a * c);
        if (delta > 0) {
            double x1 = (-b - Math.sqrt(delta)) / 2 * a;
            double x2 = (-b + Math.sqrt(delta)) / 2 * a;
            System.out.printf("Delta > 0 - równanie ma dwa różne rozwiązania rzeczywiste: x1 = %.2f oraz x2 = %.2f", x1, x2);
        } else if (delta == 0) {
            double x = -b / 2 * a;
            System.out.printf("Delta = 0 - " +
                    "równanie ma jeden pierwiastek podwójny: x = %.2f", x);
        } else {
            System.out.println("Delta < 0 - równanie nie ma rozwiązań w zbiorze liczb rzeczywistych.");
        }
    }

    /**
     * Pobiera liczbę double dbając o to, by była różna od zera.
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

    public static double readDouble(Scanner scanner, String message) {
        int consecutiveEnters = 0;

        while (true) {
            System.out.print(message);

            try {
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    consecutiveEnters++;
                    if (consecutiveEnters >= 2) {
                        System.out.println("Wskazówka: Musisz wprowadzić wartość liczbową, aby przejść dalej.");
                        consecutiveEnters = 0;
                    }
                    continue;
                }

                // Reset licznika, jeśli użytkownik wpisał jakikolwiek tekst
                consecutiveEnters = 0;

                // Użycie dedykowanego skanera do sparsowania linii z uwzględnieniem lokalizacji
                // Lokale.ROOT lub Locale.US wymusza kropkę. Jeśli chcesz polski przecinek, użyj Locale.of("pl", "PL")
                try (Scanner lineScanner = new Scanner(input).useLocale(Locale.US)) {
                    if (lineScanner.hasNextDouble()) {
                        double value = lineScanner.nextDouble();
                        if (!lineScanner.hasNext()) { // Upewniamy się, że nie ma śmieci po liczbie (np. "4abc")
                            return value;
                        }
                    }
                }

                System.out.println("Błąd: Wprowadzona wartość nie jest poprawną liczbą rzeczywistą.");

            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("Wystąpił krytyczny błąd odczytu strumienia danych.");
            }
        }
    }
}
