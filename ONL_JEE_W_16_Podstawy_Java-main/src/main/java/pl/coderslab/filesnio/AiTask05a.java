package pl.coderslab.filesnio;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AiTask05a {
    public static void main(String[] args) {
        Locale.setDefault(Locale.of("pl", "PL"));

        try (Scanner scanner = new Scanner(System.in)) {
            String projectName = promptForNewProjectName(scanner);
            createProjectStructure(projectName);
        }
    }

    /**
     * Tworzy strukturę katalogów i plików konfiguracyjnych dla nowego projektu.
     */
    public static void createProjectStructure(String projectName) {
        Path projectRoot = Path.of(projectName);
        Path srcDir = projectRoot.resolve("src");
        Path resourcesDir = projectRoot.resolve("resources");
        Path configFile = resourcesDir.resolve("config.properties");

        try {
            Files.createDirectories(srcDir);
            Files.createDirectories(resourcesDir);
            Files.createFile(configFile);

            System.out.printf("Sukces: Struktura projektu '%s' została pomyślnie utworzona.%n", projectName);

        } catch (IOException e) {
            System.out.printf("Błąd zapisu: Nie udało się utworzyć projektu '%s'. Powód: %s%n",
                    projectName, e.getMessage());
        }
    }

    /**
     * Wyświetla monit i pobiera od użytkownika nazwę projektu, dbając o to,
     * by nazwa nie była pusta i nie dublowała istniejącego katalogu.
     */
    private static String promptForNewProjectName(Scanner scanner) {
        int consecutiveEnters = 0;

        while (true) {
            System.out.printf("Podaj nazwę nowego projektu:%n> ");
            try {
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    consecutiveEnters++;
                    if (consecutiveEnters >= 2) {
                        System.out.printf("-> Wskazówka: Nazwa projektu nie może być pusta.%n");
                        consecutiveEnters = 0;
                    }
                    continue;
                }

                Path projectPath = Path.of(input);
                if (Files.exists(projectPath)) {
                    System.out.printf("Błąd: Katalog o nazwie '%s' już istnieje na dysku.%n%n", input);
                    consecutiveEnters = 0;
                    continue;
                }

                return input;

            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.printf("%n[Awaria] Strumień konsoli został przerwany. Zamykanie programu...%n");
                System.exit(1);
                return "";
            }
        }
    }
}
