package pl.coderslab.files;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Main04 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.of("pl", "PL"));
        printLinesContainingWord("Javy");
    }

    public static void printLinesContainingWord(String word) {

        String fileName = "text4.txt";
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            while ((line = reader.readLine()) != null) {
                try(Scanner lineScanner = new Scanner(line)){
                    lineScanner.useDelimiter("[,.;:\\s]+");

                    while(lineScanner.hasNext()){
                        if(lineScanner.next().equalsIgnoreCase("javy")){
                            System.out.println(line);

                        }
                    }
                }

            }

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
