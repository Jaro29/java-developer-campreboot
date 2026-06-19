package pl.coderslab.homeworks.multiarrays;


import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main03 {

    public static int[] lessMore(int[][] arr) {
        int less = 0;
        int more = 0;
        int sum = 0;
        int elem = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum = sum + arr[i][j];
            }
            elem = elem + arr[i].length;
        }
        double avg = (double) sum / elem;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > avg) {
                    more = more + 1;
                } else {
                    less = less + 1;
                }
            }
        }


//        log.info(String.valueOf(avg));
        return new int[]{less, more};
    }

    public static void main(String[] args) {

           System.out.println(Arrays.toString(lessMore(new int[][]{{0, 2, 3, 5, 9}, {3, 5, 8, 1, 10, 15}, {93, 44, 22, 32, 34, 67, 123, 129}})));


    }

}
