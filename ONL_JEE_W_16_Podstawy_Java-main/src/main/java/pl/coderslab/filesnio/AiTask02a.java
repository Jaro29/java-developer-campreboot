package pl.coderslab.filesnio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AiTask02a {

    public static void main(String[] args) {
        Locale.setDefault(Locale.of("pl", "PL"));

        try (Scanner mainScanner = new Scanner(System.in)) {
            // Pobieramy nazwę dopiero wtedy, gdy jesteśmy pewni, że plik istnieje na dysku
            String existingFileName = getExistingFileName(mainScanner);

            // Wywołujemy czystą metodę biznesową, która zajmuje się tylko przenoszeniem
            archiveFile(existingFileName);
        }
    }

    /**
     * Zmienia nazwę istniejącego pliku, dodając przedrostek "zarchiwizowane_".
     */
    public static void archiveFile(String fileName) {
        Path file = Path.of(fileName);
        Path archivedFile = Path.of("zarchiwizowane_" + fileName);

        try {
            Files.move(file, archivedFile);
            System.out.printf("Sukces! Zarchiwizowano plik '%s' jako '%s'.%n", fileName, archivedFile.getFileName());
        } catch (IOException e) {
            System.out.printf("Błąd krytyczny: Nie można zarchiwizować pliku '%s'. Powód: %s%n", fileName, e.getMessage());
        }
    }

    /**
     * Pyta użytkownika o nazwę pliku tak długo, aż poda nazwę ISTNIEJĄCEGO pliku.
     */
    private static String getExistingFileName(Scanner scanner) {
        int consecutiveEnters = 0;

        while (true) {
            System.out.print("Podaj nazwę pliku do zarchiwizowania: ");
            try {
                String input = scanner.nextLine().trim();

                // 1. Walidacja pustego pola
                if (input.isEmpty()) {
                    consecutiveEnters++;
                    if (consecutiveEnters >= 2) {
                        System.out.println("-> Wskazówka: Pole nie może być puste. Wpisz nazwę pliku.");
                        consecutiveEnters = 0;
                    }
                    continue;
                }

                consecutiveEnters = 0; // Reset licznika enterów

                // 2. NOWOŚĆ: Walidacja istnienia pliku na dysku
                Path tempPath = Path.of(input);
                if (!Files.exists(tempPath)) {
                    System.out.printf("Błąd: Plik o nazwie '%s' nie istnieje na dysku! Spróbuj ponownie.%n%n", input);
                    continue; // Plik nie istnieje, więc ponawiamy pętlę while i pytamy od nowa
                }

                // Jeśli program dotarł tutaj, to znaczy, że tekst nie jest pusty ORAZ plik istnieje
                return input;

            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("\n[Krytyczny błąd] Strumień konsoli został zamknięty (Ctrl+D). Zamykanie programu...");
                System.exit(1);
                return "";
            }
        }
    }
}
