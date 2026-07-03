package pl.coderslab.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static pl.coderslab.collections.Main03.initialize;

public class Main04 {

    public static void main(String[] args) {
/*        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        ListIterator<String> listIterator = list.listIterator();

        while (listIterator.hasNext()) {
            String string = listIterator.next();
            System.out.println(string);
        }
        while (listIterator.hasPrevious()) {
            String string = listIterator.previous();
            System.out.println(string);
        }

        List<String> cities = new ArrayList<>(List.of("Gdańsk", "Elbląg", "Warszawa", "Kętrzyn"));

        City elblag = new City("Elbląg", 105000);
        City gdansk = new City("Gdańsk", 335000);
        City warszawa = new City("Warszawa", 2205000);
        City ketrzyn = new City("Kętrzyn", 30000);
        City wroclaw = new City("Wrocław", 415000);
        */
//        List<City> cities = initialize();
        List<City> cities = new ArrayList<>(List.of(
                new City("Elbląg", 105000),
                new City("Gdańsk", 335000),
                new City("Warszawa", 2205000),
                new City("Kętrzyn", 30000),
                new City("Wrocław", 415000)));
        System.out.println(reverse(cities));

    }

    public static List<City> reverse(List<City> list) {
        ListIterator<City> listIterator = list.listIterator(list.size());
        List<City> reversedList = new ArrayList<>();
        while(listIterator.hasPrevious()){
            City city = listIterator.previous();
            reversedList.add(city);
        }
        return reversedList;
    }
}
