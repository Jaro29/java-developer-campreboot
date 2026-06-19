package pl.coderslab.homeworks.multiarrays;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Main02 {

    public static int[] minimum(int[][] arr){
        int[] arrMin=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Arrays.sort(arr[i]);
            arrMin[i] = arr[i][0];
        }


        return arrMin;
    }

    public static void main(String[] args) {
        log.info(Arrays.toString(minimum(new int[][]{{0, 2, 3, 5}, {3, 5, 8, 1,}, {93, 44, 22, 32}})));

    }

}
