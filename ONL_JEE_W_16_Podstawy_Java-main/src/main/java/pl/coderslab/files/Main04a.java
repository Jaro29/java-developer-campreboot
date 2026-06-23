package pl.coderslab.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main04a {

    public static void main(String[] args) {
        String fileName = "text4.txt";
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            while ((line = reader.readLine()) != null) {

                // Zamieniamy linię na małe litery, dzięki czemu "Javy", "JAVY" czy "javy"
                // staną się "javy". Sprawdzamy, czy w tekście znajduje się ten fragment.
                if (line.toLowerCase().contains("javy")) {
                    System.out.println(line); // Wypisujemy oryginalną linię
                }
/*
            // lub tak:
            // (?i) - ignoruj wielkość liter
            // .* - dowolna liczba dowolnych znaków
                if (line.matches("(?i).*javy.*")) {
*/
            }

        } catch (
                IOException e) {
            System.out.println("Błąd odczytu pliku: " + e.getMessage());
        }

    }
}
