import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Zestaw sprawdzonych metod do bezpiecznego wczytywania danych z konsoli.
 * Wyciągnięte i ujednolicone z archiwum nauki Javy (zadania Main01–Main03, AiTask, TaskManager).
 *
 * Wspólny szkielet każdej metody:
 *   while (true) { wypisz komunikat -> pobierz linię -> zwaliduj -> return albo continue }
 *
 * Różnice między nimi (3 warianty pętli while(true), których używałeś):
 *  1) PEŁNY PANCERNY WARIANT (readString, readInt, readDouble, readBoolean):
 *     - liczy puste Entery (consecutiveEnters) i po 2. pustym wejściu pokazuje podpowiedź,
 *     - łapie NoSuchElementException/IllegalStateException (Ctrl+D) i kończy program.
 *  2) PROSTSZY WARIANT (readDate):
 *     - brak liczenia pustych Enterów, walidacja tylko przez try/catch na format danych.
 *     - używaj, gdy błąd wpisania jest mało prawdopodobny (np. wewnętrzne narzędzie).
 *  3) WARIANT Z POD-SKANEREM (fragment w readInt):
 *     - zamiast String -> parseInt/parseDouble, używa się osobnego Scannera na jednej linii
 *       (lineScanner.hasNextInt()), co odrzuca "śmieci" typu "5abc".
 */
public class InputHelpers {

    // ==========================================================
    // 1. TEKST (String) - nie pozwala na puste pole
    // ==========================================================
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

    // ==========================================================
    // 2. LICZBA CAŁKOWITA (int) - z pod-skanerem, odrzuca "5abc"
    // ==========================================================
    public static int readInt(Scanner scanner, String message) {
        int consecutiveEnters = 0;

        while (true) {
            System.out.print(message);
            try {
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    consecutiveEnters++;
                    if (consecutiveEnters >= 2) {
                        System.out.println("-> Wskazówka: Musisz wpisać liczbę całkowitą.");
                        consecutiveEnters = 0;
                    }
                    continue;
                }
                consecutiveEnters = 0;

                // pod-skaner na pojedynczej linii - pilnuje, żeby CAŁA linia była liczbą
                try (Scanner lineScanner = new Scanner(input).useLocale(Locale.getDefault())) {
                    if (lineScanner.hasNextInt()) {
                        int value = lineScanner.nextInt();
                        if (!lineScanner.hasNext()) {
                            return value; // sukces, nic więcej nie zostało w linii
                        }
                    }
                }
                System.out.println("Błąd: To nie jest poprawna liczba całkowita.");

            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("\n[Krytyczny błąd] Strumień konsoli został zamknięty (Ctrl+D). Zamykanie programu...");
                System.exit(1);
                return 0;
            }
        }
    }

    // wariant z dodatkowym warunkiem biznesowym (np. wiek >= 0)
    public static int readPositiveInt(Scanner scanner, String message) {
        while (true) {
            int value = readInt(scanner, message);
            if (value >= 0) {
                return value;
            }
            System.out.println("Błąd: Wartość nie może być ujemna.");
        }
    }

    // ==========================================================
    // 3. LICZBA RZECZYWISTA (double) - prostszy wariant przez try/catch
    //    (bez pod-skanera), akceptuje przecinek zamiast kropki
    // ==========================================================
    public static double readDouble(Scanner scanner, String message) {
        int consecutiveEnters = 0;

        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                consecutiveEnters++;
                if (consecutiveEnters >= 2) {
                    System.out.println("Błąd: Nie naciskaj samego Entera, wprowadź liczbę!");
                    consecutiveEnters = 0;
                }
                continue;
            }

            try {
                input = input.replace(',', '.'); // akceptuj 1,4 i 1.4
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Błąd: wprowadź liczbę rzeczywistą - np. 1,4 lub 4.");
                consecutiveEnters = 0;
            }
        }
    }

    // ==========================================================
    // 4. TAK/NIE (boolean jako String "true"/"false") - z UX skrótami
    // ==========================================================
    public static String readBoolean(Scanner scanner, String message) {
        int consecutiveEnters = 0;

        while (true) {
            System.out.print(message);
            try {
                String input = scanner.nextLine().trim().toLowerCase();

                if (input.isEmpty()) {
                    consecutiveEnters++;
                    if (consecutiveEnters >= 2) {
                        System.out.println("-> Wskazówka: Wpisz true/false albo tak/nie.");
                        consecutiveEnters = 0;
                    }
                    continue;
                }
                consecutiveEnters = 0;

                if (input.equals("true") || input.equals("tak") || input.equals("t") || input.equals("yes")) {
                    return "true";
                } else if (input.equals("false") || input.equals("nie") || input.equals("n") || input.equals("no")) {
                    return "false";
                }
                System.out.println("Błąd: Wpisz true/false albo tak/nie.");

            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("\n[Krytyczny błąd] Strumień konsoli został zamknięty (Ctrl+D). Zamykanie programu...");
                System.exit(1);
                return "false";
            }
        }
    }

    // ==========================================================
    // 5. DATA (LocalDate jako tekst YYYY-MM-DD) - prostszy wariant pętli,
    //    walidacja formatu "za darmo" dzięki LocalDate.parse()
    // ==========================================================
    public static String readDate(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            try {
                LocalDate.parse(input); // rzuci wyjątkiem np. dla 2026-02-30
                return input;
            } catch (DateTimeParseException e) {
                System.out.println("Błąd: Zła data lub format. Użyj YYYY-MM-DD (np. 2026-06-29).");
            }
        }
    }

    // ==========================================================
    // PRZYKŁAD UŻYCIA
    // ==========================================================
    public static void main(String[] args) {
        Locale.setDefault(Locale.of("pl", "PL"));

        try (Scanner scanner = new Scanner(System.in)) {
            String name = readString(scanner, "Podaj imię: ");
            int age = readPositiveInt(scanner, "Podaj wiek: ");
            double height = readDouble(scanner, "Podaj wzrost (m): ");
            String isStudent = readBoolean(scanner, "Czy jesteś studentem? (tak/nie): ");
            String date = readDate(scanner, "Podaj dzisiejszą datę (YYYY-MM-DD): ");

            System.out.printf("%n%s, %d lat, %.2f m, student: %s, data: %s%n",
                    name, age, height, isStudent, date);
        }
    }
}