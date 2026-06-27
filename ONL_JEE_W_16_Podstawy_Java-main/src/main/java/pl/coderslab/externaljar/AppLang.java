package pl.coderslab.externaljar;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.ArrayUtils;
import java.util.Arrays;

public class AppLang {
    public static void main(String[] args) {
        System.out.println("=== Test klasy NumberUtils ===");

        // Tradycyjnie musiałbyś pisać try-catch z Integer.parseInt(),
        // a tutaj metoda .isParsable() robi to w jednej linijce!
        String tekstLiczba = "123";
        String tekstLitery = "12a3";

        System.out.println("Czy '123' to liczba? " + NumberUtils.isParsable(tekstLiczba)); // true
        System.out.println("Czy '12a3' to liczba? " + NumberUtils.isParsable(tekstLitery)); // false


        System.out.println("\n=== Test klasy ArrayUtils ===");

        // Zwykłe tablice w Javie mają stały rozmiar. Usunięcie elementu to koszmar.
        // Zobacz, jak ArrayUtils.remove() robi to za Ciebie!
        String[] tablica = {"Ania", "Tomek", "Jan", "Kasia"};
        System.out.println("Przed usunięciem: " + Arrays.toString(tablica));

        // Usuwamy element o indeksie 1 ("Tomek")
        String[] nowaTablica = ArrayUtils.remove(tablica, 1);
        System.out.println("Po usunięciu:    " + Arrays.toString(nowaTablica));
    }
}
