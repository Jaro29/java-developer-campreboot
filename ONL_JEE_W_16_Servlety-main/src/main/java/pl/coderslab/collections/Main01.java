package pl.coderslab.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main01 {

    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>();
        for (int i = 10; i < 20; i++) {
            elements.add(i);
        }
        System.out.println();
        for (int i = 0; i < elements.size(); i++) {
            System.out.print(elements.get(i) + "%");
        }

        System.out.println();
        Iterator<Integer> iterator = elements.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "-");
        }


        System.out.println();
        for (iterator = elements.iterator(); iterator.hasNext(); ) {
            System.out.print(iterator.next() + "*");
        }
        System.out.println();

        for (int i : elements) {
            System.out.print(i + "_");
        }
    }
}
