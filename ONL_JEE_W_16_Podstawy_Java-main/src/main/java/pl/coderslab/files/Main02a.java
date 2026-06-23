package pl.coderslab.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

public class Main02a {

    public static void main(String[] args) {
        // Wymuszamy polską lokalizację dla spójności ewentualnych komunikatów
        Locale.setDefault(Locale.of("pl", "PL"));

        // Uruchomienie metody odczytującej plik
        readTextFromFile();
    }

    /**
     * Odczytuje zawartość pliku text1.txt linia po linii i wypisuje ją na konsoli.
     */
    public static void readTextFromFile() {
        String fileName = "text4.txt";
        System.out.println("=== Zawartość pliku " + fileName + " ===\n");

        // Stosujemy łańcuch strumieni w try-with-resources:
        // FileReader (otwiera plik do odczytu) -> BufferedReader (buforuje dla wydajności i daje metodę readLine)
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

            // Pętla czyta plik linia po linii.
            // Metoda reader.readLine() zwraca tekst linii lub wartość 'null', gdy plik się skończy.
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("\n=== Koniec pliku ===");

        } catch (FileNotFoundException e) {
            // Ten blok wykona się, jeśli plik text1.txt nie istnieje w głównym katalogu projektu
            System.out.println("Błąd: Nie znaleziono pliku o nazwie: " + fileName);
            System.out.println("Upewnij się, że plik został wcześniej utworzony przez program zapisujący.");
        } catch (IOException e) {
            // Ten blok łapie inne błędy wejścia/wyjścia (np. uszkodzenie pliku w trakcie odczytu)
            System.out.println("Wystąpił błąd podczas odczytywania pliku: " + fileName);
            e.printStackTrace();
        }
    }
}
