package pl.coderslab.mysql.javamysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static pl.coderslab.mysql.javamysql.Query.LIST_BOOKS_QUERY;

public class Main07 {
    public static void main(String[] args) {
        System.out.println("Oto książki w Twojej bazie:");
        try (Connection conn = DbUtil.connect()) {
            DbUtil.printData(conn, LIST_BOOKS_QUERY,"book_id","title","price");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void runMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String task = readString(scanner, ConsoleColors.BLUE + "Please select an option:\n" + ConsoleColors.RESET +
                        "dodaj\n" +
                        "usuń\n" +
                        "zaktualizuj\n" +
                        "wyjdź\n");

                switch (task) {
                    case "add" -> System.out.println(";addTask(scanner)");
                    case "remove" -> System.out.println("removeTask(scanner);");
                    case "update" -> System.out.println("listTasks();");
                    case "exit" -> {
                        System.out.println("exitTaskManager();");
                        return; // Terminates the menu loop, closing the scanner resources
                    }
                    default ->
                            throw new IllegalStateException(ConsoleColors.RED + "Unexpected value: " + task + ConsoleColors.RESET); // Developer guard
                }
                System.out.println();
            }
        }
    }

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
