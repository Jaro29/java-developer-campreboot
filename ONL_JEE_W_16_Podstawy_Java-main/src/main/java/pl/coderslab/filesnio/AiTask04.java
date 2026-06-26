package pl.coderslab.filesnio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AiTask04 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.of("pl", "PL"));
        try(Scanner mainScanner = new Scanner(System.in)){
            String pathToAnalyze;
            while(true){
                pathToAnalyze = getString(mainScanner);
                if(!pathExistsCheck(pathToAnalyze)){
                    continue;
                }
                pathAnalyzer(pathToAnalyze);
                break;
            }
        }
    }

    public static void pathAnalyzer(String pathToAnalyze) {

        Path path = Path.of(pathToAnalyze);
        if (Files.isRegularFile(path)) {
            System.out.printf("ścieżka prowadzi do pliku '%s'.%n", path.getFileName());
        }
        if (Files.isDirectory(path)) {
            System.out.printf("ścieżka prowadzi do katalogu.%n");
        }
        System.out.printf("Katalog nadrzędny dla ścieżki '%s' to '%s'%n", pathToAnalyze, path.getParent());
        System.out.printf("Ścieżka '%s' składa się z %d elementów", pathToAnalyze, path.getNameCount());
    }

    private static boolean pathExistsCheck(String pathToCheck) {
        Path path = Path.of(pathToCheck);

        if (!Files.exists(path)) {
            System.out.println("Błąd! Niepoprawna ścieżka");
            return false;
        }
        return true;
    }

    private static String getString(Scanner scanner) {
        int consecutiveEnters = 0;
        while (true) {
            System.out.printf("Podaj ścieżkę do pliku lub folderu.%n > ");
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    consecutiveEnters++;
                    if (consecutiveEnters >= 2) {
                        System.out.println("-> Wskazówka: Pole nie może być puste. Wpisz swoje imię.");
                        consecutiveEnters = 0;
                    }
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
