package pl.coderslab.arrays;

import java.util.Arrays;

public class Main06 {

    public static void main(String[] args) {
        int[] numbers = {2, 3};
        int[] secondNumbers = {2, 4};
        int[] thirdNumbers = new int[numbers.length];

        for (int i = 0; i < thirdNumbers.length; i++) {
            thirdNumbers[i] = numbers[i] + secondNumbers[i];
        }
        System.out.println(Arrays.toString(thirdNumbers));
    }
}
