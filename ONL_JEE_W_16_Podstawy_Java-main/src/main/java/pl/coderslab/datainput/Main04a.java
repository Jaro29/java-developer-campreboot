package pl.coderslab.datainput;

import java.util.Scanner;

public class Main04a {

    public static void rowsColumns() {

        Scanner scan = new Scanner(System.in);

        System.out.print("Podaj liczbę wierszy: ");

        int rows = scan.nextInt();

        System.out.print("Podaj liczbę kolumn: ");

        int columns = scan.nextInt();

        int[][] array = new int[rows][columns];

        int sum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                System.out.printf("Podaj wartość dla [%d][%d]: ", i, j);
                array[i][j] = scan.nextInt();

                sum += array[i][j];
            }
        }

        System.out.println("Suma elementów: " + sum);
    }


    public static void main(String[] args) {
        rowsColumns();
    }
}
