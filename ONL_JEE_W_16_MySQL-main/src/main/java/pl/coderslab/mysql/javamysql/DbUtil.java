package pl.coderslab.mysql.javamysql;


import java.sql.*;

import static pl.coderslab.mysql.javamysql.Query.DELETE_QUERY;

public class DbUtil {

    // 1. Statyczne zmienne konfiguracyjne połączenia
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/bookstore_db";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "letmein"; // Wpisz tutaj hasło ze swojego terminala

    // 2. Metoda statyczna zwracająca aktywne połączenie do bazy danych
    // Przekazuje wyjątek dalej (throws), aby wywołujący mógł go obsłużyć we własny sposób
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    public static void insert(Connection conn, String query, String... params) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            statement.executeUpdate();
        }
    }

    public static void printData(Connection conn, String query, String... columnNames) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                for (String columnName : columnNames) {
                    System.out.print(columnName + ": " + resultSet.getString(columnName) + " | ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void remove(Connection conn, String tableName, String idColumnName, int id) {
        String query = DELETE_QUERY.replace("tableName", tableName).replace("id", idColumnName);
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}