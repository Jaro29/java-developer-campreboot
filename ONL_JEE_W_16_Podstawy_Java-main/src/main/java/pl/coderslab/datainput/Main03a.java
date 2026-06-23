package pl.coderslab.datainput;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main03a {

    public static void main(String[] args) {

        getData();
    }

    public static void getData() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("*** Sumowanie liczb całkowitych (wprowadź 0, aby zakończyć) ***");

            int sumData = 0;

            while (true) {

                int data = getInt(scanner, "Wprowadź dane (liczba całkowita): ");
                if (data == 0) {
//                    System.out.println("Suma wprowadzonych danych to " + sumData);
                    break;
                }
                sumData += data;
            }
            System.out.println("Suma wprowadzonych danych to " + sumData);
        }
    }

    @SuppressWarnings("SameParameterValue") // Informuje IDE, że celowo przekazujemy tu stały tekst
    private static int getInt(Scanner scanner, String message) {
        int consecutiveEnters = 0;

        while (true) {
            System.out.println(message);

            try {
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    consecutiveEnters++;
                    if (consecutiveEnters >= 2) {
                        System.out.println("-> Wskazówka: Musisz wpisać liczbę całkowitą lub 0, aby zakończyć.");
                        consecutiveEnters = 0;
                    }
                    continue;
                }
                consecutiveEnters = 0;

                try (Scanner lineScanner = new Scanner(input)) {
                    if (lineScanner.hasNextInt()) {
                        int value = lineScanner.nextInt();
                        if (!lineScanner.hasNext()) {
                            return value;
                        }
                    }
                }
                System.out.println("Błąd: Wprowadzona wartość nie jest poprawną liczbą całkowitą.");

            } catch (NoSuchElementException | IllegalStateException e) {
                // Bezpieczne zamknięcie w przypadku awarii strumienia (Ctrl+D)
                System.out.println("\n[Krytyczny błąd] Strumień konsoli został zamknięty (Ctrl+D). Zamykanie programu...");
                System.exit(1);
            }


        }
    }
}
