package pl.coderslab.files;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main01 {

    public static void main(String[] args) {
        // Wymuszamy polską lokalizację dla spójności komunikatów
        Locale.setDefault(Locale.of("pl", "PL"));

        // Uruchomienie metody zapisującej dane do pliku
        saveTextToFile();
    }

    /**
     * Wczytuje linie z konsoli i zapisuje je linia po linii do pliku text1.txt.
     */
    public static void saveTextToFile() {
        System.out.println("=== Notatnik konsolowy ===");
        System.out.println("Wpisuj tekst (każdy Enter to nowa linia w pliku).");
        System.out.println("Wpisz 'quit', aby zakończyć i zapisać plik.\n");

        // Definiujemy nazwę pliku docelowego
        String fileName = "text1.txt";

        // Try-with-resources obsługuje teraz DWA zasoby rozdzielone średnikiem:
        // 1. Scanner do czytania z klawiatury
        // 2. FileWriter do zapisu do pliku (w nawiasie podajemy nazwę pliku)
        try (Scanner scanner = new Scanner(System.in);
             FileWriter writer = new FileWriter(fileName)) {

            int consecutiveEnters = 0; // Licznik pustych enterów dla podpowiedzi

            while (true) {
                System.out.print("> ");

                try {
                    String input = scanner.nextLine(); // Czytamy całą linię (nie używamy .trim(), aby zachować intencjonalne spacje użytkownika)

                    // 1. Warunek wyjścia z pętli (słowo quit)
                    // .trim() robimy tylko na potrzeby testu warunku, aby "quit  " też zadziałało
                    if (input.trim().equalsIgnoreCase("quit")) {
                        break; // Przerywamy pętlę, dzięki czemu "quit" NIE trafi do pliku
                    }

                    // 2. Obsługa pustych linii (samych Enterów)
                    if (input.isEmpty()) {
                        consecutiveEnters++;
                        if (consecutiveEnters >= 3) {
                            System.out.println("-> Wskazówka: Jeśli chcesz zakończyć pisanie, wpisz słowo 'quit'.");
                            consecutiveEnters = 0;
                        }
                        // Pozwalamy zapisać pustą linię do pliku (użytkownik może chcieć zrobić odstęp w tekście)
                    } else {
                        consecutiveEnters = 0; // Reset licznika, bo użytkownik wpisał tekst
                    }

                    // 3. Zapis linii do pliku oraz dodanie znaku nowej linii (\n)
                    writer.write(input + "\n");

                } catch (NoSuchElementException | IllegalStateException e) {
                    // Bezpieczne zamknięcie w przypadku awarii lub użycia Ctrl+D
                    System.out.println("\n[Krytyczny błąd] Strumień konsoli został zamknięty (Ctrl+D).");
                    System.out.println("Wprowadzony do tej pory tekst został bezpiecznie zapisany w pliku: " + fileName);
                    System.exit(1);
                }
            }

            System.out.println("\nPisanie zakończone. Dane zostały pomyślnie zapisane w pliku: " + fileName);

        } catch (IOException e) {
            // FileWriter wymaga obsługi wyjątku IOException (np. brak uprawnień do zapisu na dysku)
            System.out.println("Błąd krytyczny: Nie można utworzyć lub zapisać pliku " + fileName);
            e.printStackTrace();
        }
    }
}
