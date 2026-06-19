package pl.coderslab.datainput;

import java.util.Scanner;

public class Main03 {

    public static void getData() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Podaj liczbę: ");
        int liczba = scan.nextInt();
        int sum = liczba;
        while (liczba != 0) {
//            readInt(scan,"Podaj kolejną liczbę");
            System.out.println("Podaj kolejną liczbę: ");
            liczba = scan.nextInt();
            sum += liczba;
        }
        System.out.println(sum);
    }

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

    public static void main(String[] args) {
        getData();
    }

/*    public static void getData() {
        Scanner scan = new Scanner(System.in);
        int sum = 0;
        int i;
        for (i = 0; ; i++) {
            System.out.println("Wprowadź liczbę:");
            while (!scan.hasNextInt()) {
                scan.next();
                System.out.println("Nie wprowadziłeś liczby. Podaj liczbę.");
            }
            if (scan.nextInt() != 0)
                sum = sum + scan.nextInt();
        }

//        System.out.println("Wprowadziłeś  liczb, których suma wynosi ");
    }

    public static void main(String[] args) {
        getData();*/

}



