package pl.coderslab.mysql.javamysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BatabaseConnector {

    public static final String JDBC_URL = "jdbc:mariadb://localhost:3306/bookstore_db";
    public static final String USER = "root";
    public static final String PASSWORD = "letmein";

    public static void main(String[] args) {
        // Zapytanie SQL, które przed chwilą poprawiliśmy
        String sqlQuery = "SELECT * FROM books WHERE price > 30 ORDER BY price DESC";

        System.out.println("Connecting to the database...");

        // Try-with-resources automatycznie zamknie Connection, PreparedStatement i ResultSet
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            System.out.println("Connection established successfully!\n");
            System.out.println("--- Books more expensive than 30.00 zł ---");

            while (resultSet.next()) {
                // Pobieramy dane z kolumn na podstawie ich nazw w bazie danych
                int id = resultSet.getInt("book_id");
                String title = resultSet.getString("title");
                double price = resultSet.getBigDecimal("price").doubleValue();

                // Formatowane wypisywanie wyników na konsolę
                System.out.printf("ID: %-4d | Title: %-30s | Price: %.2f zł%n", id, title, price);
            }

        } catch (SQLException e) {
            System.err.println("A database error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
