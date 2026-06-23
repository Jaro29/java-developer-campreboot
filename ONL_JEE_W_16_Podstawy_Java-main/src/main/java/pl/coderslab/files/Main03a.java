package pl.coderslab.files;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main03a {

    public static void main(String[] args) {
        // Wymuszamy polską lokalizację dla komunikatów wyświetlanych w konsoli
        Locale.setDefault(Locale.of("pl", "PL"));

        String fileName = "text2.txt";
        sumValidNumbersFromFile(fileName);
    }

    public static void sumValidNumbersFromFile(String fileName) {
        System.out.printf("=== Wczytywanie pliku %s, parsowanie zawartości... ===%n", fileName);
        double sum = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            // Czytamy plik linia po linii
            while ((line = reader.readLine()) != null) {

                // Używamy pod-skanera do przetworzenia bieżącej linii tekstu
                try (Scanner lineScanner = new Scanner(line)) {
                    // Instrukcja dla skanera: separatorem elementów jest przecinek LUB dowolne białe znaki (spacje/tabulacje)
                    // Wyrażenie [, \s]+ oznacza: jeden lub więcej przecinków/spacji pod rząd
                    lineScanner.useDelimiter("[,\\s]+");
                    // Zmuszamy pod-skaner do czytania liczb z kropką (format amerykański obecny w pliku)
                    lineScanner.useLocale(Locale.US);

                    // Skaner idzie po linii "słowo po słowie" (token po tokenie)
                    while (lineScanner.hasNext()) {
                        if (lineScanner.hasNextDouble()) {
                            sum += lineScanner.nextDouble(); // Jeśli to poprawna liczba, dodajemy do sumy
                        } else {
                            lineScanner.next(); // Jeśli to tekst (np. "aa"), pomijamy go i idziemy dalej
                        }
                    }
                }
            }

            // Wyświetlenie wyniku na samym końcu - tylko w przypadku sukcesu odczytu pliku
            System.out.printf("=== Suma liczb zawartych w pliku %s wynosi %.2f ===%n", fileName, sum);

        } catch (FileNotFoundException e) {
            System.out.println("Błąd: Nie znaleziono pliku o nazwie: " + fileName);
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas odczytywania pliku: " + fileName);
            e.printStackTrace();
        }
    }
}
