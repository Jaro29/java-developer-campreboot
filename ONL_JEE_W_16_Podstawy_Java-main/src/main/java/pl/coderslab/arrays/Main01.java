package pl.coderslab.arrays;

public class Main01 {

    public static void main(String[] args) {
        int[] mineTab = new int[50];
        for (int i = 0; i < 50; i++) {
            mineTab[i] = i;
        }
        for (int i = 1; i <= mineTab.length; i++) {

            if (i <= 10) {
                System.out.print("0" + (i - 1) + ", ");
            } else {
                System.out.print((i - 1) + ", ");
            }
            if (i % 10 == 0) {
                System.out.println();
            }

        }
    }
}
