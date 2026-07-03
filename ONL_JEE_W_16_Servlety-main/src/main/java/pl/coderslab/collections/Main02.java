package pl.coderslab.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Main02 {

    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 30; i++) {
            elements.add(rand.nextInt(101));
//            elements.add(i, rand.nextInt(101));
        }
        System.out.println(elements);
        removeDivider(elements, 2);
        System.out.print(elements);


    }

    public static void removeDivider(List<Integer> list, int divider) {
        list.removeIf(element -> element % divider == 0);

//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            if (iterator.next() % divider == 0) {
//                iterator.remove();
//            }
//        }
    }
}
