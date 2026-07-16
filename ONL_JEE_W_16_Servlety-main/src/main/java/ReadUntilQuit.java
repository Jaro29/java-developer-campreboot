import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Wzorzec: while(true) + sentinel value ("quit") jako warunek wyjścia z pętli.
 * Wyciągnięte z zadania Main01 (25 czerwca 2026) - notatnik konsolowy zapisujący
 * kolejne linie do pliku, aż użytkownik wpisze "quit".
 *
 * KLUCZOWE ELEMENTY:
 * 1) while (true) + break - pętla nieskończona, przerywana WEWNĄTRZ warunkiem.
 * 2) .trim().equalsIgnoreCase("quit") - ignorujemy wielkość liter i spacje
 *    dookoła, ale samego wpisanego tekstu NIE przycinamy (.trim()), żeby nie
 *    zgubić celowych spacji użytkownika na początku/końcu linii.
 * 3) break jest PRZED zapisem do pliku - dzięki temu słowo "quit" nigdy
 *    nie trafia do zapisanych danych.
 * 4) Wielozasobowy try-with-resources (Scanner + FileWriter naraz, po średniku).
 */
public class ReadUntilQuit {

    public static void main(String[] args) {
        Locale.setDefault(Locale.of("pl", "PL"));
        saveTextToFile();
    }

    public static void saveTextToFile() {
        System.out.println("=== Notatnik konsolowy ===");
        System.out.println("Wpisuj tekst (każdy Enter to nowa linia).");
        System.out.println("Wpisz 'quit', aby zakończyć i zapisać plik.\n");

        String fileName = "text1.txt";

        // Try-with-resources z dwoma zasobami rozdzielonymi średnikiem -
        // Java zamknie je w odwrotnej kolejności (najpierw plik, potem konsolę).
        try (Scanner scanner = new Scanner(System.in);
             FileWriter writer = new FileWriter(fileName)) {

            int consecutiveEnters = 0; // licznik pustych Enterów - tylko na podpowiedź w UI

            while (true) {
                System.out.print("> ");

                try {
                    String input = scanner.nextLine(); // BEZ .trim() - zachowujemy celowe spacje

                    // 1. WARUNEK WYJŚCIA - sprawdzany jako pierwszy, PRZED zapisem
                    if (input.trim().equalsIgnoreCase("quit")) {
                        break; // "quit" nigdy nie trafia do pliku
                    }

                    // 2. Pusta linia (sam Enter) - dozwolona, ale liczymy ją dla podpowiedzi
                    if (input.isEmpty()) {
                        consecutiveEnters++;
                        if (consecutiveEnters >= 3) {
                            System.out.println("-> Wskazówka: Wpisz 'quit', aby zakończyć.");
                            consecutiveEnters = 0;
                        }
                    } else {
                        consecutiveEnters = 0;
                    }

                    // 3. Zapis linii do pliku (dopiero PO sprawdzeniu warunku wyjścia)
                    writer.write(input + "\n");

                } catch (NoSuchElementException | IllegalStateException e) {
                    // Ctrl+D - to, co już zapisano do pliku, zostaje bezpiecznie zachowane
                    System.out.println("\n[Krytyczny błąd] Strumień konsoli zamknięty (Ctrl+D).");
                    System.out.println("Tekst wpisany do tej pory został zapisany w: " + fileName);
                    System.exit(1);
                }
            }

            System.out.println("\nZakończono. Dane zapisane w pliku: " + fileName);

        } catch (IOException e) {
            System.out.println("Błąd krytyczny: Nie można zapisać pliku " + fileName);
        }
    }

    // ==========================================================
    // WARIANT PROSTSZY (bez zapisu do pliku) - tylko zbieranie danych do listy,
    // ten sam mechanizm "quit" jako sentinel.
    // ==========================================================
    public static void collectUntilQuit() {
        try (Scanner scanner = new Scanner(System.in)) {
            java.util.List<String> lines = new java.util.ArrayList<>();

            System.out.println("Wpisuj dane, 'quit' kończy wprowadzanie:");
            while (true) {
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("quit")) {
                    break;
                }
                lines.add(input);
            }
            System.out.println("Zebrano " + lines.size() + " linii: " + lines);
        }
    }
}