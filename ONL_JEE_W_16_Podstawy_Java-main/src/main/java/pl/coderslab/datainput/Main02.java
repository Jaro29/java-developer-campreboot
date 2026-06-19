package pl.coderslab.datainput;

import java.util.Scanner;

public class Main02 {

    public static void operations() {
        System.out.println("Podaj pierwszą liczbę:");
        Scanner scan = new Scanner(System.in);
        badInput(scan);

        System.out.println("Podaj drugą liczbę:");
        int a = scan.nextInt();

        badInput(scan);
        int b = scan.nextInt();

        System.out.printf("%d plus %d wynosi: %d%n", a, b, a + b);

    }

    private static void badInput(Scanner scan) {
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("Nie wprowadziłeś liczby. Podaj liczbę.");
        }
    }

    public static void main(String[] args) {
        operations();

    }
}
