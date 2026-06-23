package pl.coderslab.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.of("pl", "PL"));
        readFile();
    }
    public static void readFile(){

        System.out.println("Program wypisze wszystkie linie tekstu z pliku 'text1.txt'");

        File file = new File("text1.txt");

        try{
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
