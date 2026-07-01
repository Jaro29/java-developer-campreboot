package pl.coderslab.mysql.javamysql;

import java.sql.Connection;
import java.sql.SQLException;

import static pl.coderslab.mysql.javamysql.Query.PRINT_MORE_EXPENSIVE_THAN_AVG_QUERY;

public class Main06 {
    public static void main(String[] args) {
        try (Connection conn = DbUtil.connect()) {
            DbUtil.printData(conn, PRINT_MORE_EXPENSIVE_THAN_AVG_QUERY,"book_id","title","price");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
