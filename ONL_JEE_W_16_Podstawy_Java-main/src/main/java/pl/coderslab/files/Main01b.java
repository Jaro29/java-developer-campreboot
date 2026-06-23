package pl.coderslab.files;

import java.io.*;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main01b {
    public static void main(String[] args) {
        Locale.setDefault(Locale.of("pl", "PL"));
        saveTextToFileWithPrintFile();
    }

    public static void saveTextToFileWithPrintFile() {

        System.out.println("Zapisywanie tekstu z konsoli do pliku text1.txt");
        System.out.println("'quit' kończy działanie programu.");

        String fileName = "text2.txt";
        try (Scanner scanner = new Scanner(System.in);

             // Tworzymy profesjonalny łańcuch strumieni:
             // FileWriter (otwiera plik) -> BufferedWriter (buforuje dla wydajności) -> PrintWriter (daje wygodne metody)
             PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)))) {

            while (true) {
                System.out.print("> ");

                try {
                    String input = scanner.nextLine();

                    if (input.trim().equalsIgnoreCase("quit")) {
                        break;
                    }

                    printWriter.println(input);

                } catch (NoSuchElementException | IllegalStateException e) {
                    // Bezpieczne zamknięcie w przypadku awarii lub użycia Ctrl+D
                    System.out.println("\n[Krytyczny błąd] Strumień konsoli został zamknięty (Ctrl+D).");
                    System.out.println("Wprowadzony do tej pory tekst został bezpiecznie zapisany w pliku: " + fileName);
                    System.exit(1);

                }
            }
            System.out.printf("Koniec wpisywania, zapisano do pliku %s", fileName);

        } catch (IOException e) {
            System.out.println("Błąd zapisu do pliku.");
            e.printStackTrace();
        }

    }

}
