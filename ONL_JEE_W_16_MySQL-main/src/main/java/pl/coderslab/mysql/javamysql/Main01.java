package pl.coderslab.mysql.javamysql;

import java.sql.Connection;
import java.sql.SQLException;

public class Main01 {

    public static void main(String[] args) {
        System.out.println("Próba nawiązania połączenia za pomocą klasy DbUtil...");

        // Połączenie otwieramy wewnątrz nawiasu try (...).
        // Dzięki temu zostanie ono automatycznie zamknięte po wyjściu z tego bloku.
        try (Connection connection = DbUtil.connect()) {

            if (connection != null && !connection.isClosed()) {
                System.out.println("Połączenie nawiązane pomyślnie!");
                System.out.println("Twoja baza danych bookstore_db jest gotowa do pracy.");
            }

        } catch (SQLException e) {
            System.err.println("Błąd! Nie udało się nawiązać połączenia z bazą danych.");
            System.err.println("Szczegóły błędu SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }
}