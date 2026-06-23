package pl.coderslab.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main05 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.of("pl","PL"));
        try {
            File file = new File("text5.txt");
            Scanner scan = new Scanner(file);
            String text;
            String[] textTab = new String[1];
            int i = 0;
            while (scan.hasNextLine()) {
                text = scan.nextLine();
                textTab = Arrays.copyOf(textTab, i+1);
                textTab[i] = text;
                i++;
            }
            Arrays.sort(textTab);
            System.out.println(Arrays.toString(textTab));

        } catch (FileNotFoundException e) {
            System.out.println("Gdzie jest plik? " + e);
        }
    }

}
