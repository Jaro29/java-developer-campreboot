package pl.coderslab.arrays;

import java.util.Arrays;
import java.util.Random;

public class Main05 {

    public static void main(String[] args) {
        int[] numbers = new int[10];

        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

    }
}
