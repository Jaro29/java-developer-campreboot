package pl.coderslab.homeworks.arrays;

import java.util.Arrays;

public class Main03 {

    public static int[] returnUnique(int[] arr) {
        Arrays.sort(arr);
        int[] unique = Arrays.copyOf(arr, 1);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                unique = Arrays.copyOf(unique, unique.length + 1);
                unique[unique.length - 1] = arr[i];
            }
        }
        return unique;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(returnUnique(new int[]{0, 0, 1, 2, 3, 4, 1, 2, 0, 9, 1, 5, 0, 3, 4})));
    }
}