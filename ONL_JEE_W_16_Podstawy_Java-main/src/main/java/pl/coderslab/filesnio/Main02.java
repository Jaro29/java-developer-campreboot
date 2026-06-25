package pl.coderslab.filesnio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

public class Main02 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.of("pl", "PL"));
        createFile("nowy_plik.txt");
    }

    /**
     * Tworzy plik o zadanej nazwie, sprawdzając uprzednio, czy już nie istnieje.
     *
     * @param fileName Nazwa pliku do utworzenia
     */
    public static void createFile(String fileName) {

        Path file = Path.of(fileName);

        if (Files.exists(file)) {
            System.out.printf("Informacja: Plik o nazwie '%s' już istnieje. Nie ma potrzeby go tworzyć.%n", fileName);
            return;
        }
        try {
            Files.createFile(file);
            System.out.printf("Sukces: Plik '%s' został pomyślnie utworzony!%n", fileName);
        } catch (IOException e) {
            System.out.printf("Błąd krytyczny: Nie można utworzyć pliku '%s'. Powód: %s%n", fileName, e.getMessage());
        }
    }
}
