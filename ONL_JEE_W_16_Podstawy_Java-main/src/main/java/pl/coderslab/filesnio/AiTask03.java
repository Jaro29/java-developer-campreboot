package pl.coderslab.filesnio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AiTask03 {

    public static void main(String[] args) {

        Scanner mainScanner = new Scanner(System.in);
        String existingDirAndFileName = getExistingDirAndFileName(mainScanner);
        showContentAndLength(existingDirAndFileName);

    }

    public static void showContentAndLength(String dirAndFileName) {
        Path path = Path.of(dirAndFileName);
        try {
            String fileContent = Files.readString(path);
            System.out.printf("Zawartość pliku:%n%s%n",fileContent);
            System.out.printf("Tekst składa się z %d znaków",fileContent.length());

        } catch (IOException e) {
            System.out.printf("Błąd krytyczny: Nie można wczytać pliku '%s'. Powód: %s%n", dirAndFileName, e.getMessage());
        }
    }

    private static String getExistingDirAndFileName(Scanner scanner) {

        int consecutiveEnters = 0;

        while (true) {
            System.out.println("Podaj ścieżkę do pliku wraz z jego nazwą:");
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    consecutiveEnters++;
                    if (consecutiveEnters >= 2) {
                        System.out.println("-> Wskazówka: Pole nie może być puste. Wpisz nazwę pliku.");
                        consecutiveEnters = 0;
                    }
                    continue;
                }
                consecutiveEnters = 0;

                Path tempPath = Path.of(input);

                if (!(Files.exists(tempPath) && Files.isRegularFile(tempPath))) {
                    System.out.println("To nie jest poprawna ścieżka do pliku.");
                    continue;
                }
                return input;

            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("\n[Krytyczny błąd] Strumień konsoli został zamknięty (Ctrl+D). Zamykanie programu...");
                System.exit(1);
                return "";
            }
        }
    }
}
