package pl.coderslab.collections;

import java.util.ArrayList;
import java.util.List;

public class Main03 {

    public static void main(String[] args) {
        List<City> list = initialize();
//        firstSubList(list,1,3);
        secondSubList(list,2,4);
        System.out.println(firstSubList(list,1,3));
    }

    public static List<City> initialize() {
        City elblag = new City("Elbląg", 105000);
        City gdansk = new City("Gdańsk", 335000);
        City warszawa = new City("Warszawa", 2205000);
        City ketrzyn = new City("Kętrzyn", 30000);
        City wroclaw = new City("Wrocław", 415000);

        List<City> cityList = new ArrayList<>();
        cityList.add(elblag);
        cityList.add(gdansk);
        cityList.add(warszawa);
        cityList.add(wroclaw);
        cityList.add(ketrzyn);

        return cityList;
    }

    public static List<City> firstSubList(List<City> list, int start, int end) {
        List<City> citySubList = new ArrayList<>();
        for (int i = start; i < end; i++) {
            citySubList.add(list.get(i));
        }
        return citySubList;
    }

    public static List<City> secondSubList(List<City> list, int start, int end) {
        return list.subList(start, end);
    }
}
