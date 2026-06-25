package pl.coderslab.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main05 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.of("pl", "PL"));
        File file = new File("text5.txt");
        try (Scanner scan = new Scanner(file)) {

            String[] textTab = new String[0];
            int i = 0;
            while (scan.hasNextLine()) {
                String text = scan.nextLine().trim();
                textTab = Arrays.copyOf(textTab, i + 1);
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
