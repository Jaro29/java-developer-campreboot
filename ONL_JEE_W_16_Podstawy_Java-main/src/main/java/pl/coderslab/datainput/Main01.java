package pl.coderslab.datainput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main01 {

    public static void main(String[] args) {
        getInfo();

    }

    public static void getInfo() {
        System.out.println("Podaj swoje imię:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Podaj swój wiek:");
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Podaj liczbę lat cyframi.");
        }
        int age = scanner.nextInt();
        System.out.println(name + " ma " + age + " lat.");
/*        try{
            int age = scanner.nextInt();
            System.out.println(name + " ma " + age + " lat.");

        }catch(InputMismatchException e){
            System.out.println("Podaj liczbę lat cyframi."+e);
        }
        catch (RuntimeException e) {
            throw new RuntimeException(e);
        }*/

    }
}
