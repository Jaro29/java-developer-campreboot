package pl.coderslab.setmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main03 {

    public static void main(String[] args) {
        List<Country> countries = initialize();
        Map<String, Country> countryMap = getMap(countries);
        countryMap.forEach((capital, country) ->
                System.out.printf("%s - %s%n", capital, country.name));
    }

    public static Map<String, Country> getMap(List<Country> list) {
        Map<String, Country> countryMap = new HashMap<>();
        for (Country country : list) {
            countryMap.put(country.capital, country);
        }
        return countryMap;
    }

    public static List<Country> initialize() {
        Country country1 = new Country("Polska", "Warszawa");
        Country country2 = new Country("Czechy", "Praga");
        Country country3 = new Country("Niemcy", "Berlin");
        Country country4 = new Country("Hiszpania", "Madryt");
        Country country5 = new Country("Włochy", "Rzym");
        List<Country> countries = new ArrayList<>();
        countries.add(country1);
        countries.add(country2);
        countries.add(country3);
        countries.add(country4);
        countries.add(country5);

        return countries;
    }
}
