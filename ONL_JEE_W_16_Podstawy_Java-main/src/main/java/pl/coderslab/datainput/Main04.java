package pl.coderslab.datainput;

import java.util.Scanner;

public class Main04 {

    public static void rowsColumns() {

        Scanner scan = new Scanner(System.in);

        System.out.print("Podaj liczbę wierszy: ");
        badInput(scan);
        int rows = scan.nextInt();

        System.out.print("Podaj liczbę kolumn: ");
        badInput(scan);
        int columns = scan.nextInt();

        int[][] matrix = new int[rows][columns];
//        System.out.println("Wypełniamy tabelę, podaj liczbę");


        {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.println("Wypełniamy tabelę, podaj liczbę");
                    badInput(scan);
                    matrix[i][j] = scan.nextInt();
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        System.out.println("Suma elementów tablicy wynosi: " + sum);

    }

    private static void badInput(Scanner scan) {
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("Nie wprowadziłeś liczby. Podaj liczbę.");
        }
    }

    public static void main(String[] args) {
        rowsColumns();
    }
}
