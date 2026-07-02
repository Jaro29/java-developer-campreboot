package pl.coderslab.mysql.javamysql;

import org.apache.commons.lang3.ArrayUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static pl.coderslab.mysql.javamysql.DbUtil.bookExists;
import static pl.coderslab.mysql.javamysql.Query.*;

public class Main07 {

    static final String[] VALID_OPTIONS = {"d", "u", "e", "x"};
    static final String[] VALID_YES_NO = {"T", "N"};

    public static void main(String[] args) {

        Locale.setDefault(Locale.of("pl", "PL"));
        System.out.println("Oto książki w Twojej bazie:");
        listBooks();
        runMenu();
    }

    private static void listBooks() {
        try (Connection conn = DbUtil.connect()) {
            DbUtil.printData(conn, LIST_BOOKS_QUERY, "book_id", "title", "price");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void runMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String task = readOptionString(scanner, ConsoleColors.BLUE + "Wpisz co chcesz zrobić:\n" + ConsoleColors.RESET +
                        "dodać książkę - d\n" +
                        "usunąć książkę - u\n" +
                        "edytować książkę - e\n" +
                        "wyjść z programu - x\n" +
                        "-> ");

                switch (task) {
                    case "d" -> addBook(scanner);
                    case "u" -> removeBook(scanner);
                    case "e" -> updateBook(scanner);
                    case "x" -> {
                        System.out.println("Wyjście z programu.");
                        return;
                    }
                    default ->
                            throw new IllegalStateException(ConsoleColors.RED + "Unexpected value: " + task + ConsoleColors.RESET); // Developer guard
                }
                System.out.println();
            }
        }
    }

    private static void removeBook(Scanner scanner) {
        try (Connection conn = DbUtil.connect()) {
            int id;
            while (true) {
                id = readPositiveInt(scanner, "Podaj identyfikator książki: ");
                if (bookExists(conn, id)) {
                    break;
                }
                System.out.println("-> Książka o ID " + id + " nie istnieje. Spróbuj jeszcze raz: ");
            }

            String message = "Potwierdź, że chcesz usunąć książkę, T - tak / N - nie\n-> ";

            if (readYesNoString(scanner, message).equalsIgnoreCase("N")) {
                System.out.println("Anulowano usuwanie.");
                return; // Wyjście z metody i automatyczny powrót do pętli w runMenu()
            } else {
                DbUtil.remove(conn, "books", "book_id", id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        listBooks();
    }

    private static void updateBook(Scanner scanner) {
        try (Connection conn = DbUtil.connect()) {
            int id;
            while (true) {
                id = readPositiveInt(scanner, "Podaj identyfikator książki: ");
                if (bookExists(conn, id)) {
                    break;
                }
                System.out.println("-> Książka o ID " + id + " nie istnieje. Spróbuj jeszcze raz: ");
            }
            String title = readString(scanner, "Podaj tytuł: ");
            String price = String.valueOf(readPositiveDouble(scanner, "Podaj cenę: "));
            DbUtil.update(conn, title, price, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        listBooks();
    }

    static void addBook(Scanner scanner) {
        try (Connection conn = DbUtil.connect()) {

            String title = readString(scanner, "Podaj tytuł: ");
            String price = String.valueOf(readPositiveDouble(scanner, "Podaj cenę: "));
            DbUtil.insert(conn, INSERT_BOOK_QUERY, title, price);
            System.out.printf("-> Dodano książkę: %s%n", title);
        } catch (SQLException e) {
            System.out.println("-> Błąd zapisu do bazy danych.");
            e.printStackTrace();
        }
        listBooks();
    }

    @SuppressWarnings("SameParameterValue")
    private static String readYesNoString(Scanner scanner, String message) {
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
                if (!isValidYesNo(input)) {
                    System.out.println(ConsoleColors.RED + "Błąd! Spróbuj jeszcze raz." + ConsoleColors.RESET);
                    consecutiveEnters = 0;
                    continue;
                }
                return input;

            } catch (NoSuchElementException | IllegalStateException e) {
                handleClosedStream(e);
            }
        }
    }

    @SuppressWarnings("SameParameterValue")
    private static String readOptionString(Scanner scanner, String message) {
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
                if (!isValidOption(input)) {
                    System.out.println(ConsoleColors.RED + "Błąd! Niepoprawna opcja. Spróbuj jeszcze raz." + ConsoleColors.RESET);
                    consecutiveEnters = 0;
                    continue;
                }
                return input.toLowerCase();

            } catch (NoSuchElementException | IllegalStateException e) {
                handleClosedStream(e);
            }
        }
    }

    @SuppressWarnings("SameParameterValue")
    private static double readPositiveDouble(Scanner scanner, String message) {
        while (true) {
            double value = readDouble(scanner, message);
            if (value > 0.0) {
                return value;
            }
            System.out.println("Błąd: podałeś ujemną cenę.");
        }
    }

    public static double readDouble(Scanner scanner, String message) {
        int consecutiveEnters = 0;

        while (true) {
            System.out.print(message);

            try {
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    consecutiveEnters++;
                    if (consecutiveEnters >= 2) {
                        System.out.println("Wskazówka: Musisz wprowadzić wartość liczbową, aby przejść dalej.");
                        consecutiveEnters = 0;
                    }
                    continue;
                }
                consecutiveEnters = 0;

                try (Scanner lineScanner = new Scanner(input).useLocale(Locale.getDefault())) {
                    if (lineScanner.hasNextDouble()) {
                        double value = lineScanner.nextDouble();
                        if (!lineScanner.hasNext()) {
                            return value;
                        }
                    }
                }
                System.out.println("Błąd: Wprowadzona wartość nie jest poprawna.");

            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("Wystąpił krytyczny błąd odczytu strumienia danych.");
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
                handleClosedStream(e);
            }
        }
    }

    @SuppressWarnings("SameParameterValue")
    private static int readPositiveInt(Scanner scanner, String message) {
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
                consecutiveEnters = 0;

                try (Scanner lineScanner = new Scanner(input).useLocale(Locale.getDefault())) {
                    if (lineScanner.hasNextInt()) {
                        int value = lineScanner.nextInt();
                        if (!lineScanner.hasNext()) {
                            if (value >= 0) {
                                return value;
                            }
                            System.out.println("Błąd: Identyfikator nie jest liczbą ujemną.");
                            continue;
                        }
                    }
                }
                System.out.println("Błąd: Wprowadzona wartość nie jest poprawną liczbą całkowitą.");

            } catch (NoSuchElementException | IllegalStateException e) {
                handleClosedStream(e);
            }
        }
    }

    private static boolean isValidOption(String input) {
        if (input == null) {
            return false;
        }
        return ArrayUtils.contains(VALID_OPTIONS, input.toLowerCase());
    }

    private static boolean isValidYesNo(String input) {
        if (input == null) {
            return false;
        }
        return ArrayUtils.contains(VALID_YES_NO, input.toUpperCase());
    }

    private static void handleClosedStream(Exception e) {
        System.out.println("\n[Krytyczny błąd] Strumień konsoli został zamknięty (Ctrl+D). Zamykanie programu...");
        System.exit(1);
    }
}
