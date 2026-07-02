package pl.coderslab.mysql.javamysql;

public class Query {
    public static final String INSERT_CUSTOMER_QUERY = "INSERT INTO customers (name, email) VALUES (?, ?)";
    public static final String INSERT_BOOK_QUERY = "INSERT INTO books (title, price) VALUES (?, ?)";
    public static final String LIST_BOOKS_QUERY = "SELECT * FROM books";
    public static final String DELETE_QUERY = "DELETE FROM tableName where id = ?";
    public static final String PRINT_MORE_EXPENSIVE_THAN_AVG_QUERY = "SELECT * FROM books WHERE price > (SELECT AVG(price) FROM books)";
    public static final String UPDATE_BOOK_QUERY = "UPDATE books SET title = ?, price = ? WHERE book_id = ?;";
    public static final String SELECT_BOOK_QUERY = "SELECT 1 FROM books WHERE book_id = ?";

}
