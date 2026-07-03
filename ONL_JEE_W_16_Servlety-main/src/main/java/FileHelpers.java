import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Zestaw sprawdzonych metod do pracy z plikami i ścieżkami (pakiet java.nio.file).
 * Wyciągnięte i ujednolicone z archiwum nauki Javy (Main01, AiTask01-04).
 *
 * Wspólna zasada (Guard Clause): najpierw sprawdzamy warunek brzegowy i robimy
 * return, dopiero potem właściwa logika - bez zagnieżdżonych if-else.
 */
public class FileHelpers {

    // ==========================================================
    // 1. TWORZENIE KATALOGU - sprawdza, czy już nie istnieje
    // ==========================================================
    public static void createDirectory(String directoryName) {
        Path directory = Path.of(directoryName);

        if (Files.exists(directory)) {
            System.out.printf("Informacja: Katalog '%s' już istnieje.%n", directoryName);
            return;
        }
        try {
            Files.createDirectory(directory); // pojedynczy poziom
            // Files.createDirectories(directory); // <- wersja z "s": tworzy też foldery nadrzędne (np. a/b/c naraz)
            System.out.printf("Sukces: Katalog '%s' utworzony!%n", directoryName);
        } catch (IOException e) {
            System.out.printf("Błąd krytyczny: Nie można utworzyć katalogu '%s'. Powód: %s%n", directoryName, e.getMessage());
        }
    }

    // ==========================================================
    // 2. KOPIA BEZPIECZEŃSTWA + usunięcie oryginału (backup_*)
    // ==========================================================
    public static void backupAndDeleteOriginal(String fileName) {
        Path file = Path.of(fileName);
        Path backupFile = Path.of("backup_" + fileName);

        if (!Files.exists(file)) {
            System.out.printf("Błąd: Nie ma takiego pliku źródłowego: %s%n", fileName);
            return;
        }
        try {
            // REPLACE_EXISTING = automatyczne nadpisanie starego backupu
            Files.copy(file, backupFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.printf("Sukces: Kopia '%s' utworzona!%n", backupFile.getFileName());

            // Usuwamy oryginał DOPIERO po udanym skopiowaniu (bezpieczeństwo danych)
            Files.delete(file);
            System.out.printf("Sukces: Oryginalny plik '%s' usunięty.%n", fileName);
        } catch (IOException e) {
            System.out.printf("Błąd krytyczny operacji na plikach. Powód: %s%n", e.getMessage());
        }
    }

    // ==========================================================
    // 3. ZMIANA NAZWY / PRZENIESIENIE pliku (Files.move)
    // ==========================================================
    public static void archiveFile(String fileName) {
        Path file = Path.of(fileName);
        Path archivedFile = Path.of("zarchiwizowane_" + fileName);

        try {
            Files.move(file, archivedFile);
            System.out.printf("Sukces! Zarchiwizowano '%s' jako '%s'.%n", fileName, archivedFile.getFileName());
        } catch (IOException e) {
            System.out.printf("Błąd krytyczny: Nie można zarchiwizować '%s'. Powód: %s%n", fileName, e.getMessage());
        }
    }

    // ==========================================================
    // 4. ODCZYT CAŁEGO PLIKU JEDNĄ LINIJKĄ + długość tekstu
    //    (Files.readString wynik zapisany RAZ do zmiennej - bez podwójnego czytania z dysku)
    // ==========================================================
    public static void showContentAndLength(String dirAndFileName) {
        Path path = Path.of(dirAndFileName);
        try {
            String content = Files.readString(path); // czytamy dysk tylko raz
            System.out.printf("Zawartość pliku:%n%s%n", content);
            System.out.printf("Tekst składa się z %d znaków%n", content.length());
        } catch (IOException e) {
            System.out.printf("Błąd krytyczny: Nie można wczytać pliku '%s'. Powód: %s%n", dirAndFileName, e.getMessage());
        }
    }

    // ==========================================================
    // 5. ANALIZATOR ŚCIEŻKI - typ, nazwa, rodzic, liczba elementów
    // ==========================================================
    public static void pathAnalyzer(String pathToAnalyze) {
        Path path = Path.of(pathToAnalyze).toAbsolutePath(); // toAbsolutePath() unika null przy getParent()

        if (Files.isRegularFile(path)) {
            System.out.printf("Ścieżka prowadzi do pliku '%s'.%n", path.getFileName());
        } else if (Files.isDirectory(path)) {
            System.out.println("Ścieżka prowadzi do katalogu.");
        }
        System.out.printf("Katalog nadrzędny: '%s'%n", path.getParent());
        System.out.printf("Liczba elementów w ścieżce: %d%n", path.getNameCount());
    }

    // ==========================================================
    // POBIERANIE ISTNIEJĄCEJ ŚCIEŻKI OD UŻYTKOWNIKA (pętla walidująca)
    // Files.exists(path) sprawdza SAMO istnienie - działa i dla plików, i dla katalogów.
    // (Nie łącz go z !Files.isDirectory - to była pułapka logiczna z AND zamiast OR)
    // ==========================================================
    public static String getExistingPath(Scanner scanner, String message) {
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
                consecutiveEnters = 0;

                if (!Files.exists(Path.of(input))) {
                    System.out.println("Błąd: Taka ścieżka nie istnieje na dysku.");
                    continue;
                }
                return input; // sukces: ścieżka istnieje

            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("\n[Krytyczny błąd] Strumień konsoli został zamknięty (Ctrl+D). Zamykanie programu...");
                System.exit(1);
                return "";
            }
        }
    }

    // ==========================================================
    // PRZYKŁAD UŻYCIA
    // ==========================================================
    public static void main(String[] args) {
        Locale.setDefault(Locale.of("pl", "PL"));

        try (Scanner scanner = new Scanner(System.in)) {
            createDirectory("test_katalog");
            String path = getExistingPath(scanner, "Podaj ścieżkę do pliku lub folderu: ");
            pathAnalyzer(path);
        }
    }
}