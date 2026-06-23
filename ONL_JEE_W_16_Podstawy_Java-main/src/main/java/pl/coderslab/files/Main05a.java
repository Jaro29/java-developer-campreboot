package pl.coderslab.files;

import java.io.*;
import java.util.Arrays;
import java.util.Locale;

public class Main05a {

    public static void main(String[] args) {
        Locale.setDefault(Locale.of("pl", "PL"));
        sortLanguages();
    }

    public static void sortLanguages() {
        String fileName = "text5.txt";
        String[] lineArray = new String[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {

                lineArray = Arrays.copyOf(lineArray, count + 1);
                lineArray[count] = line;
                count++;
            }

            Arrays.sort(lineArray);

        } catch (IOException e) {
            System.out.println("Błąd odczytu pliku: " + e.getMessage());
        }
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {

            for (String str : lineArray) {

                printWriter.println(str);
            }
        } catch (IOException e) {
            System.out.println("Błąd odczytu pliku: " + e.getMessage());
        }
    }
}

