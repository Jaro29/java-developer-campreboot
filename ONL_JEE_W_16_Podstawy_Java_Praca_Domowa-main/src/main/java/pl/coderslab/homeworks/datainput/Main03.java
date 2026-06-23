package pl.coderslab.homeworks.datainput;


import java.util.Arrays;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main03 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.of("pl", "PL"));
        getPersonalInfo();
//        System.out.println(Arrays.toString(getPersonalInfo()));

    }

    public static void getPersonalInfo() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Tworzenie bazy danych osobowych. ===");
            System.out.println("=== wpisanie \"quit\" jako nazwisko - koniec wprowadzania danych. ===");
            String[][] personalData = new String[1][4];
            int row = 0;
            while (true) {

                String lastName = readString(scanner, "Podaj nazwisko: ");
                if (lastName.equalsIgnoreCase("quit")) {
                    break;
                }
                if (row == personalData.length) {
                    personalData = Arrays.copyOf(personalData, personalData.length + 1);

                }
                personalData[row] = new String[4];
                personalData[row][0] = lastName;
                personalData[row][1] = readString(scanner, "Podaj imię: ");
                personalData[row][2] = readString(scanner, "Podaj rok urodzenia (np: 2001): ");
                personalData[row][3] = readString(scanner, "Podaj płeć (kobieta - K, mężczyzna - M): ");
                row++;
//                return personalData;
            }
            System.out.println("\n=== Zapisana macierz danych ===");
            for (int i = 0; i < personalData.length; i++) {
                System.out.printf("Osoba %d -> %s %s, ur. %s, płeć: %s%n",
                        i + 1, personalData[i][0], personalData[i][1], personalData[i][2], personalData[i][3]);
            }
        }

    }

    @SuppressWarnings("SameParameterValue") // Informuje IDE, że celowo przekazujemy tu stały tekst
    private static String readString(Scanner scanner, String message) {
        int consecutiveEnters = 0;
        while (true) {
            System.out.println(message);
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    consecutiveEnters++;
                    if (consecutiveEnters >= 2) {
                        System.out.println("-> Wskazówka: Pole nie może być puste. " + message);
                        consecutiveEnters = 0;
                    }
                    continue;
                }
                return input;

            } catch (NoSuchElementException | IllegalStateException e) {
                // Ten blok łapie błąd systemowy, gdy np. użytkownik zamknie konsolę skrótem Ctrl+D.
                // Dzięki temu program nie zawiesza się w nieskończoność, tylko bezpiecznie się wyłącza.
                System.out.println("\n[Krytyczny błąd] Strumień konsoli został zamknięty (Ctrl+D). Zamykanie programu...");
                System.exit(1); // Wyłączenie programu ze statusem błędu (1)
            }
        }


    }

}
