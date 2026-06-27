package pl.coderslab.filesnio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AiTask05 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.of("pl", "PL"));
        try (Scanner mainScanner = new Scanner(System.in)) {
            String projectName = getProjectName(mainScanner);
            projectStructureCreator(projectName);
        }
    }

    public static void projectStructureCreator(String projectName) {
        Path srcPath = Path.of(projectName, "src");
        Path resourcesPath = Path.of(projectName, "resources");
        /*
        // Sposób A (z użyciem Path.of):
        Path configFile = Path.of(projectName, "resources", "config.properties");
        */
        // Sposób B (z użyciem metody .resolve - bardzo popularny w branży):
        Path configFile = resourcesPath.resolve("config.properties");

        try {
            Files.createDirectories(srcPath);
            Files.createDirectories(resourcesPath);
            Files.createFile(configFile);

            System.out.printf("Pomyślnie utworzono project '%s'.%n", projectName);

        } catch (IOException e) {
            System.out.printf("Błąd krytyczny: Nie można utworzyć projektu '%s'. Powód: %s%n",
                    projectName, e.getMessage());
        }
    }

    private static String getProjectName(Scanner scanner) {
        int consecutiveEnters = 0;
        while (true) {
            System.out.printf("Podaj nazwę projektu: %n> ");
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    consecutiveEnters++;
                    if (consecutiveEnters >= 2) {
                        System.out.printf("-> Wskazówka: Pole nie może być puste.%n");
                        consecutiveEnters = 0;
                    }
                    continue;
                }
                Path tempPath = Path.of(input);
                if (Files.exists(tempPath)) {
                    System.out.printf("Błąd! Projekt o nazwie '%s' już istnieje.%n", input);
                    consecutiveEnters = 0;
                    continue;
                }
                return input;

            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.printf("%n[Krytyczny błąd] Strumień konsoli został zamknięty (Ctrl+D). Zamykanie programu...");
                System.exit(1);
                return ""; // Wymagany przez kompilator zwrot, który i tak się nie wykona przez System.exit
            }
        }
    }
}
