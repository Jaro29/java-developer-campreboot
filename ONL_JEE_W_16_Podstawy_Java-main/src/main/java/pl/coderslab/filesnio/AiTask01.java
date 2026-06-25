package pl.coderslab.filesnio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class AiTask01 {
    public static void main(String[] args) {
        String fileName = "notatki.txt";
        System.out.printf("=== Tworzenie kopii bezpieczeństwa pliku: %s%n", fileName);
        backupFile(fileName);
    }

    public static void backupFile(String fileName) {
        Path file = Path.of(fileName);
        Path backupFile = Path.of("backup_" + fileName);

        if (!Files.exists(file)) {
            System.out.printf("Nie ma takiego pliku: %s ", fileName);
        } else {
            try {
                Files.copy(file, backupFile, StandardCopyOption.REPLACE_EXISTING);
                System.out.printf("Sukces: Plik 'backup_%s' został pomyślnie utworzony!%n", fileName);
                Files.delete(file);
                System.out.printf("A plik %s został usunięty.%n", fileName);
            } catch (IOException e) {
                System.out.printf("Błąd krytyczny: Nie można skopiować pliku '%s'. Powód: %s%n", fileName, e.getMessage());
            }
        }
    }
}
