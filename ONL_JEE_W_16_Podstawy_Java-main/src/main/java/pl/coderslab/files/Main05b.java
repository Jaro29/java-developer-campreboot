package pl.coderslab.files;

import java.io.*;
import java.util.Arrays;

public class Main05b {

    public static void main(String[] args) {
        sortLanguages();
    }

    public static void sortLanguages() {
        String inputFileName = "text5.txt";
        String outputFileName = "sorted_text5.txt"; // Bezpieczniejszy, nowy plik

        // Startujemy z rozmiarem 2, aby uniknąć ciągłego tworzenia tablic w pamięci
        String[] lineArray = new String[2];
        int count = 0;

        // Krok 1: Bezpieczny odczyt i dynamiczne powiększanie (strategia x2)
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    if (count == lineArray.length) {
                        lineArray = Arrays.copyOf(lineArray, lineArray.length * 2);
                    }
                    lineArray[count] = line;
                    count++;
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd odczytu pliku wejściowego: " + e.getMessage());
            return; // Przerywamy, jeśli nie udało się odczytać danych
        }

        // Krok 2: Przycięcie tablicy do faktycznego rozmiaru przed sortowaniem
        String[] finalArray = Arrays.copyOf(lineArray, count);

        // Krok 3: Super szybkie, wbudowane sortowanie Javy
        Arrays.sort(finalArray);

        // Krok 4: Zapis posortowanych danych do pliku wyjściowego
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(outputFileName)))) {
            for (String str : finalArray) {
                printWriter.println(str);
            }
            System.out.println("Sukces! Posortowana lista zapisana w: " + outputFileName);
        } catch (IOException e) {
            System.out.println("Błąd zapisu do pliku wyjściowego: " + e.getMessage());
        }
    }

}
