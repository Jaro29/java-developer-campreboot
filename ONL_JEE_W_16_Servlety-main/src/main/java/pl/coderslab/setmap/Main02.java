package pl.coderslab.setmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> opposites = getMap();
        int correctAnswer = 0;
        for (Map.Entry<String, String> entry : opposites.entrySet()) {
            String word = entry.getKey();
            String oppositeWord = entry.getValue();
            System.out.printf("Wpisz przeciwieństwo słowa: %s%n-> ", word);
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase(oppositeWord)) {
                correctAnswer++;
            }
        }
        scanner.close();
        System.out.println("\nPoprawnych odpowiedzi: " + correctAnswer);
    }

    public static Map<String, String> getMap() {
        Map<String, String> opposites = new HashMap<>();
        opposites.put("ciepło", "zimno");
        opposites.put("ciemno", "jasno");
        opposites.put("słodki", "kwaśny");
        opposites.put("biały", "czarny");
        opposites.put("mało", "dużo");
        return opposites;
    }
}
