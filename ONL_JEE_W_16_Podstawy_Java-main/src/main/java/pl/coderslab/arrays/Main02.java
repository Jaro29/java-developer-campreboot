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
        System.out.println();
        System.out.println(min);
    }
}
/*
Random rand = new Random();
int a = rand.nextInt(11);

 */