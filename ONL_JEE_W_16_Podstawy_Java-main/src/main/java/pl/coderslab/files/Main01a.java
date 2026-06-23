package pl.coderslab.files;

import java.io.FileWriter;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main01a {

    public static void main(String[] args) {

        Locale.setDefault(Locale.of("pl", "PL"));
        saveConsoleTextToFile();

    }

    public static void saveConsoleTextToFile() {
        System.out.println("=== Zapisywanie tekstu z konsoli do pliku tekstowego ===");
        System.out.println("=== Wpisanie \"quit\" kończy działanie programu ===");
        String fileName = "text1.txt";
        try (Scanner scanner = new Scanner(System.in); FileWriter fileWriter = new FileWriter(fileName)) {
            while (true) {

                System.out.print("> ");

                try {
                    String input = scanner.nextLine();

                    if (input.trim().equalsIgnoreCase("quit")) {
                        break;
                    }

                    fileWriter.write(input + "\n");

                } catch (NoSuchElementException | IllegalStateException e) {
                    // Bezpieczne zamknięcie w przypadku awarii lub użycia Ctrl+D
                    System.out.println("\n[Krytyczny błąd] Strumień konsoli został zamknięty (Ctrl+D).");
                    System.out.println("Wprowadzony do tej pory tekst został bezpiecznie zapisany w pliku: " + fileName);
                    System.exit(1);
                }
            }
            System.out.println("Pisanie notatki zakończono, zapisano do pliku 'text1.txt'");
            } catch(Exception e){
                System.out.println("Błąd krytyczny: Nie można utworzyć lub zapisać pliku " + fileName);
                e.printStackTrace();
            }
        }
    }
