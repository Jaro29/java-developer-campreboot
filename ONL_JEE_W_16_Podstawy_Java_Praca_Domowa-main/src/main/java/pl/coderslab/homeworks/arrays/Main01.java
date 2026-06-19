package pl.coderslab.homeworks.arrays;


import java.util.Arrays;

public class Main01 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(append(new int[]{0,1,2,3,4})));
// {0,1,2,3,4} length = 5
    }

    public static int[] append(int[] arr) {
        int[] tempArr = Arrays.copyOf(arr, 2 * arr.length);
        for (int i = arr.length; i < tempArr.length; i++) {
            tempArr[i]=arr[tempArr.length-i-1];
        }
        return tempArr;
    }
}
