package pl.coderslab.datainput;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main01a {

    public static void main(String[] args) {
        // Ponieważ wszystkie komunikaty w naszym programie są po polsku, na sztywno
        // ustawiamy polską lokalizację. Dzięki temu Java zawsze będzie wiedziała,
        // jak interpretować np. liczby z przecinkami, niezależnie od komputera.
        Locale.setDefault(Locale.of("pl", "PL"));

        // Wywołujemy naszą główną metodę kwestionariusza
        getInfo();
    }

    /**
     * Główna metoda zadania. Pobiera dane i wyświetla podsumowanie.
     */
    public static void getInfo() {
        // Konstrukcja try-with-resources: umieszczenie Skanera w nawiasie ( ) gwarantuje,
        // że po zakończeniu tej metody Java sama go zamknie i zwolni pamięć komputera.
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Kwestionariusz osobowy ===");

            // Wywołujemy naszą bezpieczną metodę do pobrania tekstu
            String name = readString(scanner, "Poproszę o podanie imienia: ");

            // Wywołujemy naszą bezpieczną metodę do pobrania liczby dodatniej
            int age = readPositiveInt(scanner, "Poproszę o podanie wieku: ");

            // Wyświetlamy wynik na ekranie.
            // %s wstawia tekst (imię), %d wstawia liczbę (wiek), a %n to przejście do nowej linii.
            System.out.printf("\n%s ma %d lat.%n", name, age);
        }
    }

    /**
     * Metoda pomocnicza: pobiera tekst od użytkownika i dba o to, by nie był pusty.
     */
    @SuppressWarnings("SameParameterValue") // Informuje IDE, że celowo przekazujemy tu stały tekst
    private static String readString(Scanner scanner, String message) {
        // Licznik, który pamięta, ile razy pod rząd użytkownik kliknął sam klawisz Enter
        int consecutiveEnters = 0;

        // Pętla while(true) kręci się w nieskończoność, dopóki użytkownik nie poda poprawnych danych
        while (true) {
            System.out.print(message); // Wyświetlamy komunikat zachęty (np. "Poproszę o podanie imienia: ")

            try {
                // scanner.nextLine() czyta CAŁĄ linię tekstu, którą użytkownik zatwierdził Enterem.
                // .trim() na końcu automatycznie odcina przypadkowe spacje z początku i końca tekstu.
                String input = scanner.nextLine().trim();

                // Sprawdzamy, czy tekst jest pusty (czyli użytkownik kliknął sam Enter lub same spacje)
                if (input.isEmpty()) {
                    consecutiveEnters++; // Zwiększamy licznik pustych kliknięć o 1

                    // Dopiero przy drugim i każdym kolejnym pustym Enterze wyświetlamy podpowiedź
                    if (consecutiveEnters >= 2) {
                        System.out.println("-> Wskazówka: Pole nie może być puste. Wpisz swoje imię.");
                        consecutiveEnters = 0; // Resetujemy licznik, by odliczać od nowa
                    }
                    continue; // "continue" natychmiast wraca na początek pętli i ponawia pytanie
                }

                // Jeśli program dotarł tutaj, to znaczy, że tekst nie jest pusty.
                // Zwracamy go ("return" przerywa pętlę i kończy działanie tej metody pomocniczej).
                return input;

            } catch (NoSuchElementException | IllegalStateException e) {
                // Ten blok łapie błąd systemowy, gdy np. użytkownik zamknie konsolę skrótem Ctrl+D.
                // Dzięki temu program nie zawiesza się w nieskończoność, tylko bezpiecznie się wyłącza.
                System.out.println("\n[Krytyczny błąd] Strumień konsoli został zamknięty (Ctrl+D). Zamykanie programu...");
                System.exit(1); // Wyłączenie programu ze statusem błędu (1)
            }
        }
    }

    /**
     * Metoda pomocnicza: pobiera liczbę całkowitą i sprawdza, czy nie jest ujemna.
     */
    @SuppressWarnings("SameParameterValue") // Ucisza żółte ostrzeżenie w edytorze kodu
    private static int readPositiveInt(Scanner scanner, String message) {
        int consecutiveEnters = 0;

        while (true) {
            System.out.print(message);
            try {
                String input = scanner.nextLine().trim();

                // Podobnie jak przy imieniu, obsługujemy sytuację naciśnięcia samego Entera
                if (input.isEmpty()) {
                    consecutiveEnters++;
                    if (consecutiveEnters >= 2) {
                        System.out.println("-> Wskazówka: Musisz wpisać swój wiek cyframi, aby przejść dalej.");
                        consecutiveEnters = 0;
                    }
                    continue;
                }

                consecutiveEnters = 0; // Użytkownik coś wpisał, więc resetujemy licznik pustych enterów

                // Tworzymy "mini-skaner" (pod-skaner), który przeanalizuje wyłącznie wpisany tekst (zmienną input).
                // .useLocale(Locale.getDefault()) wymusza na nim przestrzeganie polskiego formatu liczb.
                try (Scanner lineScanner = new Scanner(input).useLocale(Locale.getDefault())) {

                    // hasNextInt() pyta Javę: "Czy ten wpisany tekst zaczyna się od poprawnej liczby całkowitej?"
                    if (lineScanner.hasNextInt()) {
                        int value = lineScanner.nextInt(); // Wyciągamy tę liczbę do zmiennej "value"

                        // !lineScanner.hasNext() sprawdza, czy za tą liczbą NIE MA już żadnych innych znaków.
                        // Chroni to nas przed błędami typu "23lata" czy "23.5" (program odrzuci takie wpisy).
                        if (!lineScanner.hasNext()) {

                            // Warunek biznesowy: wiek człowieka nie może być liczbą ujemną (np. -5 lat)
                            if (value >= 0) {
                                return value; // Dane idealne! Zwracamy wiek i kończymy metodę
                            }
                            System.out.println("Błąd: Wiek nie może być liczbą ujemną.");
                            continue; // Wraca na początek pętli po nową liczbę
                        }
                    }
                }

                // Ten komunikat wyświetli się, jeśli hasNextInt() dało false (np. ktoś wpisał słowo "dwadzieścia")
                System.out.println("Błąd: Wprowadzona wartość nie jest poprawną liczbą całkowitą.");

            } catch (NoSuchElementException | IllegalStateException e) {
                // Bezpieczne zamknięcie w przypadku awarii strumienia (Ctrl+D)
                System.out.println("\n[Krytyczny błąd] Strumień konsoli został zamknięty (Ctrl+D). Zamykanie programu...");
                System.exit(1);
            }
        }
    }
}
