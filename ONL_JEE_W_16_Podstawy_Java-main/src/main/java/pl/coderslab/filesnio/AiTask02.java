package pl.coderslab.filesnio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AiTask02 {

    public static void main(String[] args) {

        try (Scanner mainScanner = new Scanner(System.in)) {
            String existingFileName = getNameOfExistingFile(mainScanner);
            archiveFile(existingFileName);
        }
    }

    public static void archiveFile(String fileName) {

        Path file = Path.of(fileName);
        Path archivedFile = Path.of("zarchiwizowane_" + fileName);

        try {
            Files.move(file, archivedFile);
            System.out.printf("Zarchiwizowano! Plik o nazwie '%s' do pliku o nazwie '%s'", fileName, archivedFile.getFileName());
        } catch (IOException e) {
            System.out.printf("Błąd krytyczny: Nie można zarchiwizować pliku '%s'. Powód: %s%n", fileName, e.getMessage());
        }
    }

    private static String getNameOfExistingFile(Scanner scanner) {
        int consecutiveEnters = 0;
        System.out.println("Podaj nazwę pliku do zarchiwizowania: ");
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    consecutiveEnters++;

                    if (consecutiveEnters >= 2) {
                        // Mała poprawka tekstu podpowiedzi (było "Wpisz swoje imię")
                        System.out.println("-> Wskazówka: Pole nie może być puste. Wpisz nazwę pliku.");
                        consecutiveEnters = 0;
                    }
                    continue; // Teraz powrót pętli jest bezpieczny, bo nikt nie zamknął strumienia!
                }
                Path tempPath = Path.of(input);
                if (!Files.exists(tempPath)) {
                    System.out.printf("Błąd! Plik o nazwie '%s' nie istnieje.%nWprowadź poprawną nazwę pliku", input);
                    continue;
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
