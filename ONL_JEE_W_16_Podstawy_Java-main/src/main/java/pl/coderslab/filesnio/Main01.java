package pl.coderslab.filesnio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main01 {

    public static void main(String[] args) {
        // Wymuszamy polską lokalizację dla spójności ewentualnych komunikatów
        Locale.setDefault(Locale.of("pl", "PL"));


        // Otwieramy scanner w try-with-resources na samym szczycie programu
        try (Scanner mainScanner = new Scanner(System.in)) {

            // Wywołanie: dirName pobiera tekst używając skanera,
            // a wynik jest natychmiast przekazywany do createDirectory
            createDirectory(dirName(mainScanner));

        } // Tutaj, na samym końcu programu, system.in zostanie bezpiecznie zamknięty

        // Wywołanie metody testowej - utworzy katalog w głównym folderze projektu
    }

    /**
     * Tworzy katalog o zadanej nazwie, sprawdzając uprzednio, czy już nie istnieje.
     *
     * @param directoryName Nazwa katalogu do utworzenia
     */
    public static void createDirectory(String directoryName) {
        // 1. Zamieniamy tekstową nazwę na obiekt Path (szablon ścieżki)
        Path directory = Path.of(directoryName);

        // 2. Warunek: Sprawdzamy, czy katalog o takiej nazwie już istnieje na dysku
        if (Files.exists(directory)) {
            System.out.printf("Informacja: Katalog o nazwie '%s' już istnieje. Nie ma potrzeby go tworzyć.%n", directoryName);
            return; // Kończymy działanie metody, aby nie próbować tworzyć go ponownie
        }

        // 3. Próba fizycznego utworzenia katalogu
        try {
            // Tworzymy katalog - ta metoda wymaga otoczenia blokiem try-catch (IOException)
            Files.createDirectory(directory);
            System.out.printf("Sukces: Katalog '%s' został pomyślnie utworzony!%n", directoryName);

        } catch (IOException e) {
            // Ten blok wykona się w przypadku problemów systemowych (np. brak uprawnień dyskowych)
            System.out.printf("Błąd krytyczny: Nie można utworzyć katalogu '%s'. Powód: %s%n", directoryName, e.getMessage());
        }
    }

    // Zmiana: Przekazujemy istniejący scanner w argumencie metody
    public static String dirName(Scanner scanner) {
        int consecutiveEnters = 0;

        while (true) {
            System.out.print("Podaj nazwę katalogu do utworzenia: ");

            try {
                // USUNĘLIŚMY try-with-resources z tego miejsca.
                // Korzystamy bezpośrednio z przekazanego skanera.
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    consecutiveEnters++;

                    if (consecutiveEnters >= 2) {
                        // Mała poprawka tekstu podpowiedzi (było "Wpisz swoje imię")
                        System.out.println("-> Wskazówka: Pole nie może być puste. Wpisz nazwę katalogu.");
                        consecutiveEnters = 0;
                    }
                    continue; // Teraz powrót pętli jest bezpieczny, bo nikt nie zamknął strumienia!
                }

                return input;

            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("\n[Krytyczny błąd] Strumień konsoli został zamknięty (Ctrl+D). Zamykanie programu...");
                System.exit(1);
                return ""; // Wymagany przez kompilator zwrot, który i tak się nie wykona przez System.exit
            }
        }
    }
}
