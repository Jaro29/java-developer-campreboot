package pl.coderslab.mysql.javamysql;

import java.sql.Connection;
import java.sql.SQLException;

import static pl.coderslab.mysql.javamysql.Query.LIST_BOOKS_QUERY;

public class Main04 {
    public static void main(String[] args) {
        try (Connection conn = DbUtil.connect()) {
            DbUtil.printData(conn, LIST_BOOKS_QUERY,"book_id","title","price");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
