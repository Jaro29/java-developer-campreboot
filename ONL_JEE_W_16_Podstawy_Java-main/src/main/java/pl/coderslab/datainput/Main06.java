package pl.coderslab.datainput;

import java.util.Scanner;

public class Main06 {

    public static void main(String[] args) {
        equation();
    }

    public static void equation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nObliczanie pierwiastków równania kwadratowego ax² + bx + c = 0.\n");

        double a = readDouble(scanner, "Wprowadź a: ");
        while (a == 0) {
            System.out.println("Błąd: Współczynnik 'a' nie może być równy 0 w równaniu kwadratowym!");
            a = readDouble(scanner, "Wprowadź ponownie a (różne od 0): ");
        }
        double b = readDouble(scanner, "Wprowadź b: ");
        double c = readDouble(scanner, "Wprowadź c: ");

        System.out.printf("%.2f, %.2f, %.2f\n", a, b, c);
        double delta = Math.pow(b, 2) - (4 * a * c);
        if (delta > 0) {
            double x1 = (-b - Math.sqrt(delta)) / 2 * a;
            double x2 = (-b + Math.sqrt(delta)) / 2 * a;
            System.out.printf("Delta > 0 - równanie ma dwa różne rozwiązania rzeczywiste: x1 = %.2f oraz x2 = %.2f", x1, x2);
        } else if (delta == 0) {
            double x = -b / 2 * a;
            System.out.printf("Delta = 0 - " +
                    "równanie ma jeden pierwiastek podwójny: x = %.2f", x);
        } else {
            System.out.println("Delta < 0 - równanie nie ma rozwiązań w zbiorze liczb rzeczywistych.");
        }
    }

    /*
    1. Zapisz równanie w postaci ogólnej: a*a+bx+c = 0 wypisz współczynniki a, b, c.
    2. Oblicz deltę (Δ):
        Δ = b*b-4ac
    3. Wyznacz pierwiastki w zależności od wartości A:

        Jeśli Δ > 0
        Równanie ma dwa różne rozwiązania rzeczywiste:
        𝑥1 = −𝑏−√Δ/2𝑎
        𝑥2 = −𝑏+√Δ/2𝑎

        Jeśli Δ = 0
        Równanie ma jeden pierwiastek podwójny:
        x = -b/2𝑎

        Jeśli Δ < 0
        Równanie nie ma rozwiązań w zbiorze liczb rzeczywistych.
     */

    private static int readInt(Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }

            System.out.println("Błąd: wprowadź liczbę całkowitą.");
            scanner.next(); // usuwa niepoprawny token
        }
    }

    private static double readDouble(Scanner scanner, String message) {
        int enterCounter = 0; // Licznik pustych enterów

        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim(); // Pobiera całą linię tekstu

            // 1. Sprawdzenie, czy użytkownik nacisnął sam Enter
            if (input.isEmpty()) {
                enterCounter++;
                if (enterCounter >= 2) {
                    System.out.println("Błąd: Nie naciskaj samego Entera, wprowadź liczbę!");
                    enterCounter = 0; // Reset licznika po wyświetleniu ostrzeżenia
                }
                continue; // Przeskakuje resztę pętli i wyświetla "message" ponownie
            }

            // 2. Próba zamiany tekstu na liczbę (odpowiednik hasNextDouble)
            try {
                // Zamieniamy przecinek na kropkę, aby Java zaakceptowała format "1,4" oraz "1.4"
                input = input.replace(',', '.');
                double value = Double.parseDouble(input);
                return value; // Sukces, zwracamy liczbę
            } catch (NumberFormatException e) {
                // To się wykona, jeśli użytkownik wpisze np. litery zamiast liczby
                System.out.println("Błąd: wprowadź liczbę rzeczywistą - np: 1,4 lub 2,67 lub po prostu 4.");
                enterCounter = 0; // Reset licznika enterów, bo użytkownik coś wpisał
            }
        }
    }

/*
    private static double readDouble(Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            }

            System.out.println("Błąd: wprowadź liczbę rzeczywistą - np: 1,4 lub 2,67 lub po prostu 4.");
            scanner.next(); // usuwa niepoprawny token
        }
    }
    */
}
