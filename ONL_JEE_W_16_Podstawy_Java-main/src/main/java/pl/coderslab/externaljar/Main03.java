package pl.coderslab.externaljar;

import org.apache.commons.lang3.StringUtils;
import java.util.Locale;

public class Main03 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.of("pl", "PL"));

        // Przykładowa tablica do przetestowania metody
        String[] words = {"Java", "Developer", "Camp", "Reboot"};

        // Wywołanie metody i zapis wyniku
        String result = stringFromArray(words);

        // Wyświetlenie połączonego tekstu w konsoli
        System.out.println("Połączony tekst: " + result);
    }

    /**
     * Łączy wszystkie elementy tablicy String[] w jeden ciąg znaków.
     *
     * @param str Tablica tekstów do połączenia
     * @return Napis powstały z połączenia wszystkich elementów
     */
    public static String stringFromArray(String[] str) {
        // Zabezpieczenie przed błędem NullPointerException:
        // Jeśli tablica jest pusta lub nie została zainicjalizowana, zwracamy pusty ciąg znaków.
        if (str == null || str.length == 0) {
            return "";
        }

        // Używamy gotowej metody z Apache Commons Lang.
        // StringUtils.join(tablica, separator) łączy elementy, dodając między nimi wskazany znak.
        // Jeśli chcesz połączyć teksty bez żadnych przerw, jako separator podaj pusty cudzysłów "".
        // Jeśli wolałbyś separację spacją, wpisz " ".
        return StringUtils.join(str, "***");
    }
}
