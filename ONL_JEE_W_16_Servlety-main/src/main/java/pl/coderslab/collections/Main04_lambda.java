package pl.coderslab.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main04_lambda {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(5, 12, 8, 15, 3));
        list.removeIf(element -> element < 10);
        System.out.println(list);

        List<String> cities = new ArrayList<>(List.of("Gdańsk", "Elbląg", "Warszawa", "Kętrzyn"));
        cities.removeIf(city -> city.length() < 7);
/*
Stwórz mapę Map<String, Integer> cityPopulation [6].
Dodaj dwa wpisy, np. "Gdańsk" -> 335000 i "Kętrzyn" -> 30000 [6].
Użyj metody .forEach(...) z dwoma parametrami (key, value) [6], aby wypisać na konsoli tekst w formacie:
Miasto Gdańsk ma 335000 mieszkańców.
(Podpowiedź: lewa strona lambdy dla mapy przyjmuje dwa parametry w nawiasie okrągłym: (klucz, wartosc) -> ...).
 */
        Map<String, Integer> cityPopulation = new HashMap<>();
        cityPopulation.put("Gdańsk", 335000);
        cityPopulation.put("Kętrzyn", 30000);

        cityPopulation.forEach(
                (miasto, liczba) ->
                        System.out.println("Miasto " + miasto + " ma " + liczba + " mieszkańców.")
        );
    }
}
