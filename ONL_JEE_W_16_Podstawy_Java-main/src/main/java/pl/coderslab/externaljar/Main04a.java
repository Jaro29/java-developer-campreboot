package pl.coderslab.externaljar;

import org.apache.commons.lang3.StringUtils;

public class Main04a {
    public static void main(String[] args) {
        // Popularne zdanie-palindrom (z dużymi literami i spacjami)
        String zdanie = "Kobyła ma mały bok";

        // 1. Usuwamy spacje i zamieniamy wszystkie litery na małe
        String oczyszczonyTekst = StringUtils.deleteWhitespace(zdanie).toLowerCase();
/*
        // Zastąp każdy biały znak (\\s) pustym ciągiem znaków ("")
        String bezSpacji = zdanie.replaceAll("\\s+", "");
*/

        // 2. Odwracamy oczyszczony tekst wspak
        String tekstWspak = StringUtils.reverse(oczyszczonyTekst);

        // 3. Porównujemy obie wersje (zwykła metoda .equals())
        boolean czyPalindrom = oczyszczonyTekst.equals(tekstWspak);

        // Wyświetlamy wyniki
        System.out.println("Oryginał:        " + zdanie);
        System.out.println("Po oczyszczeniu: " + oczyszczonyTekst);
        System.out.println("Tekst wspak:     " + tekstWspak);
        System.out.println("Czy palindrom?   " + (czyPalindrom ? "TAK" : "NIE"));
    }
}
