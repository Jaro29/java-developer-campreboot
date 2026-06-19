package pl.coderslab.datainput;

import java.util.Scanner;

public class Main05 {

    public static void textLines() {

        Scanner scanner = new Scanner(System.in);
        String napis;
        System.out.print("Napisz coś: ");
        while (true) {

            napis = scanner.next();
            if (napis.equals("quit")) break;
            System.out.println(napis);
        }

    }

    public static void main(String[] args) {
        textLines();

    }
}
