package pl.coderslab.mysql.javamysql;

import java.sql.Connection;
import java.sql.SQLException;


public class Main02 {

    public static void main(String[] args) {
        try (Connection conn = DbUtil.connect()) {

            String insertBook = "INSERT INTO books (title, price) VALUES (?, ?)";
            DbUtil.insert(conn, insertBook, "Hobbit", String.valueOf(35.00));
            DbUtil.insert(conn, insertBook, "Diuna", String.valueOf(45.00));

            String insertCustomer = "INSERT INTO customers (name, email) VALUES (?, ?)";
            DbUtil.insert(conn, insertCustomer, "Piotr Langer", "piotr.langer@example.com");
            DbUtil.insert(conn, insertCustomer, "Aleksandra Gorąca", "ola.hot@example.com");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}