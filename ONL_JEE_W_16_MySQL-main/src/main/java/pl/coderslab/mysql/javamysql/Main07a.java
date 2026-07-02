package pl.coderslab.mysql.javamysql;

import org.apache.commons.lang3.ArrayUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static pl.coderslab.mysql.javamysql.DbUtil.bookExists;
import static pl.coderslab.mysql.javamysql.Query.*;

public class Main07a {

    static final String[] VALID_OPTIONS = {"d", "u", "e", "x"};
    static final String[] VALID_YES_NO = {"T", "N"};

    public static void main(String[] args) {

        Locale.setDefault(Locale.of("pl", "PL"));
        System.out.println(ConsoleColors.CYAN_BOLD + "=== Katalog książek ===" + ConsoleColors.RESET);
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
                String task = readOptionString(scanner, ConsoleColors.BLUE + "Wybierz opcję:\n" + ConsoleColors.RESET +
                        "  d - dodaj książkę\n" +
                        "  u - usuń książkę\n" +
                        "  e - edytuj książkę\n" +
                        "  x - zakończ program\n" +
                        ConsoleColors.BLUE + "-> " + ConsoleColors.RESET);

                switch (task) {
                    case "d" -> addBook(scanner);
                    case "u" -> removeBook(scanner);
                    case "e" -> updateBook(scanner);
                    case "x" -> {
                        System.out.println(ConsoleColors.CYAN_BOLD + "Do zobaczenia!" + ConsoleColors.RESET);
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
                System.out.println(ConsoleColors.RED + "-> Książka o ID " + id + " nie istnieje. Spróbuj ponownie." + ConsoleColors.RESET);
            }

            String message = ConsoleColors.YELLOW + "Czy na pewno chcesz usunąć tę książkę? (T/N)\n-> " + ConsoleColors.RESET;

            if (readYesNoString(scanner, message).equalsIgnoreCase("N")) {
                System.out.println(ConsoleColors.YELLOW + "Anulowano usuwanie." + ConsoleColors.RESET);
                return; // Wyjście z metody i automatyczny powrót do pętli w runMenu()
            } else {
                DbUtil.remove(conn, "books", "book_id", id);
                System.out.println(ConsoleColors.GREEN + "-> Książka została usunięta." + ConsoleColors.RESET);
            }
        } catch (SQLException e) {
            System.out.println(ConsoleColors.RED + "-> Błąd podczas usuwania książki." + ConsoleColors.RESET);
            e.printStackTrace();
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
                System.out.println(ConsoleColors.RED + "-> Książka o ID " + id + " nie istnieje. Spróbuj ponownie." + ConsoleColors.RESET);
            }
            String title = readString(scanner, "Podaj nowy tytuł: ");
            String price = String.valueOf(readPositiveDouble(scanner, "Podaj nową cenę: "));
            DbUtil.update(conn, title, price, id);
            System.out.println(ConsoleColors.GREEN + "-> Książka została zaktualizowana." + ConsoleColors.RESET);
        } catch (SQLException e) {
            System.out.println(ConsoleColors.RED + "-> Błąd podczas aktualizacji książki." + ConsoleColors.RESET);
            e.printStackTrace();
        }
        listBooks();
    }

    static void addBook(Scanner scanner) {
        try (Connection conn = DbUtil.connect()) {

            String title = readString(scanner, "Podaj tytuł: ");
            String price = String.valueOf(readPositiveDouble(scanner, "Podaj cenę: "));
            DbUtil.insert(conn, INSERT_BOOK_QUERY, title, price);
            System.out.println(ConsoleColors.GREEN + "-> Dodano książkę: " + title + ConsoleColors.RESET);
        } catch (SQLException e) {
            System.out.println(ConsoleColors.RED + "-> Błąd zapisu do bazy danych." + ConsoleColors.RESET);
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
                        System.out.println(ConsoleColors.YELLOW + "-> Wskazówka: Pole nie może być puste." + ConsoleColors.RESET);
                        consecutiveEnters = 0;
                    }
                    continue;
                }
                if (!isValidYesNo(input)) {
                    System.out.println(ConsoleColors.RED + "Błąd! Wpisz T lub N." + ConsoleColors.RESET);
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
                        System.out.println(ConsoleColors.YELLOW + "-> Wskazówka: Pole nie może być puste." + ConsoleColors.RESET);
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
            System.out.println(ConsoleColors.RED + "Błąd: cena musi być większa od zera." + ConsoleColors.RESET);
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
                        System.out.println(ConsoleColors.YELLOW + "Wskazówka: Musisz wprowadzić wartość liczbową." + ConsoleColors.RESET);
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
                System.out.println(ConsoleColors.RED + "Błąd: wprowadzona wartość nie jest poprawną liczbą." + ConsoleColors.RESET);

            } catch (NoSuchElementException | IllegalStateException e) {
                handleClosedStream(e);
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
                        System.out.println(ConsoleColors.YELLOW + "-> Wskazówka: Pole nie może być puste." + ConsoleColors.RESET);
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
                        System.out.println(ConsoleColors.YELLOW + "-> Wskazówka: Pole nie może być puste." + ConsoleColors.RESET);
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
                            System.out.println(ConsoleColors.RED + "Błąd: identyfikator nie może być liczbą ujemną." + ConsoleColors.RESET);
                            continue;
                        }
                    }
                }
                System.out.println(ConsoleColors.RED + "Błąd: wprowadzona wartość nie jest poprawną liczbą całkowitą." + ConsoleColors.RESET);

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
        System.out.println(ConsoleColors.RED + "\n[Krytyczny błąd] Strumień konsoli został zamknięty (Ctrl+D). Zamykanie programu..." + ConsoleColors.RESET);
        System.exit(1);
    }
}