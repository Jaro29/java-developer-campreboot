package pl.coderslab.setmap;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main01 {

    public static void main(String[] args) {
        // 1. Tworzymy Scanner do pobierania danych z konsoli
        Scanner scanner = new Scanner(System.in);

        // 2. Tworzymy zbiór (Set) – elementy w nim nie mogą się powtarzać
        Set<String> elements = new HashSet<>();

        // 3. Licznik wszystkich podanych napisów
        int count = 0;

        System.out.println("Wpisuj dowolne teksty. Wpisanie 'exit' zakończy program.");

        // 4. Pętla główna – działa dopóki użytkownik nie wpisze 'exit'
        while (true) {
            System.out.print("Wpisz tekst: ");
            String input = scanner.nextLine().trim();

            // Warunek wyjścia z pętli (ignorujemy wielkość liter dla wygody)
            if (input.equalsIgnoreCase("exit")) {
                break; // Kończymy pętlę i przechodzimy do podsumowania
            }

            // Zwiększamy licznik wszystkich wpisów
            count++;

            // Dodajemy element do zbioru.
            // Jeśli taki element już istnieje, Set po prostu go zignoruje!
            elements.add(input);
        }

        // 5. Zamykamy scanner po wyjściu z pętli
        scanner.close();

        // 6. Wypisujemy podsumowanie na konsolę
        System.out.println("\n--- PODSUMOWANIE ---");
        System.out.println("Podanych napisów: " + count + ", Rozmiar kolekcji: " + elements.size());
    }
}
