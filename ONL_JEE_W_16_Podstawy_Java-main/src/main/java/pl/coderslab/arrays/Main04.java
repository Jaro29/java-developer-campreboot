package pl.coderslab.arrays;

import java.util.Arrays;
import java.util.Random;

public class Main04 {

    public static void main(String[] args) {
        int[] numbers = new int[10];

        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }
        System.out.println(Arrays.toString(numbers));

        int[] reverse = new int[numbers.length];
        int j = numbers.length - 1;
        for (int i = 0; i < reverse.length; i++) {
            reverse[i] = numbers[j];
            j = j - 1;
        }
        System.out.println(Arrays.toString(reverse));

    }
}
