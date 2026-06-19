package pl.coderslab.multiarrays;

public class Main02 {

    public static void main(String[] args) {

        int[][] task2Array = {
                {2, 3, 4},
                {12, 32, 12, 11},
                {3, 2, 1, 4, 5},
                {5, 1, 6, 7, 8}};
        for (int[] ints : task2Array) {
            System.out.print(ints.length + " ");
        }
        System.out.println();
        for (int[] ints : task2Array) {
            for (int anInt : ints) {

                System.out.print(anInt + " ");
            }
        }
    }

}
