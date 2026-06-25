package pl.coderslab.arrays;

import java.util.Arrays;
import java.util.Random;

public class Main02 {

    public static void main(String[] args) {

        int[] randNumbers = new int[20];
        Random rand = new Random();
        for (int i = 0; i < randNumbers.length; i++) {
            randNumbers[i] = rand.nextInt(101);
        }
        int min = randNumbers[0];
        for (int i = 0; i < randNumbers.length; i++) {
            if (randNumbers[i] < min) {
                min = randNumbers[i];
            }
        }


        System.out.print(Arrays.toString(randNumbers));
        System.out.print("\nNajmniejsz liczba to: ");
        System.out.println(min);

        // Sortowanie bąbelkowe
        for (int i = 0; i < randNumbers.length - 1; i++) {
            for (int j = 0; j < randNumbers.length - 1 - i; j++) {
                if (randNumbers[j] > randNumbers[j + 1]) {
                    int temp = randNumbers[j];
                    randNumbers[j] = randNumbers[j + 1];
                    randNumbers[j + 1] = temp;
                }
            }
        }
        System.out.print("\nposortowana tablica:\n");
        System.out.print(Arrays.toString(randNumbers));

    }
}
/*
Random rand = new Random();
int a = rand.nextInt(11);

 */