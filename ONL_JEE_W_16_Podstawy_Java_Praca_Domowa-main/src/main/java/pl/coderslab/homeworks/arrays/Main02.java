package pl.coderslab.homeworks.arrays;


public class Main02 {

    public static void main(String[] args) {

        System.out.println(contains(new int[]{0, 1, 2, 3, 4}, 4));
    }

    public static boolean contains(int[] arr, int element) {

        for (int arrEl : arr) {
            if (arrEl == element) {
                return true;
            }
        }
        return false;
    }
}
