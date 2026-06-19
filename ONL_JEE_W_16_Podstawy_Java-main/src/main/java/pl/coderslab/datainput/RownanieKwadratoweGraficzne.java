package pl.coderslab.datainput;
import java.util.Locale;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class RownanieKwadratoweGraficzne {

    public static void main(String[] args) {
        // Ustawienie lokalizacji (US wymusza kropkę, jeśli chcesz polski przecinek użyj Locale.of("pl", "PL"))
        Locale.setDefault(Locale.US);

        // Uruchomienie programu
        equation();
    }

    /**
     * Główna metoda sterująca aplikacją w wersji graficznej.
     */
    public static void equation() {
        boolean continueProgram;

        do {
            // Komunikat powitalny
            JOptionPane.showMessageDialog(null,
                    "Obliczanie pierwiastków równania kwadratowego ax² + bx + c = 0.",
                    "Program Równanie Kwadratowe",
                    JOptionPane.INFORMATION_MESSAGE);

            // Pobranie i walidacja współczynników
            double a = readNonZeroDouble("Wprowadź współczynnik a: ");
            double b = readDouble("Wprowadź współczynnik b: ");
            double c = readDouble("Wprowadź współczynnik c: ");

            // Przygotowanie tekstu z równaniem i wynikami
            String equationText = String.format("Twoje równanie: %.2fx² + %.2fx + %.2f = 0\n\n", a, b, c);
            String resultsText = calculateRoots(a, b, c);

            // Wyświetlenie wyników w okienku
            JOptionPane.showMessageDialog(null,
                    equationText + resultsText,
                    "Wyniki obliczeń",
                    JOptionPane.INFORMATION_MESSAGE);

            // Zapytanie o ponowne uruchomienie za pomocą systemowych przycisków TAK/NIE
            int response = JOptionPane.showConfirmDialog(null,
                    "Czy chcesz obliczyć kolejne równanie?",
                    "Kontynuować?",
                    JOptionPane.YES_NO_OPTION);

            continueProgram = (response == JOptionPane.YES_OPTION);

        } while (continueProgram);

        JOptionPane.showMessageDialog(null,
                "Dziękuję za skorzystanie z programu. Do zobaczenia!",
                "Koniec programu",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Oblicza wyróżnik (deltę) oraz zwraca sformatowany tekst z pierwiastkami.
     */
    private static String calculateRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - (4 * a * c);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Wyróżnik równania (Delta) = %.4f\n\n", delta));

        if (delta > 0) {
            double x1 = (-b - Math.sqrt(delta)) / (2 * a);
            double x2 = (-b + Math.sqrt(delta)) / (2 * a);
            sb.append("Równanie ma dwa różne pierwiastki rzeczywiste:\n");
            sb.append(String.format("x1 = %.4f\n", x1));
            sb.append(String.format("x2 = %.4f\n", x2));
        } else if (delta == 0) {
            double x0 = -b / (2 * a);
            sb.append("Równanie ma jeden pierwiastek podwójny:\n");
            sb.append(String.format("x0 = %.4f\n", x0));
        } else {
            sb.append("Delta < 0. Równanie nie ma rozwiązań w zbiorze liczb rzeczywistych.");
        }
        return sb.toString();
    }

    /**
     * Pobiera liczbę double, pilnując by nie była zerem.
     */
    private static double readNonZeroDouble(String message) {
        while (true) {
            double value = readDouble(message);
            if (value != 0.0) {
                return value;
            }
            JOptionPane.showMessageDialog(null,
                    "Błąd: Współczynnik 'a' nie może być równy 0 w równaniu kwadratowym!",
                    "Błąd wartości",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Bezpiecznie pobiera liczbę rzeczywistą przez okienko dialogowe.
     * Odporne na puste pola (entery), anulowanie oraz błędne formaty.
     */
    private static double readDouble(String message) {
        int consecutiveEnters = 0;

        while (true) {
            // Wyświetlenie okienka do wpisywania tekstu
            String input = JOptionPane.showInputDialog(null, message, "Wprowadzanie danych", JOptionPane.QUESTION_MESSAGE);

            // 1. Obsługa sytuacji, gdy użytkownik kliknął "Anuluj" lub zamknął okienko krzyżykiem
            if (input == null) {
                int confirmExit = JOptionPane.showConfirmDialog(null,
                        "Czy na pewno chcesz wyjść z programu?",
                        "Wyjście",
                        JOptionPane.YES_NO_OPTION);
                if (confirmExit == JOptionPane.YES_OPTION) {
                    System.exit(0); // Bezpieczne zamknięcie programu na życzenie użytkownika
                }
                continue; // Jeśli kliknął "Nie", ponawiamy pytanie o liczbę
            }

            input = input.trim();

            // 2. Obsługa pustego pola (kliknięcie OK bez wpisania niczego - odpowiednik Entera)
            if (input.isEmpty()) {
                consecutiveEnters++;
                if (consecutiveEnters >= 2) {
                    JOptionPane.showMessageDialog(null,
                            "Wskazówka: Musisz wprowadzić wartość liczbową, aby przejść dalej.",
                            "Brak danych",
                            JOptionPane.WARNING_MESSAGE);
                    consecutiveEnters = 0;
                }
                continue;
            }

            consecutiveEnters = 0; // Reset licznika

            // 3. Precyzyjne parsowanie za pomocą bezpiecznego pod-skanera linii
            try (Scanner lineScanner = new Scanner(input)) {
                if (lineScanner.hasNextDouble()) {
                    double value = lineScanner.nextDouble();
                    if (!lineScanner.hasNext()) {
                        return value; // Sukces
                    }
                }
            }

            // Jeśli nie przeszło parsowania, wyświetlamy błąd
            JOptionPane.showMessageDialog(null,
                    "Błąd: Wprowadzona wartość nie jest poprawną liczbą rzeczywistą.",
                    "Błąd formatu",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
