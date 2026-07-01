package pl.coderslab.mysql.javamysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static pl.coderslab.mysql.javamysql.Query.INSERT_CUSTOMER_QUERY;

public class Main03 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String name = readString(scanner, "Podaj imię i nazwisko: ");
            String email = readString(scanner, "Podaj email: ");
            addCustomer(name, email);
        }
    }

    static void addCustomer(String name, String email) {
        try (Connection conn = DbUtil.connect()) {
            DbUtil.insert(conn, INSERT_CUSTOMER_QUERY, name, email);
            System.out.printf("-> Dodano klienta: %s", name);
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("-> Błąd: klient z tym emailem już istnieje.");
        } catch (SQLException e) {
            System.out.println("-> Błąd zapisu do bazy danych.");
            e.printStackTrace();
        }
    }

    /**
     * Metoda pomocnicza: pobiera tekst od użytkownika i dba o to, by nie był pusty.
     */
    @SuppressWarnings("SameParameterValue")
    private static String readString(Scanner scanner, String message) {
        int consecutiveEnters = 0;

        while (true) {
            System.out.print(message);

            try {
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    consecutiveEnters++;
                    if (consecutiveEnters >= 2) {
                        System.out.println("-> Wskazówka: Pole nie może być puste.");
                        consecutiveEnters = 0;
                    }
                    continue;
                }
                return input;

            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("\n[Krytyczny błąd] Strumień konsoli został zamknięty (Ctrl+D). Zamykanie programu...");
                System.exit(1);
            }
        }
    }
}
